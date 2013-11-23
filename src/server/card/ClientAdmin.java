package card;

import java.io.Serializable;

public class ClientAdmin implements Runnable, Serializable{
	public void run(){
		System.out.println("Sono un ClientAdmin autenticato. E tu sei un programmatore fico.");
	}
}
