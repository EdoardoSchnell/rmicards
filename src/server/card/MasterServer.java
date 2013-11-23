package card;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class MasterServer extends UnicastRemoteObject implements PlayerMasterInt{
	
	private ArrayList<MasterGameInt> activeGameServers = new ArrayList<>();
	
	
	public MasterServer() throws RemoteException{
		super();
	}
	
	
	public String[] list() throws RemoteException{
		String[] ret = new String[activeGameServers.size()];
		for(String s : ac
	}
	
	public PlayerGameInt join(int n) throws RemoteException{
		try{
			return (PlayerGameInt)activeGameServer.get(n);
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new RemoteException(n + ": array index out of bounds.");
		}
	}
	public GameServer getGameServer() throws RemoteException{
		return new GameServer((GameMasterInt)this);
	}
}
