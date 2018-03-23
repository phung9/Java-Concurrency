package Ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Ex5.Ex5_13_LaunderThrowable;
import Ex6.SingleThreadRenderer.ImageData;
import Ex6.SingleThreadRenderer.ImageInfo;

public class FutureRenderer {
	private final ExecutorService executor = Executors.newCachedThreadPool();

	void renderPage(CharSequence source) {
		final List<ImageInfo> imageInfos = scanForImageInfo(source);
		Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
			public List<ImageData> call() {
				List<ImageData> result = new ArrayList<ImageData>();
				for(ImageInfo imageinfo : imageInfos)
					result.add(imageinfo.downloadImage());
				return result;
			}
		};
		
		Future<List<ImageData>> future = executor.submit(task);
		renderText(source);
		
		try{
			List<ImageData> imageData = future.get();
			for(ImageData data : imageData)
				renderimage(data);
		} catch (InterruptedException e){
			Thread.currentThread().interrupt();
			future.cancel(true);
		}catch (ExecutionException e) {
			throw Ex5_13_LaunderThrowable.launderThrowable(e.getCause());
		}
	}

	private void renderimage(ImageData data) {}

	private void renderText(CharSequence source) {}

	private List<ImageInfo> scanForImageInfo(CharSequence source) { return null; }
}
