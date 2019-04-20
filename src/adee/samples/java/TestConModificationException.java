package adee.samples.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestConModificationException {

	private static List<String> list = new ArrayList<String>();
	private static Set<String> set = new HashSet<>();
	private static List<String> copyOnWriteAL = new CopyOnWriteArrayList<>();
	private static Set<String> copyOnWriteAS = new CopyOnWriteArraySet<>();
	private static Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		list.add("Anmol-L");
		list.add("Boooo-L");
		list.add("Baba-L");

		set.add("Anmol-S");
		set.add("Qazi-S");
		set.add("Booboo-S");

		copyOnWriteAL.add("cowal-1");
		copyOnWriteAL.add("cowal-2");
		copyOnWriteAL.add("cowal-3");

		copyOnWriteAS.add("cowas-1");
		copyOnWriteAS.add("cowas-2");
		copyOnWriteAS.add("cowas-3");

		concurrentHashMap.put("1", "One");
		concurrentHashMap.put("2", "Two");
		concurrentHashMap.put("3", "Three");

		// Following four throw java.util.ConcurrentModificationException

		// addToList();
		// addToSet();

		// removeFromSet();
		// removeFromList();

		// iterateAndAddToList();
		// iterateAndRemoveFromList();
		// iterateAndAddToSet();
		// iterateAndRemoveFromSet();

		// iterateAndPut();
		// arraysAsListConcurrentModException();

		// addToSycnhronizedList();
		// addToSycnhronizedSet();

		// iterateOnCopyOnWriteArrList();
		// iterateOnCopyOnWriteArrSet();

		iterateOnCHMKeySet();
		iterateOnCHMEntrySet();

	}

	private static void iterateOnCHMEntrySet() {
		for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
			concurrentHashMap.put("4", "Four");
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	private static void iterateOnCHMKeySet() {
		for (String x : concurrentHashMap.keySet()) {
			concurrentHashMap.put("5", "Five");
			System.out.println(concurrentHashMap.get(x));
		}
	}

	private static void iterateOnCopyOnWriteArrSet() {
		for (String x : copyOnWriteAS) {
			copyOnWriteAS.add("LastElement " + x);
			System.out.println(x);
		}
		System.out.println(copyOnWriteAS);
	}

	private static void iterateOnCopyOnWriteArrList() {
		for (String x : copyOnWriteAL) {
			copyOnWriteAL.add("lastElement");
			System.out.println(x);
		}
		System.out.println(copyOnWriteAL);
	}

	private static void addToSycnhronizedSet() {
		// throws CME
		Set<String> synSet = Collections.synchronizedSet(set);
		for (String x : synSet) {
			synSet.add("LastElement - S");
			System.out.println(x);
		}
	}

	private static void addToSycnhronizedList() {
		// throws CME
		List<String> synList = Collections.synchronizedList(list);
		for (String x : synList) {
			synList.add("LastEleme-L");
			System.out.println(x);
		}
	}

	private static void iterateAndPut() {
		// same for Iterator // no concurrent mod exception
		for (String x : list) {
			System.out.println(x);
			list.set(2, "Set-L");
		}
	}

	/*
	 * Arrays.asList returns Arrays.ArrayList that does not support add or remove
	 * operation
	 */
	private static void arraysAsListConcurrentModException() {
		List<String> x = Arrays.asList("Anmol-A", "Deep-A", "Qazi-Q");
		System.out.println(x.getClass().getName());
		for (String x1 : x) {
			System.out.println(x1);
			x.add("Junk");
			x.remove("Deep-A");
		}
	}

	private static void iterateAndRemoveFromSet() {
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
		System.out.println("A " + set);
	}

	private static void iterateAndAddToSet() {
		/*
		 * this is a mystery for now
		 */
	}

	private static void iterateAndRemoveFromList() {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
		System.out.println(list);
	}

	private static void iterateAndAddToList() {
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
			listIterator.add("Junk");
		}
		System.out.println(list);
	}

	private static void removeFromList() {
		for (String x : list) {
			System.out.println(x);
			list.remove(2);
		}
	}

	private static void removeFromSet() {
		for (String x : set) {
			System.out.println(x);
			set.remove("Qazi-S");
		}
	}

	private static void addToSet() {
		for (String x : set) {
			set.add("Junk");
		}
	}

	private static void addToList() {
		for (String x : list) {
			System.out.println(x);
			list.add("Junk");
		}

		// same as above

		// Iterator<String> iterator = list.iterator();
		// while (iterator.hasNext()) {
		// System.out.println(iterator.next());
		// list.add("Junk");
		// }
	}

}
