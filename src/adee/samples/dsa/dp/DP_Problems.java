package adee.samples.dsa.dp;

public class DP_Problems {

	public static void eggSolver(int floors, int eggs) {
		final int results[][] = new int[floors + 1][eggs + 1];
		for (int i = 1; i <= floors; i++) {
			results[i][1] = i;
		}
		for (int i = 1; i <= eggs; i++) {
			results[1][i] = 1;
		}
		for (int i = 2; i <= floors; i++) {
			for (int j = 2; j <= eggs; j++) {
				results[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x <=i; x++) {
					int brokenEggResult = results[x - 1][j - 1];
					final int eggSurvivesResult = results[i - x][j];
					int temp = Math.max(brokenEggResult, eggSurvivesResult) + 1;
					if (temp < results[i][j]) {
						results[i][j] = temp;
					}
				}
			}
		}
		print2DArray(results);
		System.out.println(results[floors][eggs]);
	}

	private static void print2DArray(int arr[][]) {
		for (int[] x : arr) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}
}