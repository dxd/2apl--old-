import helperTS.Update;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.Buffer;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
//import org.json.JSONTokener;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import tuplespace.ActionRequest;
import tuplespace.Position;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonToken;
import com.javadocmd.simplelatlng.LatLng;

import dataJSon.*;



public class Synchronization {

	private static String server = "http://albinoni.cs.nott.ac.uk:49992";
	private static int gameId = 3;
	
	private JSpace jspace;

	private Status status;

	private Update update;
    
	public Synchronization(JSpace jspace) {
		this.jspace = jspace;
	}
	
	private void initialize() {
		
		postJoin("email", "robot1", "runner");
		postJoin("email", "robot2", "truck");
		postJoin("email", "robot3", "controller");
		postLocation(10, new LatLng(50,-1));
		getReading(6, new LatLng(50.005,-1.005));
		
	}
	private String buildPostData(ArrayList<SimpleEntry<String, Object>> params) throws UnsupportedEncodingException{
		
		String data = "";
		for (SimpleEntry<String, Object> entry : params)
		{
			data += "&" + URLEncoder.encode(entry.getKey().toString(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue().toString(), "UTF-8");
		}
		return data;
		
	}
	
	private void PostRequest(String url, String data, Object result){
		try {
			URL ruby = new URL(server + url);
			
    	    URLConnection conn = ruby.openConnection();
    	    System.out.println(conn.toString());
    	    System.out.println(data);
    	    conn.setDoOutput(true);
    	    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    	    wr.write(data);
    	    wr.flush();

    	    // Get the response
    	    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    	    Gson gson = new GsonBuilder().create();
		    result = gson.fromJson(reader, result.getClass());
		    System.out.println(result.toString());
		    reader.close();


    	} catch (Exception e) {
    	
        
		}
	}
	
	public void postLocation(int id, LatLng loc) {

		Generic gen = new Generic();
		ArrayList<SimpleEntry<String, Object>> params = new ArrayList<SimpleEntry<String, Object>>();
		params.add(new SimpleEntry<String, Object>("id", id));
		params.add(new SimpleEntry<String, Object>("latitude", loc.getLatitude()));
		params.add(new SimpleEntry<String, Object>("longitude", loc.getLongitude()));
		
		String url = "/game/" + gameId + "/postLocation";
		try {
			String data = buildPostData(params);
			PostRequest(url, data, gen);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	public ReadingResponse getReading(int id, LatLng loc) {

		ReadingResponse result = new ReadingResponse();
		ArrayList<SimpleEntry<String, Object>> params = new ArrayList<SimpleEntry<String, Object>>();
		params.add(new SimpleEntry<String, Object>("id", id));
		params.add(new SimpleEntry<String, Object>("latitude", loc.getLatitude()));
		params.add(new SimpleEntry<String, Object>("longitude", loc.getLongitude()));
		
		String url = "/game/" + gameId + "/getReading";
		try {
			String data = buildPostData(params);
			PostRequest(url, data, result);
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	
}
    	
	public void getStatus() {
    	//get
    	try {

    		URL ruby = new URL(server + "/game/" + gameId+ "/status.json"); 
    		
    		Reader reader = new InputStreamReader(ruby.openStream());
    		//BufferedReader reader = new BufferedReader(new FileReader("/Users/dxd/git/Git/socket/src/status.json"));
    		
    		    Gson gson = new GsonBuilder().create();
    		    status = gson.fromJson(reader, Status.class);
    		    System.out.println(status.toString());
    		    reader.close();
    		
    	} catch (MalformedURLException e) {
    	} catch (IOException e) {
    	}
 
	}
	public void run(int clock) {
		
		pull();
		update = new Update(status);
    	if (clock == 1)
    	{
    		initialize();
    	}
		jspace.readAll(update, clock-1);
		
		push();
		jspace.writeAll(clock, status);
		
	}
	private void push() {
		postLocations();
		postPoints();
		postCargos();
		postRequests();
		getReadings();
	}
	
	private void postRequests() {
		for (tuplespace.Request r : update.getRequests())
		{
			LatLng latlng = Game.gridToLocation(r.getCell());
			updateRequests(latlng);
		}
		
	}
	private void updateRequests(LatLng loc) {
		Generic gen = new Generic();
		ArrayList<SimpleEntry<String, Object>> params = new ArrayList<SimpleEntry<String, Object>>();
		params.add(new SimpleEntry<String, Object>("latitude", loc.getLatitude()));
		params.add(new SimpleEntry<String, Object>("longitude", loc.getLongitude()));
		
		String url = "/game/" + gameId + "/request";
		try {
			String data = buildPostData(params);
			PostRequest(url, data, gen);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	private void postCargos() {
		for (tuplespace.Cargo c : update.getCargos())
		{
			LatLng latlng = Game.gridToLocation(c.getCell());
			dropCargos(latlng);
		}
		
	}
	private void dropCargos(LatLng loc) {
		Generic gen = new Generic();
		ArrayList<SimpleEntry<String, Object>> params = new ArrayList<SimpleEntry<String, Object>>();
		params.add(new SimpleEntry<String, Object>("latitude", loc.getLatitude()));
		params.add(new SimpleEntry<String, Object>("longitude", loc.getLongitude()));
		
		String url = "/game/" + gameId + "/dropCargo";
		try {
			String data = buildPostData(params);
			PostRequest(url, data, gen);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	private void postPoints() {
		for (helperTS.AgentPoints a : update.getAgents())
		{
			updatePoints(a.getId(), a.getPoints());
		}
	}
	
	private void updatePoints(int id, int points) {
		Generic gen = new Generic();
		ArrayList<SimpleEntry<String, Object>> params = new ArrayList<SimpleEntry<String, Object>>();
		params.add(new SimpleEntry<String, Object>("id", id));
		params.add(new SimpleEntry<String, Object>("points", points));
		
		String url = "/game/" + gameId + "/updatePoints";
		try {
			String data = buildPostData(params);
			PostRequest(url, data, gen);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	private void getReadings() {
		for (ActionRequest ar : update.getActionRead())
		{
			LatLng latlng = Game.gridToLocation(ar.getCell());
			status.addReading(getReading(ar.getId(), latlng), latlng, ar.getId());
		}

	}

	private void postLocations() {
		for (Position loc : update.getLocations())
		{
			LatLng latlng = Game.gridToLocation(loc.getCell());
			postLocation(loc.getId(), latlng);
		}
		
	}
	private void pull() {
		getStatus();
	}
	
	public JoinResponse postJoin(String string, String string2, String string3) {
		JoinResponse response = new JoinResponse();
		ArrayList<SimpleEntry<String, Object>> params = new ArrayList<SimpleEntry<String, Object>>();
		params.add(new SimpleEntry<String, Object>("email", string));
		params.add(new SimpleEntry<String, Object>("name", string2));
		params.add(new SimpleEntry<String, Object>("team", string3));
		
		String url = "/game/" + gameId + "/join";
		try {
			String data = buildPostData(params);
			PostRequest(url, data, response);
			status.addPlayer(response, string2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return response;
		
	}
}

