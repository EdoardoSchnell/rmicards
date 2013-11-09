package card;

import java.rmi.*;

public interface LoaderAuthInt extends Remote{
	public Runnable login(String username, String password) throws RemoteException;
}
