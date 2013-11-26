package card;

import java.io.Serializable;
import java.rmi.*;
import java.io.*;

public class ClientPlayer implements Runnable, Serializable, GamePlayerInt{
	
	private String username;
	private PlayerMasterInt master;
		
	public ClientPlayer(String username, PlayerMasterInt master){
		this.username = username;
		this.master = master;
	}
	
	public void run(){
		Console console = System.console();
		
		System.out.println("Sono un ClientPlayer autenticato.");
		String scelta = console.readLine("Scegli se ottenere una lista dei server [1] oppure dare vita ad un nuovo server [2]");
		int choice = Integer.parseInt(scelta);

		try{
			switch(choice){
				case 1: 
					String[] lista = master.list();
					for( String s : lista )
						System.out.println(s);
					break;
				case 2:
					System.out.println("Congratulazioni, diventerai papà!");
				
						master.getGameServer().run();
			}
		}catch(RemoteException e){
			System.err.println(e);
			System.exit(1);
		}
	}
	
	public String getUsername() throws RemoteException{
		return username;
	}
}
