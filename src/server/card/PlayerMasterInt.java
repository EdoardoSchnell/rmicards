package card;

import java.rmi.*;

public interface PlayerMasterInt extends Remote{
	public String[] list() throws RemoteException;
	public PlayerGameInt join(int n) throws RemoteException;
	public GameServer getGameServer() throws RemoteException;
}
