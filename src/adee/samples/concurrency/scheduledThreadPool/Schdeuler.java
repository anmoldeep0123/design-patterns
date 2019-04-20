package adee.samples.concurrency.scheduledThreadPool;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schdeuler {

	private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);

	public static void main(String[] args) {
		scheduler.schedule(new ScheduledTask(), 2, TimeUnit.SECONDS);
		scheduler.scheduleAtFixedRate(new ScheduledTask(), 0, 1, TimeUnit.SECONDS);
		scheduler.scheduleWithFixedDelay(new ScheduledTask2(), 2, 1, TimeUnit.SECONDS);
		shutDownScheduler();
	}

	private static void shutDownScheduler() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Shutting Down Scheduler");
				scheduler.shutdown();
				System.out.println("Shut Down Scheduler Done");
			}
		}).start();
	}
}

class ScheduledTask implements Runnable {

	@Override
	public void run() {
		System.out.println("ST-1 BEGINS");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ST : 1 " + Date.from(Instant.now()).toString());
	}

}

class ScheduledTask2 implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ST : 2 " + Date.from(Instant.now()).toString());
	}

}
