import java.util.*;
import java.lang.*;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		// Matrix Chain Multiplication
		Scanner take = new Scanner(System.in);
		int size = take.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = take.nextInt();
		}
		System.out.println(MaxMultiPoss(arr, 0, arr.length - 1));
		System.out.println(MaxMultiPoss(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
	}

	public static int MaxMultiPoss(int[] arr, int st, int ed) {

		if (ed - st == 1) {
			return 0;
		}

		int ans = Integer.MAX_VALUE;
		for (int key = st + 1; key <= ed - 1; key++) {
			int op1 = MaxMultiPoss(arr, st, key);
			int op2 = MaxMultiPoss(arr, key, ed);
			int op3 = arr[st] * arr[key] * arr[ed];
			int curr = op1 + op2 + op3;
			if (curr < ans) {
				ans = curr;
			}
		}
		return ans;
	}

	public static int MaxMultiPoss(int[] arr, int st, int ed, int[][] cache) {

		if (ed - st == 1) {
			return 0;
		}
		if (cache[st][ed] != 0)
			return cache[st][ed];
		int ans = Integer.MAX_VALUE;
		for (int key = st + 1; key <= ed - 1; key++) {
			int op1 = MaxMultiPoss(arr, st, key);
			int op2 = MaxMultiPoss(arr, key, ed);
			int op3 = arr[st] * arr[key] * arr[ed];
			int curr = op1 + op2 + op3;
			if (curr < ans) {
				ans = curr;
			}
		}
		cache[st][ed] = ans;
		return ans;
	}
}
