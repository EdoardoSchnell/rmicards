package card;

import java.rmi.*;
import java.io.*;

public class AuthProxy implements LoaderAuthInt, Serializable{
	
	AuthMasterInt masterServer;
	
	public AuthProxy(AuthMasterInt masterServer){
		this.masterServer = masterServer;
	}
	
	public Runnable login(String username, String password) throws RemoteException{
		return masterServer.login(username, password);
	}
}
