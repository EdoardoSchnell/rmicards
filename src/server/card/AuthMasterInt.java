package card;

import java.rmi.*;

public interface AuthMasterInt extends Remote{
	public Runnable login(String username, String password) throws RemoteException;
}
