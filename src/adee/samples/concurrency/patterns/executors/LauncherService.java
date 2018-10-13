package adee.samples.concurrency.patterns.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class LauncherService {

	public static void runSingleTask() {
		ThreadUtils.singleThreadPool().execute(() -> System.out.println("Launching from a Single Thread Pool"));
	}

	public static void runMultipleTask() {
		Runnable task = () -> System.out
				.println("Launching from a Single Thread Pool " + Thread.currentThread().getName());
		ExecutorService executor = ThreadUtils.fixedThreadPool();
		for (int i = 0; i < 10; i++) {
			executor.submit(task);
		}
	}

	public static void runLongRunningTasks() {
		ExecutorService singleThreadPoolExecutor = ThreadUtils.singleThreadPool();
		Runnable task1 = () -> {
			System.out.println("Long Running Task Started");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Long Running Task Finished");
		};

		Runnable task2 = () -> {
			System.out.println("Really Long Running Task Started");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Really Long Running Task Finished");
		};
		singleThreadPoolExecutor.execute(task1);
		singleThreadPoolExecutor.execute(task2);
	}

	public static Future<String> runFutureTask() {
		Callable<String> task = () -> {
			System.out.println("Future Task Running");
			Thread.sleep(500);
			return "finished";
		};
		ExecutorService singleThreadPoolExecutor = ThreadUtils.singleThreadPool();
		Future<String> future = singleThreadPoolExecutor.submit(task);
		return future;
	}

	public static Future<String> raiseExceptionFromCallable() {
		Callable<String> task = () -> {
			System.out.println("Future Task Throwing Exception");
			throw new IllegalStateException("Exception Thrown from a Thread : " + Thread.currentThread().getName());
		};
		ExecutorService singleThreadPoolExecutor = ThreadUtils.singleThreadPool();
		Future<String> future = singleThreadPoolExecutor.submit(task);
		return future;
	}
}
