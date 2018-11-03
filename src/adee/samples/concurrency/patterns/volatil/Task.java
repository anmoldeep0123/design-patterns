package adee.samples.concurrency.patterns.volatil;

public class Task implements Runnable {

	private static volatile int sharedVariable = 4;

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + "SHared Variable on entry  " + sharedVariable);
		sharedVariable = sharedVariable * 5;
		System.out.println(Thread.currentThread().getName() + " " + "Modified shared variable to " + sharedVariable
				+ " Now sleeping 15 seconds");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " " + "Exiting Run method");
	}
}
