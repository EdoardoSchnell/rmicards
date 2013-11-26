package card;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class MasterServer extends UnicastRemoteObject implements PlayerMasterInt, GameMasterInt{
	
	private ArrayList<MasterGameInt> activeGameServers = new ArrayList<>();
		
	public MasterServer() throws RemoteException{
		super();
	}
	
	/*
		Returns a list of all the active servers registered to this MasterServer.
	*/
	public String[] list() throws RemoteException{
		String[] ret = new String[activeGameServers.size()];
		int i = 0;
		for(MasterGameInt s : activeGameServers)
			ret[i++] = s.getName();
		return ret;
	}
	
	/*
		Returns the chosen (PlayerGameInt)GameServer.
	*/
	public PlayerGameInt join(int n) throws RemoteException{
		try{
			return (PlayerGameInt)activeGameServers.get(n);
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new RemoteException(n + ": array index out of bounds.");
		}
	}
	
	/*
		Returns a GameServer ready to be exported and registered to this MasterServer.
	*/
	public GameServer getGameServer() throws RemoteException{
		return new GameServer((GameMasterInt)this);
	}
	
	public void register(MasterGameInt gameServer)throws RemoteException{
		activeGameServers.add(gameServer);
	}
}
