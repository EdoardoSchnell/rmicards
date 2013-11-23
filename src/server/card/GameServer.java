package card;

import java.rmi.*;

public GameServer implements PlayerGameInt{
	
	private String name;
	private ArrayList<String> table = new ArrayList<>();
	private GameMasterInt masterServer;
	
	
	public GameServer(GameMasterInt masterServer){
		this.masterServer = masterServer;
	}
	
	public void export() throws RemoteException{
		UnicastRemoteObject.export(this);
		masterServer.register((MasterGameInt)this);
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
