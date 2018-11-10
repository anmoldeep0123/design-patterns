package adee.samples.concurrency.patterns.volatil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class Application {

	static volatile boolean truthy = true;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = ThreadUtils.fixedThreadPool(1);
		Future<?> future = pool.submit(new Task());
		Thread.sleep(1000);
		Application.truthy = false;
		System.out.println("Now in main thread stop = " + truthy);
		future.get();
	}
}
