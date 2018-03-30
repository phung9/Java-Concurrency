package Ex7;

import java.util.concurrent.BlockingQueue;

public class NoncancelableTask {
	public Task getNextTask(BlockingQueue<Task> queue){
		boolean interrupted = false;
		try{
			while(true){
				try{
					return queue.take();
				} catch(InterruptedException e) {
					interrupted = true;
					//그냥 넘어가고 재시도
				}
			}
		} finally {
			if (interrupted)
				Thread.currentThread().interrupt();
		}
	}
	interface Task{}
}
