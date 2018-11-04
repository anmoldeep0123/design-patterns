package adee.samples.java8.References;

import java.util.ArrayList;
import static java.util.Comparator.comparing;
import java.util.List;

public class MultipleComparators {

	public static void main(String[] args) {
		List<Employee> ez = new ArrayList<>();
		ez.add(new Employee("Anmol", 28));
		ez.add(new Employee("Posheen", 15));
		ez.add(new Employee("BooBoo", 28));
		ez.add(new Employee("Gourav", 28));

		/*
		 * sorting by age and then sorting by fName the employees that have same age
		 */
		ez.sort(comparing(Employee::getAge).thenComparing(comparing(Employee::getfName)));
		System.out.println(ez);
	}
}

class Employee {
	private String fName;
	private int age;

	Employee(String fName, int age) {
		this.fName = fName;
		this.age = age;
	}

	public String getfName() {
		return fName;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [fName=" + fName + ", lName=" + age + "]";
	}
}
