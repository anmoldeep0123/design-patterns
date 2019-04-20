package adee.samples.concurrency.futureDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableDriver {

	private static CallableTask task = null;
	private static Future<String> future = null;
	private static ExecutorService threadPool = Executors.newFixedThreadPool(5);

	public static void main(String[] args) {
		execTask0();
		execTask1();
		execTask2();
		execTask3();
		execTask4();
		threadPool.shutdown();
		System.out.println("Exiting Main Method");
	}

	private static void execTask0() {
		task = new CallableTask(0);
		future = threadPool.submit(task);
		try {
			System.out.println("Task 0 : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Exception T0: - " + e.getMessage());
		}
	}

	private static void execTask1() {
		task = new CallableTask(1);
		future = threadPool.submit(task);
		try {
			System.out.println("Task 1 : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Exception T1: - " + e.getMessage());
		}
	}

	private static void execTask2() {
		task = new CallableTask(2);
		try {
			future = threadPool.submit(task);
			System.out.println("Task 2 : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Exception T2: - " + e.getClass().getName() + " " + e.getMessage());
		}
	}

	private static void execTask3() {
		task = new CallableTask(3);
		future = threadPool.submit(task);
		try {
			System.out.println("Task 3 : Expecting Return in 5 seconds" + future.get(5, TimeUnit.SECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Exception T3: - " + e.getMessage());
		}
	}

	private static void execTask4() {
		task = new CallableTask(Thread.currentThread(), 4);
		future = threadPool.submit(task);
		try {
			System.out.println("Task 4 : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Exception T4: - " + e.getClass().getName());
		}
	}
}
