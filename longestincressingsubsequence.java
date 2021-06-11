
import java.util.*;
import java.lang.*;

public class LISDP {

	public static void main(String[] args) {
		Scanner take = new Scanner(System.in);
		int size = take.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = take.nextInt();
		}
		System.out.println(LIS(arr, size));
	}

	public static int LIS(int[] arr, int n) {
		int[] lis = new int[n];
		lis[0] = 1;
		int maxer = 1;
		for (int i = 1; i < n; i++) {
			int j = i - 1;
			int temp = 0;
			while (j >= 0) {
				if (arr[i] > arr[j])
					temp = Math.max(temp, lis[j]);
				j--;
			}
			lis[i] = temp + 1;
			maxer = Math.max(lis[i], maxer);
		}
		return maxer;
	}

}
