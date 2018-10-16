package adee.samples.concurrency.patterns.barrier_latch;

import java.util.Random;

public class Service2 implements Service {

	@Override
	public void init() {
		try {
			int randNum = new Random().nextInt(25000);
			System.out.println(this.getClass().getCanonicalName() + " - Takes " + randNum + " to start");
			Thread.sleep(randNum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getClass().getCanonicalName() + " - Started");
	}

}
