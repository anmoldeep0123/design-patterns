package adee.samples.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class TestConModificationException {

	private static List<String> list = new ArrayList<String>();
	private static Set<String> set = new HashSet<>();

	public static void main(String[] args) {
		list.add("Anmol-L");
		list.add("Boooo-L");
		list.add("Baba-L");

		set.add("Anmol-S");
		set.add("Qazi-S");
		set.add("Booboo-S");

		// Following four throw java.util.ConcurrentModificationException

		// addToList();
		// addToSet();

		// removeFromSet();
		// removeFromList();

		// iterateAndAddToList();
		// iterateAndRemoveFromList();
		iterateAndAddToSet();
		// iterateAndRemoveFromSet();

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
			set.remove("Qazi");
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
