package card;

import java.rmi.*;

public interface AuthMasterInt extends Remote{
	public String[] list() throws RemoteException;
}
