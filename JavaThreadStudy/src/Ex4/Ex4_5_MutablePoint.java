package Ex4;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class Ex4_5_MutablePoint {
	public int x, y;
	
	public Ex4_5_MutablePoint() { x = 0; y = 0;}
	public Ex4_5_MutablePoint(Ex4_5_MutablePoint p){
		this.x = x;
		this.y = y;
	}
}
