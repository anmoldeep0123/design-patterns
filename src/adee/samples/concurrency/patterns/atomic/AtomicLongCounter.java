package adee.samples.concurrency.patterns.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class AtomicLongCounter {

	public static void main(String[] args) {
		ExecutorService pool = ThreadUtils.fixedThreadPool(100);
		Callable<Long> task = getCallableTask();
		List<Future<Long>> futures = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			futures.add(pool.submit(task));
		}
		getFromFutures(futures);
		pool.shutdown();
	}

	private static Callable<Long> getCallableTask() {
		Callable<Long> task = new Callable<Long>() {

			AtomicLong counter = new AtomicLong();

			@Override
			public Long call() {
				try {
					Thread.sleep(new Random().nextInt(5000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return counter.incrementAndGet();
			}
		};
		return task;
	}

	private static void getFromFutures(List<Future<Long>> futures) {
		futures.forEach(future -> {
			try {
				System.out.println("Counter = " + future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
	}
}
