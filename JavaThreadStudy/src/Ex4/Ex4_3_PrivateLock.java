package Ex4;

import net.jcip.annotations.GuardedBy;

public class Ex4_3_PrivateLock {
	private final Object myLock = new Object();
	@GuardedBy("myLock") Widget widget;
	
	void something() {
		synchronized (myLock) {
			// widget 변수의 값을 읽거나 변경
		}
	}
	interface Widget{
		
	}
}
