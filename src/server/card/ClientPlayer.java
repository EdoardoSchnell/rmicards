package card;

import java.io.Serializable;
import java.rmi.*;

public class ClientPlayer implements Runnable, Serializable, GamePlayerInt{
	
	private String username;
	
	public ClientPlayer(String username){
		this.username = username;
	}
	
	public void run(){
		System.out.println("Sono un ClientPlayer autenticato. E tu sei un programmatore fico.");
	}
	
	public String getUsername() throws RemoteException{
		return username;
	}
}
