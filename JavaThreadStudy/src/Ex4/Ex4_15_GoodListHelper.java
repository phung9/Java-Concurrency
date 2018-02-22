package Ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Ex4_15_GoodListHelper<E> {
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());
	
	public boolean putIfAbsent(E x) {
		synchronized (list)
		{
			boolean absent = !list.contains(x);
			if(absent)
				list.add(x);
			return absent;
		}
	}
}
