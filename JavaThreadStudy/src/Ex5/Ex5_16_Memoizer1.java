package Ex5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import net.jcip.annotations.GuardedBy;

public class Ex5_16_Memoizer1<A,V> implements Computable<A,V> {
	@GuardedBy("this")
	private final Map<A,V> cache = new HashMap<A,V>() ;
	private final Computable<A,V> c;
	
	public Ex5_16_Memoizer1(Computable<A,V> c) {
		this. c= c;
	}
	
	
	public synchronized V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if(result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
}
interface Computable<A,V> {
	V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger> {
	public BigInteger compute(String arg) {
		
		return new BigInteger(arg);
	}
}