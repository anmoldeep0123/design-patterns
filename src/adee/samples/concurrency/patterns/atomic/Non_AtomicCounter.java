package adee.samples.concurrency.patterns.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class Non_AtomicCounter {

	private static int counter = 0;
	private static List<Future<?>> futures = new ArrayList<>();

	public static void runCounter() {
		class Incrementer implements Runnable {

			@Override
			public void run() {
				for (int i = 0; i < 1_0000; i++) {
					counter++;
				}
			}
		}

		class Decrementer implements Runnable {

			@Override
			public void run() {
				for (int i = 0; i < 1_0000; i++) {
					counter--;
				}
			}
		}

		ExecutorService executor = ThreadUtils.fixedThreadPool(8);
		for (int i = 0; i < 4; i++) {
			futures.add(executor.submit(new Incrementer()));
		}
		for (int i = 0; i < 4; i++) {
			futures.add(executor.submit(new Decrementer()));
		}

		futures.forEach(future -> {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(e.getMessage());
			}
		});

		System.out.println("Non_Atomic Counter = " + counter);
	}
}
