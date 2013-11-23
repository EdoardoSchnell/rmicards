package card;

import java.rmi.*;

public interface PlayerGameInt extends Remote{
	public void join(GamePlayerInt p) throws RemoteException;
	public String status() throws RemoteException;
	public void placeCard(String c) throws RemoteException;
}
