package Ex6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPerTaskWebServer {
	public static void main(String[] args) throws IOException{
		ServerSocket socket = new ServerSocket(80);
		while(true){
			final Socket connection = socket.accept();
			Runnable task = new Runnable() {
				public void run() {
					handleRequest(connection);
				}
				private void handleRequest(Socket connection) {
				}
			};
			new Thread(task).start();
		}
	}
}
