package card;

import java.rmi.*;

public interface MasterGameInt extends PlayerGameInt{
	public String getName() throws RemoteException;
	//... e altre info eventualmente
}
