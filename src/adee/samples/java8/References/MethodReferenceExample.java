package adee.samples.java8.References;

import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;

/*
 * (args) -> ClassName.staticMethod(args)
 * MethodRef : ClassName :: staticMethod
 * 
 * (arg0,param) -> arg0.instanceMethod(param)
 * MethodRef : ClassName :: instanceMethod  ||  arg0 is an instance of ClassName 
 * 
 * (args) -> instance.instanceMethod(args)
 * MethodRef : instance :: instanceMethod 
 * 
 */
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
		this.candidates.sort((o1, o2) -> o2.length() - o1.length());
	}

	public void sort() {
		this.candidates.sort(comparing(String::length));
	}

	public void sort_2() {
		this.candidates.sort(String::compareToIgnoreCase);
	}

	public void sortReverse() {
		this.candidates.sort(comparing(String::length).reversed());
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

		ref.sort_2();
		System.out.println("SORT_2 = " + ref.candidates);

	}

}
