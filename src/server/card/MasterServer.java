package card;

import java.rmi.*;
import java.rmi.server.*;

public class MasterServer extends UnicastRemoteObject implements AuthMasterInt{
	
	public MasterServer() throws RemoteException{
		super();
	}
	
	public Runnable login(String username, String password) throws RemoteException{
		if(password.equals("admin"))
			return new ClientAdmin();
		else
			return new ClientPlayer();
	}
	
	public static void main(String[] args){
		
		System.out.println("CLASSPATH: " + System.getProperty("java.class.path"));
		
		String port = args[0];
		try{
			MasterServer server = new MasterServer();//crea il master server
			System.out.println("Server creato");
			LoaderAuthInt proxy = new AuthProxy((AuthMasterInt)RemoteObject.toStub(server));//crea il proxy assegnandogli lo stub del server
			System.out.println("Proxy creato");
			Naming.rebind("//:" + port + "/proxy", proxy);//esporta il proxy sul registro rmi
			System.out.println("Rebind eseguita");
		}catch(Exception e){
			System.err.println(e);
			System.exit(1);
		}
	}
}
