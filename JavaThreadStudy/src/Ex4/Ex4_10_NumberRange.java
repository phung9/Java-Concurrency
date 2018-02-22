package Ex4;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex4_10_NumberRange {
	//������ ���� : lower <= upper
	private final AtomicInteger lower = new AtomicInteger(0);
	private final AtomicInteger upper = new AtomicInteger(0);
	
	public void setLower(int i) {
		//���� - �������� ���� �񱳹�
		if (i > upper.get())
			throw new IllegalArgumentException("Can't see lower to " + i + " > upper");
		lower.set(i);
	}
	
	public void setUpper(int i) {
		if (i < lower.get())
			throw new IllegalArgumentException("Can't see upper to " + i + " < lower");
		upper.set(i);
	}
	
	public boolean isInRange(int i) {
		return (i >= lower.get() && i <= upper.get());
	}
}
