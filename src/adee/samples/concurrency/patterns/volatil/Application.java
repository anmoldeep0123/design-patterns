package adee.samples.concurrency.patterns.volatil;

import java.util.concurrent.ExecutorService;

import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class Application {

	public static void main(String[] args) {
		ExecutorService pool = ThreadUtils.fixedThreadPool(5);
		Task task = new Task();
		for (int i = 0; i < 5; i++) {
			pool.execute(task);
		}
	}
}
