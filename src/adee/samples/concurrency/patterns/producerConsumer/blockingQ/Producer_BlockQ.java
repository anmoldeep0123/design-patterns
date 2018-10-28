package adee.samples.concurrency.patterns.producerConsumer.blockingQ;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Producer_BlockQ implements Callable<String> {

	BlockingQueue<String> blockingQ = null;

	public Producer_BlockQ(BlockingQueue<String> blockingQ) {
		this.blockingQ = blockingQ;
	}

	@Override
	public String call() throws Exception {
		int ct = 0;
		while (ct < 50) {
			blockingQ.put(Integer.toString(ct));
			System.out.println("Put " + Integer.toString(ct));
			Thread.sleep(3000);
			ct++;
		}
		return "Produced " + (ct - 1);
	}
}
