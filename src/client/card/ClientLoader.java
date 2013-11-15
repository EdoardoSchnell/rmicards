package card;

import java.rmi.*;
import java.io.*;

public class ClientLoader{
	
	public static void main(String[] args){
		if(System.getSecurityManager() != null)
			System.setSecurityManager(new RMISecurityManager());
		
		Console console = System.console();
		
		String host = args[0];
		
		try{
			String[] lista = Naming.list("//" + host + "/authServer");
			for( int i = 0; i < lista.length; i = i+1)
				System.out.println(lista[i]);
				
			LoaderAuthInt authServer = (LoaderAuthInt)Naming.lookup("//" + host + "/authServer");
			System.out.println("Lookup eseguita.");
			if( authServer != null)
				System.out.println("authServer != null.");
				
			Runnable client = authServer.login(console.readLine("Username: "), new String(console.readPassword("Password: ")));
			
			if(client == null)
				System.err.println("Login non valido");
			else
				client.run();
			
			System.out.println("ADDIO");
		}catch(Exception e){
			System.err.println(e);
			System.exit(1);
		}
	}
}
