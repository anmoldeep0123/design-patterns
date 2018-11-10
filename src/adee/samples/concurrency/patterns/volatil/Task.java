package adee.samples.concurrency.patterns.volatil;

public class Task implements Runnable {

	@Override
	public void run() {
		int counter = 1;
		while (Application.truthy) {
			counter++;
		}
		System.out.println("Stopped the Thread counter = " + counter);
	}
}