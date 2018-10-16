package adee.samples.concurrency.patterns.locking;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeCache {

	Map<Integer, String> cache = new HashMap<>();
	ReadWriteLock lock = new ReentrantReadWriteLock();
	Lock readLock = lock.readLock();
	Lock writeLock = lock.writeLock();

	public String get(Integer key) {
		try {
			readLock.lock();
			return cache.get(key);
		} finally {
			readLock.unlock();
		}
	}

	public void put(Integer key, String val) {
		try {
			writeLock.lock();
			cache.put(key, val);
		} finally {
			writeLock.unlock();	
		}
	}
}
