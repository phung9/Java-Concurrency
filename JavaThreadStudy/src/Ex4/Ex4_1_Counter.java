package Ex4;

import net.jcip.annotations.*;

@ThreadSafe
public final class Ex4_1_Counter {
	@GuardedBy("this") private long value = 0;
	
	public synchronized long getValue(){
		return value;
	}
	
	public synchronized long increment(){
		if(value == Long.MAX_VALUE)
			throw new IllegalStateException("counter overflow");
		return ++value;
	}
}
