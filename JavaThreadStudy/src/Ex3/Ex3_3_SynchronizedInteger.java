package Ex3;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Ex3_3_SynchronizedInteger {
	@GuardedBy("this") private int value;
	
	public synchronized int get() { return value; }
	public synchronized void set(int value) { this.value = value; }
}
