package adee.samples.concurrency.patterns;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import adee.samples.concurrency.patterns.executors.LauncherService;
import adee.samples.concurrency.patterns.executors.ThreadUtils;

public class Application {

	public static void main(String[] args) {
		ThreadUtils.launchThread();

		LauncherService.runSingleTask();

		LauncherService.runLongRunningTasks();

		ThreadUtils.raiseExceptionFromThreads();

		LauncherService.runMultipleTask();

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
		ThreadUtils.fixedThreadPool().shutdown();
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
