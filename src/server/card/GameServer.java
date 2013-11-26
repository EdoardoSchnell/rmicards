package card;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class GameServer implements PlayerGameInt, Runnable{
	
	private String name;
	private ArrayList<String> table = new ArrayList<>();
	private GameMasterInt masterServer;
	
	
	public GameServer(GameMasterInt masterServer){
		this.masterServer = masterServer;
	}
	
	public void run(){
		try{
		UnicastRemoteObject.exportObject(this);
		masterServer.register((MasterGameInt)this);
		}catch(RemoteException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void join(GamePlayerInt p) throws RemoteException{
		System.out.println(p.getUsername() + " joined the game.");
	}
	
	/*
		Ritorna la lista di carte sul tavolo.
	*/
	public String status() throws RemoteException{
		String ret = "";
		
		for(String s : table)
			ret += s + "\n";
		
		return ret;
	}
	
	/*
		Aggiunge una carta al tavolo.
	*/
	public void placeCard(String c) throws RemoteException{
		table.add(c);
	}
}
