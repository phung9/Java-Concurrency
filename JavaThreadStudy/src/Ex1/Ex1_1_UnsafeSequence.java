package Ex1;

import net.jcip.annotations.*;

@NotThreadSafe
public class Ex1_1_UnsafeSequence {
	
	private int value ;
	
	/** ������ ���� ���� */
	public int getNext() {
		return value++;
	}
}