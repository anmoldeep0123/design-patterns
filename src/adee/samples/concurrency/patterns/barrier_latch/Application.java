package adee.samples.concurrency.patterns.barrier_latch;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class Application {

	private static int numberOfPrimes = 0;
	private static Instant now;
	private static Instant then;

	public static void main(String[] args) {
		// checkPrimeOneThread();
		// checkPrimeMultipleThreads();
		startApplicationWithFourServices();
	}

	private static void startApplicationWithFourServices() {
		CountDownLatch latch = new CountDownLatch(4);
		ExecutorService pool = ThreadUtils.fixedThreadPool(4);
		pool.submit(new ServiceWorker(latch, new Service1()));
		pool.submit(new ServiceWorker(latch, new Service2()));
		pool.submit(new ServiceWorker(latch, new Service3()));
		pool.submit(new ServiceWorker(latch, new Service4()));

		try {
			latch.await(40, TimeUnit.SECONDS);
			System.out.println("All Services have been started - Start the Application");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}

	private static void checkPrimeMultipleThreads() {
		now = Instant.now();
		checkPrimeMultipleThreads(5000);
		ThreadUtils.fixedThreadPool(5000).shutdown();
		then = Instant.now();
		System.out.println("Time(seconds) to check primes : " + Duration.between(now, then).getSeconds());
		System.out.println(numberOfPrimes);
	}

	private static void checkPrimeMultipleThreads(int barriers) {
		List<Future<List<Integer>>> futures = new ArrayList<>();
		CyclicBarrier barrier = new CyclicBarrier(barriers);
		ComputePrimeNumbers cnp = new ComputePrimeNumbers();
		ExecutorService executor = ThreadUtils.fixedThreadPool(barriers);
		int start = 1;
		int count = 500000 / barriers;
		for (int i = 0; i < barriers; i++) {
			futures.add(executor.submit(new PrimeNumberCallable(barrier, start, count, cnp)));
			start = start + count;
		}
		futures.forEach(future -> {
			updateSumOfPrimes(future);
		});
	}

	private static void updateSumOfPrimes(Future<List<Integer>> future) {
		try {
			numberOfPrimes += future.get().size();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static void checkPrimeOneThread() {
		now = Instant.now();
		List<Integer> results = new ArrayList<>();
		ComputePrimeNumbers cpn = new ComputePrimeNumbers();
		for (int i = 1; i < 500000; i++) {
			if (cpn.isPrime(i)) {
				results.add(i);
			}
		}
		then = Instant.now();
		System.out.println("Time to check primes from 1 to 10,000 " + Duration.between(now, then).getSeconds());
		System.out.println(results.size());
	}
}
