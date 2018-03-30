package Ex7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread{
	private final BlockingQueue<BigInteger> queue;
	
	PrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}
	
	public void run(){
		try {
			BigInteger p = BigInteger.ONE;
			while(!Thread.currentThread().isInterrupted())
				queue.put(p = p.nextProbablePrime());
		} catch (InterruptedException consumed) {
			//스레드 종료
		}
	}
	public void cancel() { 
		interrupt();
	}
}
