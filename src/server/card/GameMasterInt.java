package card;

import java.rmi.*;


public interface GameMasterInt extends Remote{
	public void register(MasterGameInt gameServer) throws RemoteException;
}
