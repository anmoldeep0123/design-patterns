package adee.samples.concurrency.patterns.producerConsumer.blockingQ;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer_BlockQ implements Callable<String> {

	BlockingQueue<String> blockingQ = null;

	public Consumer_BlockQ(BlockingQueue<String> blockingQ) {
		this.blockingQ = blockingQ;
	}

	@Override
	public String call() throws Exception {
		int ct = 0;
		while (ct < 50) {
			System.out.println("Get " + blockingQ.take());
			Thread.sleep(3000);
			ct++;
		}
		return "Consumed " + (ct - 1);
	}
}
