package adee.samples.concurrency.patterns.barrier_latch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ServiceWorker implements Callable<String> {

	private CountDownLatch latch;
	private Service service;

	public ServiceWorker(CountDownLatch latch, Service service) {
		this.latch = latch;
		this.service = service;
	}

	@Override
	public String call() throws Exception {
		this.service.init();
		this.latch.countDown();
		return "";
	}

}
