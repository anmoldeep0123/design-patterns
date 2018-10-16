package adee.samples.concurrency.patterns.producerConsumer.waitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer_WaitNotify {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		int maxSize = 2;
		Thread t1 = new Thread(new Producer_WN(q, maxSize));
		Thread t2 = new Thread(new Consumer_WN(q));
		t1.start();
		t2.start();
	}
}
