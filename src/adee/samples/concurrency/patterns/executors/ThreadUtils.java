package adee.samples.concurrency.patterns.executors;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {

	private static ExecutorService singleThreadPool = null;
	private static ExecutorService fixedThreadPool = null;
	private static ExecutorService cachedThreadPool = null;

	/*
	 * Wrong pattern ; in java EE application one should not be creating threads on
	 * their own
	 */
	public static void launchThread() {
		Runnable task = () -> System.out.println("New Thread Executing");
		new Thread(task).start();
	}

	/*
	 * Single Thread , thread-pool useful for reactive programming , to execute a
	 * single task in a new thread most commonly used threadPool
	 */
	public static ExecutorService singleThreadPool() {
		if (singleThreadPool == null) {
			singleThreadPool = Executors.newSingleThreadExecutor();
		}
		return singleThreadPool;
	}

	/*
	 * Fixed Thread Pool executor fix the number of threads in that thread-pool
	 */
	public static ExecutorService fixedThreadPool() {
		if (fixedThreadPool == null) {
			fixedThreadPool = Executors.newFixedThreadPool(3);
		}
		return fixedThreadPool;
	}

	/*
	 * creates threads on demand keeps unused threads for sometime (60s) then
	 * terminates them
	 */
	public static ExecutorService cachedThreadPool() {
		if (cachedThreadPool == null) {
			cachedThreadPool = Executors.newCachedThreadPool();
		}
		return cachedThreadPool;
	}

	/*
	 * A thread cannot raise an exception , the below method tries to raise an
	 * exception from a thread but the exception cannot be thrown , has to be
	 * encapsualted in a try catch
	 */
	public static void raiseExceptionFromThreads() {
		Runnable task = () -> {
			System.out.println("Trying to raise an exception");
			try {
				throw new SQLException("Something Gone Wrong");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		};
		new Thread(task).start();
	}
}
