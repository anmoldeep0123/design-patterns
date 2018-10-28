package adee.samples.dsa.priorityqueues;

public class FindPairEqualToSum {

	public static void main(String[] args) {
		int arr[] = { 1, 
				2, 3, 4, 5, 6, 7, 10 };
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
}