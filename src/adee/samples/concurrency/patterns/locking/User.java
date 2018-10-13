package adee.samples.concurrency.patterns.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class User {

	private String userId;
	private boolean loggedIn = false;
	private Lock lock = new ReentrantLock();

	public User(String userId) {
		this.userId = userId;
	}

	public void login() {
		try {
			System.out.println(Thread.currentThread().getName() + "  : Entered Login");
			lock.lock();
			// do some synchronized stuff
			// if(somteOtherUserIsLoggedIn) {
			loggedIn = true;
			System.out.println(Thread.currentThread().getName() + ": loggedIn " +  loggedIn);
			while (loggedIn) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
				}
				loggedIn = false;
				System.out.println(Thread.currentThread().getName() + ": loggedIn " +  loggedIn);;
			}
		} finally {
			lock.unlock();
		}
		System.out.println(Thread.currentThread().getName() + "  : Exited Login");
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
