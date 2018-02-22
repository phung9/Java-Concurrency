package Ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class Ex4_14_ListHelper<E> {
	public List<E> list = Collections.synchronizedList(new ArrayList<E>()); 
	
	public synchronized boolean putIfAbsent(E x) {
		boolean absent = !list.contains(x);
		if (absent)
			list.add(x);
		return absent;
	}
}
