package adee.samples.concurrency.patterns.barrier_latch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class PrimeNumberCallable implements Callable<List<Integer>> {

	private CyclicBarrier barrier;
	private int start;
	private int count;
	private ComputePrimeNumbers cpn;

	public PrimeNumberCallable(CyclicBarrier barrier, int start, int count, ComputePrimeNumbers cpn) {
		this.barrier = barrier;
		this.start = start;
		this.count = count;
		this.cpn = cpn;
	}

	@Override
	public List<Integer> call() {
		List<Integer> results = new ArrayList<>();
		for (int i = start; i < start + count; i++) {
			if (cpn.isPrime(i)) {
				results.add(i);
			}
		}
		try {
			System.out.println("Barrier : " + Thread.currentThread().getName() + " waiting");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		return results;
	}
}
