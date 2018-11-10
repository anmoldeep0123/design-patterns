package adee.samples.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class FlatMapExample {

	public static List<String> words = new ArrayList<>();

	public static void main(String[] args) {
		words.add("Hello");
		words.add("World");
		List<String[]> newWords = words.stream().map(p -> p.split("")).distinct().collect(toList());
		List<String> newWords1 = words.stream().map(p -> p.split("")).flatMap(Arrays::stream).distinct()
				.collect(toList());
		System.out.println(newWords1);
	}
}
