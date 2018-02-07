package Ex1;

import net.jcip.annotations.*;

@NotThreadSafe
public class Ex1_1_UnsafeSequence {
	
	private int value ;
	
	/** 유일한 값을 리턴 */
	public int getNext() {
		return value++;
	}
}