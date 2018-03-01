package Ex5;

import java.util.concurrent.CountDownLatch;

public class Ex5_11_TestHarness {
	public long timeTasks(int nThhreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThhreads);
		
		for (int i = 0 ; i < nThhreads ; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ignored) { }
				}
			};
			t.start();
		}
		
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return end-start; 
	}
}
