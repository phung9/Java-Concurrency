package Ex7;

import java.util.concurrent.*;

import Ex5.Ex5_13_LaunderThrowable;

public class TimeRun {
	private static final ExecutorService taskExec = Executors.newCachedThreadPool();
	
	public static void timeRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
		Future<?> task = taskExec.submit(r);
		try{
			task.get(timeout, unit);
		} catch (TimeoutException e) {
			
		} catch (ExecutionException e) {
			throw Ex5_13_LaunderThrowable.launderThrowable(e.getCause());
		} finally {
			task.cancel(true);
		}
	}
}
