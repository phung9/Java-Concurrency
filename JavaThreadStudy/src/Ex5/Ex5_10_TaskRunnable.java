package Ex5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.*;

public class Ex5_10_TaskRunnable implements Runnable{
	BlockingQueue<Task> queue;
	
	public void run() {
		try {
			processTask(queue.take());
		} catch (InterruptedException e) {
			//인터럽트가 발생한 사실을 저장한다
			Thread.currentThread().interrupt();
		}
	}

	public void processTask(Task t) {
		
	}
	interface Task {
		
	}
}
