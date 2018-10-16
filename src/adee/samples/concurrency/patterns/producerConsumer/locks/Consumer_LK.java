package adee.samples.concurrency.patterns.producerConsumer.locks;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer_LK implements Runnable {

	private Queue<Integer> sharedQueue;

	private Lock lock = new ReentrantLock();
	private Condition bufferNotFull;
	private Condition bufferNotEmpty;

	public Consumer_LK(Queue<Integer> sharedQueue , Lock lock , Condition bufferNotFull , Condition bufferNotEmpty) {
		this.sharedQueue = sharedQueue;
		this.lock = lock;
		this.bufferNotEmpty = bufferNotEmpty;
		this.bufferNotFull = bufferNotFull;
	}

	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				while (sharedQueue.isEmpty()) {
					System.out.println(
							"Consumer : SHARED Queue IS EMPTY -- WAITING FOR PRODUCER TO ADD SOMETHING TO THE Q");
					try {
						bufferNotFull.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Consumer : " + sharedQueue);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Consumer : Consuming Value : " + sharedQueue.remove());
				bufferNotEmpty.signal();
			} finally {
				lock.unlock();
			}
		}
	}
}