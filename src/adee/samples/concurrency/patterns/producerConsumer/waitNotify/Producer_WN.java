package adee.samples.concurrency.patterns.producerConsumer.waitNotify;

import java.util.Queue;
import java.util.Random;

public class Producer_WN implements Runnable {

	private Queue<Integer> sharedQueue;
	private int capacity;

	public Producer_WN(Queue<Integer> sharedQueue, int capacity) {
		this.sharedQueue = sharedQueue;
		this.capacity = capacity;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.size() == capacity) {
					System.out.println("Queue IS FULL - WAITING FOR CONSUMER TO REMOVE SOMETHING FROM Q");
					try {
						sharedQueue.wait();
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
				System.out.println("ADDING " + val + " TO Queue");
				sharedQueue.add(val);
				System.out.println(sharedQueue);
				sharedQueue.notifyAll();
			}
		}
	}
}
