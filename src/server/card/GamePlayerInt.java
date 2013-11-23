package card;

import java.rmi.*;

public interface GamePlayerInt extends Remote{
	public String getUsername() throws RemoteException;
}
