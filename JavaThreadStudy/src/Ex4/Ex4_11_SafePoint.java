package Ex4;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Ex4_11_SafePoint {
	@GuardedBy("this") private int x, y;
	
	private Ex4_11_SafePoint(int[] a) {this(a[0], a[1]); }

	public Ex4_11_SafePoint(Ex4_11_SafePoint p) { this(p.get()); }
	
	public Ex4_11_SafePoint(int i, int j) {
		this.set(x, y);
	}
	
	public synchronized int[] get() {
		return new int[] {x, y};
	}
	
	public synchronized void set(int x, int y){
		this.x = x;
		this.y = y;
	}

	
}
