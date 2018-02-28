package Ex5;

import java.util.Vector;

public class Ex5_1_getLast {

	public static Object getLast(Vector list) {
		int lastIndex = list.size() - 1;
		return list.get(lastIndex);
	}
	
	public static void deleteLast (Vector list) {
		int lastIndex = list.size() - 1;
		list.remove(lastIndex);
	}
}