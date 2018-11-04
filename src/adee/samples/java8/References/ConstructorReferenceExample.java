package adee.samples.java8.References;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

	public static void main(String[] args) {
		Supplier<Apple> s = Apple::new;
		Supplier<Apple> s1 = () -> new Apple();

		Function<Integer, Apple> f = Apple::new;
		Function<Integer, Apple> f1 = (weight) -> new Apple(weight);

		BiFunction<Integer, String, Apple> b = (weight, color) -> new Apple(weight, color);

		System.out.println(s.get().getWeight());
		System.out.println(s1.get().getWeight());
		System.out.println(f.apply(10).getWeight());
		System.out.println(f1.apply(100).getWeight());
		System.out.println(b.apply(5, "pink").getColor());
	}

}

class Apple {

	private int weight = 1;
	private String color = "red";

	Apple() {
		System.out.println("Apple No Args Constructor");
	}

	Apple(int weight) {
		this.weight = weight;
		System.out.println("Apple with weight " + this.weight + " Constructor");
	}

	Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
		System.out.println("Apple with weight " + this.weight + "  " + this.color + "  Constructor");
	}

	public int getWeight() {
		return this.weight;
	}

	public String getColor() {
		return this.color;
	}
}
