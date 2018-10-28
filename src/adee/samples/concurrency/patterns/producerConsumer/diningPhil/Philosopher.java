package adee.samples.concurrency.patterns.producerConsumer.diningPhil;

public class Philosopher implements Runnable {

	private Object leftFork;
	private Object rightFork;

	public Philosopher(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	@Override
	public void run() {
		while (true) {
			doAction("Thinking");
			synchronized (leftFork) {
				doAction("Pick Left Fork");
				synchronized (rightFork) {
					doAction("Pick Right Fork");
					doAction("Drop Right Fork");
				}
				doAction("Drop Left Fork - Back to thinking");
			}
		}
	}

	private void doAction(String action) {
		System.out.println(Thread.currentThread().getName() + " " + action);
		try {
			Thread.sleep((int) Math.random() * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
