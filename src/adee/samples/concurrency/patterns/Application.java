package adee.samples.concurrency.patterns;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import adee.samples.concurrency.patterns.executors.LauncherService;
import adee.samples.concurrency.patterns.executors.ThreadUtils;
import adee.samples.concurrency.patterns.locking.User;

public class Application {

	public static void main(String[] args) {
		// executorSamples();
		lockingSamples();
	}

	private static void lockingSamples() {
		User user = new adee.samples.concurrency.patterns.locking.User("adee");
		Runnable task = () -> {
			user.login();
		};
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();
	}

	private static void executorSamples() {
		ThreadUtils.launchThread();

		LauncherService.runSingleTask();

		LauncherService.runLongRunningTasks();

		ThreadUtils.raiseExceptionFromThreads();

		LauncherService.runMultipleTask(3);

		runFutureTask(true);

		runFutureTask(false);

		raiseExceptionFromFuture();

		shutDownThreadPools();
	}

	private static void raiseExceptionFromFuture() {
		Future<String> future = LauncherService.raiseExceptionFromCallable();
		try {
			System.out.println("Future Returned : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static void shutDownThreadPools() {
		ThreadUtils.singleThreadPool().shutdown();
		ThreadUtils.fixedThreadPool(3).shutdown();
	}

	private static void runFutureTask(boolean wait) {
		Future<String> future = LauncherService.runFutureTask();
		try {
			if (wait) {
				System.out.println("Future Returned : " + future.get());
			} else {
				try {
					System.out.println("Future Returned : " + future.get(200, TimeUnit.MILLISECONDS));
				} catch (TimeoutException e) {
					System.out.println("Failed To Get Future Return Val : " + e.getClass());
				}
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
