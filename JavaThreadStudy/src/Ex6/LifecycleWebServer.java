package Ex6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class LifecycleWebServer {
	private final ExecutorService exec = Executors.newCachedThreadPool();
	
	public void start() throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while(!exec.isShutdown()) {
			try {
				final Socket conn = socket.accept();
				exec.execute(new Runnable() {
					public void run() {
						handleRequest(conn);
					}
					private void handleRequest(Socket conn) {
					}
				});
			} catch (RejectedExecutionException e) {
				if(!exec.isShutdown())
					log("task submission rejected", e);
			}
		}
	}
	
	public void stop() { exec.shutdown(); }
	
	void handleRequest(Socket connection) {
		Request req = readRequest(connection);
		if(isShutdownRequest(req))
			stop();
		else
			dispatchRequest(req);
	}
	
	private void log(String msg, Exception e) {
		Logger.getAnonymousLogger().log(Level.WARNING, msg, e);
	}
	
	private Request readRequest(Socket s) {
        return null;
    }
	
	private void dispatchRequest(Request r) {
    }

    private boolean isShutdownRequest(Request r) {
        return false;
    }

	
	
}
