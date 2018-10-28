package adee.samples.concurrency.patterns.producerConsumer.blockingQ;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class ProducerConsumer_BlockingQ {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(50);
		List<Callable<String>> prodsAndConsumers = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			prodsAndConsumers.add(new Producer_BlockQ(queue));
		}
		for (int i = 0; i < 2; i++) {
			prodsAndConsumers.add(new Consumer_BlockQ(queue));
		}
		ExecutorService service = ThreadUtils.fixedThreadPool(4);
		List<Future<String>> futures;
		try {
			futures = service.invokeAll(prodsAndConsumers);
			futures.forEach(future -> {
				try {
					System.out.println(future.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {
			e .printStackTrace();
		} finally {
			service.shutdown();
		}

	}
}
