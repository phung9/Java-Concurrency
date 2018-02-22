package Ex4;

import net.jcip.annotations.Immutable;

@Immutable
public class Ex4_6_Point {
	public final int x, y;
	
	public Ex4_6_Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
