package tuplespace;

import java.util.Date;

import net.jini.core.entry.Entry;

public class ActionRequest implements Entry {
	
	public Integer id;
	public String agent;
	public String type;
	public Integer clock;
	public Date time;
	
	public ActionRequest() {
		
	}

	public ActionRequest(Integer clock) {
		this.clock = clock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getClock() {
		return clock;
	}

	public void setClock(Integer clock) {
		this.clock = clock;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
