package adee.samples.concurrency.patterns.atomic;

import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class Application {

	public static void main(String[] args) {
		AtomicCounter.runCounter();
		Non_AtomicCounter.runCounter();
		ThreadUtils.fixedThreadPool(8).shutdown();
	}
}

