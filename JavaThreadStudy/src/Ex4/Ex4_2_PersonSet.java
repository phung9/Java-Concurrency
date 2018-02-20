package Ex4;

import java.util.HashSet;
import java.util.Set;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Ex4_2_PersonSet {
	@GuardedBy("this")
	private final Set<Person> mySet = new HashSet<Person>();
	
	public synchronized void addPerson(Person p) {
		mySet.add(p);
	}
	
	public synchronized boolean containsPerson(Person p) {
		return mySet.contains(p);
	}
	
	interface Person {
    }
}
