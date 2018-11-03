package adee.samples.java8.methodReference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceExample {

	private List<String> candidates = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;

		{
			add("Girdhari");
			add("Anmol");
			add("Posheen");
			add("Baba");
			add("Booboo");
		}
	};

	public void sortConventional() {
		this.candidates.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
	}

	public void reverseSortUsingLambda() {
		this.candidates.sort((String o1, String o2) -> o2.length() - o1.length());
	}

	public void sort() {
		this.candidates.sort(Comparator.comparing(String::length));
	}

	public void sortReverse() {
		this.candidates.sort(Comparator.comparing(String::length).reversed());
	}

	public static void main(String[] args) {
		MethodReferenceExample ref = new MethodReferenceExample();
		ref.sortConventional();
		System.out.println("SORT = " + ref.candidates);

		ref.sortReverse();
		System.out.println("REVERSE-SORT = " + ref.candidates);

		ref.sort();
		System.out.println("SORT = " + ref.candidates);

		ref.reverseSortUsingLambda();
		System.out.println("REVERSE-SORT = " + ref.candidates);

	}

}
