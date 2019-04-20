package adee.samples.concurrency.futureDemo;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

	private int demoType = 0;
	private Thread threadToInterrupt;

	public CallableTask(int demoType) {
		this.demoType = demoType;
	}
	
	public CallableTask(Thread threadToInterrupt , int demoType) {
		this.threadToInterrupt = threadToInterrupt;
		this.demoType = demoType;
	}

	@Override
	public String call() throws Exception {
		if (this.demoType == 0) {
			// return immediately
			return "Task is Finished";
		} else if (this.demoType == 1) {
			// return after 30 seconds
			Thread.sleep(5000);
			return "Task Finished in 5 seconds";
		} else if (this.demoType == 2) {
			// throw Execution Exception
			throw new Exception("Task 2 : This is a Execution Exception");
		} else if (this.demoType == 3) {
			// get call to return in a timeout of 5 seconds
			Thread.sleep(6000);
			System.out.println("Task 3 : Thread finished in 6 seconds");
			return "This will never return : Future Timeout";
		} else if (this.demoType == 4) {
			// sleep for a minute and main thread will shutdown executor
			// before a minute to throw Interrupted Exception;
			Thread.sleep(5000);
			this.threadToInterrupt.interrupt();
			System.out.println("T4 - Returning");
			return "Task 4 : This will never return : Executor Shutdown";
		} else {
			throw new UnsupportedOperationException("Case not supported Yet");
		}
	}
}
