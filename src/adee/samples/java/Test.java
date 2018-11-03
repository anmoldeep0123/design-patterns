package adee.samples.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {

		 int a[] = { 2, -3, 90, 87, 3, 1, 777, 8, 10, 8, 9, -999, 2, 5, 13, -5, 3, -18, 66, 56 };
		//int a[] = { -3, -14, -5, 7, 8, 42, 8, 3 };
		List<Integer> winter = new ArrayList<>();
		List<Integer> spring = new ArrayList<>();
		List<Integer> summer = new ArrayList<>();
		List<Integer> autumn = new ArrayList<>();

		int diff = a.length / 4;
		for (int i = 0; i < diff; i++) {
			winter.add(a[i]);
		}
		for (int i = diff; i < diff * 2; i++) {
			spring.add(a[i]);
		}
		for (int i = diff * 2; i < diff * 3; i++) {
			summer.add(a[i]);
		}
		for (int i = diff * 3; i < diff * 4; i++) {
			autumn.add(a[i]);
		}
		System.out.println(winter);
		System.out.println(spring);
		System.out.println(summer);
		System.out.println(autumn);
		NavigableMap<Integer, String> seasonsMap = getMaxSeason(winter, spring, summer, autumn);
		System.out.println(seasonsMap);
		System.out.println(seasonsMap.get(seasonsMap.lastKey()));
	}

	private static NavigableMap<Integer, String> getMaxSeason(List<Integer> winter, List<Integer> spring,
			List<Integer> summer, List<Integer> autumn) {
		NavigableMap<Integer, String> seasons = new TreeMap<>();
		seasons.put(getAmplitude(winter), "WINTER");
		seasons.put(getAmplitude(spring), "SPRING");
		seasons.put(getAmplitude(summer), "SUMMER");
		seasons.put(getAmplitude(autumn), "AUTUMN");
		return seasons;
	}

	public static int getAmplitude(List<Integer> subArray) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int val : subArray) {
			if (val > max) {
				max = val;
			}
			if (val < min) {
				min = val;
			}
		}
		return max - min;
	}
}
