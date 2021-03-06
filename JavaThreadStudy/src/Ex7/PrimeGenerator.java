package Ex7;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.concurrent.*;
import java.math.BigInteger;
import java.util.*;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class PrimeGenerator implements Runnable {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	@GuardedBy("this") private final List<BigInteger> primes = new ArrayList<BigInteger>();
	private volatile boolean cancelled;
	
	public void run() {
		BigInteger p = BigInteger.ONE;
		while(!cancelled){
			p = p.nextProbablePrime();
			synchronized (this) {
				primes.add(p);
			}
		}
	}
	
	public void cancel(){
		cancelled = true;
	}
	
	public synchronized List<BigInteger> get(){
		return new ArrayList<BigInteger>(primes);
	}
	
	static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
		PrimeGenerator generator = new PrimeGenerator();
		exec.execute(generator);
		try{
			SECONDS.sleep(1);
		} finally {
			generator.cancel();
		}
		return generator.get();
	}
}
