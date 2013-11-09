package card;

import java.io.Console;
import java.rmi.*;

public class ClientLoader{
	
	public static void main(String[] args){
		if(System.getSecurityManager() != null)
			System.setSecurityManager(new RMISecurityManager());
		
		Console console = System.console();
		
		String host = args[0];
		
		try{
			LoaderAuthInt proxy = Naming.lookup("//" + host + "/proxy");
			Runnable client = proxy.login(console.read("Username> "), console.readPassword("Password"));
			if(client == null)
				System.err.println("Login non valido");
			else
				client.run();
			
		}catch(Exception e){
			System.err.println(e);
			System.exit(1);
		}
	}
}
