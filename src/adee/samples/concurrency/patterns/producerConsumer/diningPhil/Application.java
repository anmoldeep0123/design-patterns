package adee.samples.concurrency.patterns.producerConsumer.diningPhil;

import java.util.concurrent.ExecutorService;

import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class Application {

	public static void main(String[] args) {
		Philosopher[] p = new Philosopher[5];
		Object[] forks = new Object[p.length];

		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}
		ExecutorService pool = ThreadUtils.fixedThreadPool(5);
		for (int i = 0; i < p.length; i++) {
			Object leftFork = forks[i];
			Object rightFork = forks[(i + 1) % forks.length];
			if (i == p.length - 1) {
				p[i] = new Philosopher(rightFork, leftFork);
			} else {
				p[i] = new Philosopher(leftFork, rightFork);
			}
			pool.submit(p[i]);
		}

	}
}
