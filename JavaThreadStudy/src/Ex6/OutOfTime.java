package Ex6;

import java.util.Timer;
import java.util.TimerTask;
import static java.util.concurrent.TimeUnit.SECONDS;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

public class OutOfTime {
	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		timer.schedule(new ThrowTask(), 1);
		SECONDS.sleep(1);
		timer.schedule(new ThrowTask(), 1);
		SECONDS.sleep(5);
	}
	
	static class ThrowTask extends TimerTask{
		public void run() { throw new RuntimeException(); } 
	}
}
