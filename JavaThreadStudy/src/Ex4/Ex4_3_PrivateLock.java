package Ex4;

import net.jcip.annotations.GuardedBy;

public class Ex4_3_PrivateLock {
	private final Object myLock = new Object();
	@GuardedBy("myLock") Widget widget;
	
	void something() {
		synchronized (myLock) {
			// widget ������ ���� �аų� ����
		}
	}
	interface Widget{
		
	}
}
