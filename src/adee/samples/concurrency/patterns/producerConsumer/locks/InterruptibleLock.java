package adee.samples.concurrency.patterns.producerConsumer.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLock {

	public static void main(String[] args) {
		Resource resource = new Resource();
		LongWaitingTask task = new LongWaitingTask(resource);
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		intterruptThread1(t1);
		try {
			System.out.println("Main Thread Sleeping 10 seconds");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		System.out.println("Main Thread Sleeping DONE");
		t2.start();
	}

	private static void intterruptThread1(Thread t1) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Interrupting Engine Sleeping 60 seconds");
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
				}
				System.out.println("Interrupting Engine Sleeping DONE");
				t1.interrupt();
			}
		}).start();

	}
}

class LongWaitingTask implements Runnable {

	Resource resource;

	public LongWaitingTask(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		this.resource.doSomething();
	}
}

class Resource {

	Lock lock = new ReentrantLock();

	public void doSomething() {
		try {
			lock.lockInterruptibly();
			try {
				System.out.println(Thread.currentThread().getName() + " going to Sleep Infinitely");
				Thread.sleep(6000000);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " Thread is Interrupted");
			}
			System.out.println(Thread.currentThread().getName() + " After Sleeping");
		} catch (InterruptedException e1) {
			System.out.println(Thread.currentThread().getName() + " Thread is Interrupted - 2");
		} finally {
			lock.unlock();
		}
	}
}
