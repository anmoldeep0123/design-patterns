package adee.samples.java8.closures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaClosure {

	public static void main(String[] args) {

		int effectivelyFinalInt = 5;
		int[] effectivelyFinalArr = { 1, 2, 3, 4, 5 };
		List<String> names = new ArrayList<>();
		names.add("Anmol");
		names.add("BooBoo");
		names.add("Ash");
		names.add("Baba");

		names = names.stream().filter(p -> {
			//effectivelyFinalInt = 4; // compile time error
			// Local variable effectivelyFinal defined in an enclosing scope must be final
			// or effectively final
			effectivelyFinalArr[4] = 0; // is allowed coz for final array reference should not be changed
			return p.length() == 5;
		}).collect(Collectors.toList());
	}
}
