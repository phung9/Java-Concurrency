package Ex5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


//lauderExeception, DataLoadException이 뭔지 모르겠음..

public class Ex5_12_PreLoader {
	ProductInfo loadProductInfo() throws Exception {
		return null;
	}
	
	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
		public ProductInfo call() throws Exception {
			return loadProductInfo();
		}
	});
	
	private final Thread thread = new Thread(future);
	public void start() {thread.start();}
	
	public ProductInfo get() throws Exception, InterruptedException{
		try {
			return future.get();
		} catch (ExecutionException e) {
			Throwable cause = e.getCause();
			if(cause instanceof Exception)
				throw (Exception) cause;
			else
				throw Ex5_13_LaunderThrowable.launderThrowable(cause);
		}
	}
	
	interface ProductInfo {}
}
