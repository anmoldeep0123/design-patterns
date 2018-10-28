package adee.samples.dsa.priorityqueues;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinHeap {
	
	public static void main(String[] args) {
		Queue<Integer> pQ = new PriorityQueue<>();
		int a[] = {9,1,7,3,5,0,11,13,19};
		for(int aa : a) pQ.add(aa);
		System.out.println(pQ);
		System.out.println(pQ.poll());
		System.out.println(pQ);
		System.out.println(pQ.poll());
		System.out.println(pQ);
		System.out.println(pQ.poll());
		System.out.println(pQ);
	}

}
