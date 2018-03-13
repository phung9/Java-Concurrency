package Ex5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ex5_17_Memoizer2<A, V> implements Computable<A, V> {
	private final Map<A, V> cache = new ConcurrentHashMap<A,V>();
	private final Computable<A,V> c;
	
	public Ex5_17_Memoizer2(Computable<A,V>	c) {this.c = c;}
	
	public V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if(result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
}

interface Computable<A,V> { V compute(A arg) throws InterruptedException; }