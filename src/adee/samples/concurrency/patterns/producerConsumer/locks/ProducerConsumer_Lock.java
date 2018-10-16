package adee.samples.concurrency.patterns.producerConsumer.locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer_Lock {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		int maxSize = 2;
		Lock lock = new ReentrantLock();
		Condition bufferNotFull = lock.newCondition();
		Condition bufferNotEmpty = lock.newCondition();
		Thread t1 = new Thread(new Producer_LK(q, maxSize, lock, bufferNotFull, bufferNotEmpty));
		Thread t2 = new Thread(new Consumer_LK(q, lock, bufferNotFull, bufferNotEmpty));
		t1.start();
		t2.start();
	}
}
