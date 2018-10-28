package adee.samples.dsa.arrays;

public class ArrayProblems {

	public static void pairEqualToSum() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 10 };
		int i = 0;
		int j = arr.length - 1;
		int sum = 7;
		while (i < j) {
			while ((arr[i] + arr[j]) <= sum && i < j) {
				if ((arr[i] + arr[j]) == sum)
					System.out.println(arr[i] + " + " + arr[j]);
				i++;
			}
			j--;
			while ((arr[i] + arr[j]) >= sum && i < j) {
				if ((arr[i] + arr[j]) == sum)
					System.out.println(arr[i] + " + " + arr[j]);
				j--;
			}
		}
	}

	public static void removeDuplicatedSortedArray() {
		int a[] = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3 };
		int j = 1;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] != a[i + 1]) {
				a[j++] = a[i + 1];
			}
		}
		for (int i = j; i < a.length; i++) {
			a[i] = 0;
		}
		printArr(a);
	}

	public static void minDistance() {
		int a[] = { 3, 5, 3, 4, 2, 6, 5, 5, 3, 1, 6, 3, 6 };
		int dist = Integer.MAX_VALUE;
		int x = 3;
		int y = 6;
		int l = 0, r = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				l = i;
			}
			if (a[i] == y) {
				r = i;
			}
			if (r > l && ((r - l) < dist)) {
				dist = r - l;
			}
		}
		System.out.println(dist);
	}

	public static void reverse() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			int temp = a[end];
			a[end] = a[start];
			a[start] = temp;
			start++;
			end--;
		}
		printArr(a);
	}

	public static void bucketSort() {
		int a[] = { 9, 1, 30000, 3, 45, 8, 4, 2, 7, 10000 };
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		int bucket[] = new int[max];
		for (int i : a) {
			bucket[i - 1] = 1;
		}
		int j = 0;
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] == 1) {
				a[j++] = i + 1;
			}
		}
		printArr(a);
	}

	int FindMaxSum(int n) {
		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		for (i = 1; i < n; i++) {
			/* current max excluding i */
			excl_new = (incl > excl) ? incl : excl;

			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl);
	}

	public static void stringWithFrequency() {
		String x = "geeksForgeeks";
		int[] freq = new int[52];
		for (int i = 0; i < x.length(); i++) {
			int index = Math.abs(x.charAt(i) - 'a');
			freq[index] = freq[index] + 1;
		}
		for (int i = 0; i < x.length(); i++) {
			int index = Math.abs(x.charAt(i) - 'a');
			if (freq[index] != 0) {
				System.out.print(x.charAt(i));
				System.out.print(freq[Math.abs(x.charAt(i) - 'a')]);
				freq[Math.abs(x.charAt(i) - 'a')] = 0;
			}
		}
	}

	public static void shiftSpacesToBeg() {
		String x = "geeks For geeks";
		int i = x.length();
		char str[] = x.toCharArray();
		for (int j = i - 1; j >= 0; j--)
			if (str[j] != ' ') {
				str[--i] = str[j];
			}
		while (i > 0)
			str[--i] = ' ';
		System.out.println(new String(str));
	}

	public static void kadeneAlgo() {
		int a[] = { -2, 5, 6, -2, 3, 1, -4, 2 };
		int c = a[0], g = a[0];
		for (int i = 1; i < a.length - 1; i++) {
			c = Math.max(a[i], c + a[i]);
			if (c > g) {
				g = c;
			}
		}
		System.out.println("Max Sum Sub-Array = " + g);
	}

	public static void longestCommonSubsequence() {
		char[] X = "AGGTAB".toCharArray();
		char[] Y = "GXTXAYB".toCharArray();
		int sum = lcs(X, Y, X.length, Y.length);
		System.out.println(sum);
	}

	private static int lcs(char[] x, char[] y, int xLen, int yLen) {
		if (xLen == 0 || yLen == 0) {
			return 0;
		}
		if (x[xLen - 1] == y[yLen - 1]) {
			return 1 + lcs(x, y, xLen - 1, yLen - 1);
		} else {
			return Math.max(lcs(x, y, xLen, yLen - 1), lcs(x, y, xLen - 1, yLen));
		}
	}

	private static void printArr(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}