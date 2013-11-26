package card;

import java.io.Serializable;
import java.rmi.*;

public class ClientPlayer implements Runnable, Serializable, GamePlayerInt{
	
	private String username;
	private PLayerMasterInt master;
	
	public ClientPlayer(String username, PlayerMasterInt master){
		this.username = username;
		this.master = master;
	}
	
	public void run(){
		System.out.println("Sono un ClientPlayer autenticato.");
		String scelta = console.readLine("Scegli se ottenere una lista dei server [1] oppure dare vita ad un nuovo server [2]");
		int choice = Integer.parseInt(scelta);
		
		switch(scelta){
			case 1: 
				String[] lista = master.list();
				for( String s : lista )
					System.out.println(s);
				break;
			case 2:
				System.out.println("Congratulazioni, diventerai papà!");
				master.getGameServer().run();
		}
	}
	
	public String getUsername() throws RemoteException{
		return username;
	}
}
