package adee.samples.concurrency.patterns.producerConsumer.locks;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer_LK implements Runnable {

	private Queue<Integer> sharedQueue;
	private int capacity;

	private Lock lock;
	private Condition bufferNotFull;
	private Condition bufferNotEmpty;

	public Producer_LK(Queue<Integer> sharedQueue, int capacity, Lock lock, Condition bufferNotFull,
			Condition bufferNotEmpty) {
		this.sharedQueue = sharedQueue;
		this.capacity = capacity;
		this.lock = lock;
		this.bufferNotEmpty = bufferNotEmpty;
		this.bufferNotFull = bufferNotFull;
	}

	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				while (sharedQueue.size() == capacity) {
					System.out.println("Producer : Queue IS FULL - WAITING FOR CONSUMER TO REMOVE SOMETHING FROM Q");
					try {
						bufferNotEmpty.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int val = new Random().nextInt(300);
				System.out.println("Producer : ADDING " + val + " TO Queue");
				sharedQueue.add(val);
				System.out.println("Producer : " + sharedQueue);
				bufferNotFull.signal();
			} finally {
				lock.unlock();
			}
		}
	}
}
