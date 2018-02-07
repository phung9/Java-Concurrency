package Ex1;

import net.jcip.annotations.*;

@ThreadSafe
public class Ex1_2_Sequence {
	
	@GuardedBy("this") private int value;
	
	public synchronized int getNext(){
		return value++;
	}
}