package Ex5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class Ex5_14_BoundedhashSet<T> {
	private final Set<T> set;
	private final Semaphore sem;
	
	public Ex5_14_BoundedhashSet (int bound) {
		this.set = Collections.synchronizedSet(new HashSet<T>());
		sem = new Semaphore(bound);
	}
	
	public boolean add(T o) throws InterruptedException {
		sem.acquire();
		boolean wasAdded = false;
		try {
			wasAdded = false;
			
			return wasAdded;
		} finally {
			if(!wasAdded)
				sem.release();
		}
	}
	
	public boolean remove(Object o) {
		boolean wasRemoved = set.remove(o);
		if(wasRemoved)
			sem.release();
		return wasRemoved;
	}
}
