package envJavaSpace;

import game.Synchronization;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tuplespace.Cargo;
import tuplespace.Coin;
import tuplespace.Obligation;
import tuplespace.Points;
import tuplespace.Prohibition;
import tuplespace.Reading;

import net.jini.core.event.RemoteEvent;
import net.jini.core.event.RemoteEventListener;
import net.jini.space.JavaSpace;

public class AgentHandler extends UnicastRemoteObject implements RemoteEventListener {

	SpaceTest spaceTest;
	String agent;
	
	public AgentHandler(SpaceTest spaceTest, String agent) throws RemoteException {
		
		this.spaceTest = spaceTest;
		this.agent = agent;
    }

	public AgentHandler(SpaceTest spaceTest) throws RemoteException{ 
		
		this.spaceTest = spaceTest;
		
	}

	public void notify(RemoteEvent anEvent) {

        try {
        	String type = anEvent.getRegistrationObject().get().toString();
            //System.out.println("Got event: " + anEvent.getSource() + ", " +
            //                   anEvent.getID() + ", " +
            //                   anEvent.getSequenceNumber() + ", " + 
            //                   anEvent.getRegistrationObject().get());
            
            if (type.equals("reading")) {
            	//System.out.println("agent position notification");
            	Reading r = spaceTest.readReading(agent);
            	spaceTest.notifyAgent(agent, r);
            }
            else if (type.equals("obligation")) {
            	//System.out.println("agent obligation notification");
            	Obligation o = spaceTest.readObligation(agent);
            	spaceTest.notifyAgent(agent, o);
            }
            else if (type.equals("prohibition")) {
            	//System.out.println("agent prohibition notification");
            	Prohibition p = spaceTest.readProhibition(agent);
            	spaceTest.notifyAgent(agent, p);
            }
            else if (type.equals("points")) {
            	//System.out.println("agent prohibition notification");
            	Points p = spaceTest.readPoints(agent);
            	spaceTest.notifyAgent(agent, p);
            }
        } catch (Exception anE) {
           // System.out.println("Got event but couldn't display it");
            anE.printStackTrace(System.out);
        }
    }
}

