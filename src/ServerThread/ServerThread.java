package ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import UserThread.UserThread;

public class ServerThread extends Thread {

	private ServerSocket server;

	public ServerThread(int port) throws IOException {
		this.server = new ServerSocket(port);
	}

	public void serverThread() throws IOException {
		while (true) {
			Socket client = server.accept();
			UserThread userThread = new UserThread(client);
			userThread.start();
		}
	}
}
