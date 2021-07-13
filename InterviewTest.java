package test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 
 * There are blocks of cheese of different weights placed in a line. A mouse
 * would like to eat the cheese, but with some rules. The mouse can’t eat two
 * consecutive cheese blocks. The mouse would like to eat maximum cheese from
 * the line of cheese blocks. Weight of each cheese block in Kg is given as a[i]
 * in an integer array.
 * 
 * Input:
 * 
 * The first line of input contains an integer T denoting the number of test
 * cases. Each test case contains an integer n which denotes the number of
 * elements in the array a[]. Next line contains space separated n elements in
 * the array a[].
 * 
 * Output:
 * 
 * Print an integer which denotes the maximum amount of cheese that the mouse
 * can have.
 * 
 * Constraints:
 * 
 * 1<=T<=200
 * 
 * 1<=n<=1000
 * 
 * 1<=a[i]<=10000
 * 
 * Example:
 * 
 * Input:
 * 
 * 2
 * 
 * 6
 * 
 * 8 5 10 100 10 5
 * 
 * 3
 * 
 * 1 2 3
 * 
 * Output:
 * 
 * 113
 * 
 * 4
 * 
 * 
 * 
 * @author hariprasad_local
 *
 */
public class InterviewTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// reading the number of test cases from the that we want to enter
		int t = sc.nextInt(); // 1<=T<=200
		assert (t >= 200 || t <= 1) : " Invalid input";

		Map<Integer, int[]> tcMap = new LinkedHashMap<Integer, int[]>(t);
		while (t > 0) {
			int n = sc.nextInt(); // 1<=n<=1000
			assert (n >= 1000 || n <= 1) : " Invalid input";
			// creates an array in the memory of length 1000
			int[] a = new int[n]; // 1<=a[i]<=10000
			for (int i = 0; i < n; i++) {
				// reading array elements from the user
				a[i] = sc.nextInt();
				assert (a[i] >= 10000 || a[i] <= 1) : " Invalid input";
			}
			tcMap.put(t, a);
			t--;
		}

		tcMap.forEach((k, v) -> {
			int evenSum = IntStream.range(0, v.length).filter((a) -> a % 2 == 0).map(a -> v[a]).sum();
			int oddSum = IntStream.range(0, v.length).filter((a) -> a % 2 != 0).map(a -> v[a]).sum();
			System.out.println((evenSum > oddSum) ? evenSum : oddSum);
		});

	}

}
