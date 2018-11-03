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

	public MethodReferenceExample sort() {
		this.candidates.sort(Comparator.comparing(String::length));
		return this;
	}

	public MethodReferenceExample sortReverse() {
		this.candidates.sort(Comparator.comparing(String::length).reversed());
		return this;
	}

	public static void main(String[] args) {
		MethodReferenceExample ref = new MethodReferenceExample().sort();
		System.out.println(ref.candidates);
		ref.sortReverse();
		System.out.println(ref.candidates);
	}

}
