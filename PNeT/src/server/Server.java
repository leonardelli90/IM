package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {	
	
	private static final int SERVER_PORT = 7000;
	
	
	private ThreadPoolExecutor tpe = null;
	private ServerSocket welcomeSocket = null;
	
	public Server() throws IOException {

		this.tpe = (ThreadPoolExecutor) Executors.newCachedThreadPool();				
		this.welcomeSocket = new ServerSocket(Server.SERVER_PORT);			
			
	}
	
	public void execute() throws IOException {
		
		Socket clientSocket = null;
		
		while(true) {
			
			clientSocket = this.welcomeSocket.accept();			
			this.tpe.execute(new Worker(clientSocket));
			
		}
		
	}
	
	public static void main(String[] args) {								
		
		Server s = null;
		
		try {
			s = new Server();
			s.execute();
		} catch (IOException e) {
			System.out.println(e);			
		}
		
		
	}
	
}
