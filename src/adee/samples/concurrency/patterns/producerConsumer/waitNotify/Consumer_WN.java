package adee.samples.concurrency.patterns.producerConsumer.waitNotify;

import java.util.Queue;

public class Consumer_WN implements Runnable {

	private Queue<Integer> sharedQueue;

	public Consumer_WN(Queue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.isEmpty()) {
					System.out.println("SHARED Queue IS EMPTY -- WAITING FOR PRODUCER TO ADD SOMETHING TO THE Q");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(sharedQueue);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Consuming Value : " + sharedQueue.remove());
				sharedQueue.notifyAll();
			}
		}
	}
}
