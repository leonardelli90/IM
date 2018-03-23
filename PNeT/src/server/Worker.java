package server;

import java.net.Socket;

public class Worker implements Runnable {

	private Socket s = null;

	public Worker(Socket s) {
		this.s = s;
	}

	public void run() {

		boolean done = false;

		while (!done) {

		}

	}

}
