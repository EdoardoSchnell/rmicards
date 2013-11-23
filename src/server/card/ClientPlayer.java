package card;

import java.io.Serializable;


public class ClientPlayer implements Runnable, Serializable{
	public void run(){
		System.out.println("Sono un ClientPlayer autenticato. E tu sei un programmatore fico.");
	}
}
