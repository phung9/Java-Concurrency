package Ex4;

import java.util.Vector;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Ex4_13_BetterVector<E> extends Vector<E> {
	public synchronized boolean putIfAbset (E x) {
		
		boolean absent = !contains(x);
		if(absent)
			
			add(x);
		return absent;
	}
}
