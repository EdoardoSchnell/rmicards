package card;

import java.rmi.*;
import java.rmi.server.*;

public class AuthServer extends UnicastRemoteObject implements LoaderAuthInt{

	public AuthServer() throws RemoteException{
		super();
	}

	public Runnable login(String username, String password) throws RemoteException{
		System.out.println("Requested login with username '" + username + "' and password '" + password + "'");
		if(password.equals("admin"))
			return (Runnable)(new ClientAdmin());
		else
			return (Runnable)(new ClientPlayer(username));
	}

	public static void main(String[] args){
		
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		
		String port = args[0];
		
		System.out.println("Current codebase:" + System.getProperty("java.rmi.server.codebase"));
		
		try{
			//MasterServer master = new MasterServer();//crea il master server
			//System.out.println("MasterServer creato.");
			AuthServer auth = new AuthServer();//crea auth server
			System.out.println("AuthServer creato.");
			Naming.rebind("//:" + port + "/authServer", (LoaderAuthInt)auth);//rebind auth server
			System.out.println("AuthServer rebinded.");
		}catch(Exception e){
			System.err.println(e);
			System.exit(1);
		}
	}
}
