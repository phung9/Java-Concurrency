package Ex2;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class Ex2_3_LazyInitRace {
	private ExpensiveObject instance = null;
	
	public ExpensiveObject getInstance(){
		if(instance == null)
			instance = new ExpensiveObject();
		return instance;
	}
}
class ExpensiveObject { }