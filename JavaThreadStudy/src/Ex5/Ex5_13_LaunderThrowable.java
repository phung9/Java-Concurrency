package Ex5;

public class Ex5_13_LaunderThrowable {
	public static RuntimeException launderThrowable(Throwable t) {
		if(t instanceof RuntimeException)
			return (RuntimeException) t;
		else if (t instanceof Error)
			throw (Error) t;
		else
			throw new IllegalStateException("RuntimeException¿Ã æ∆¥‘", t);
	}
}
