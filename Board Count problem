Board Count Question 

import java.util.*;

public class Main {
	public static long start;
	public static long end;

	public static void startalgo() {
		start = System.currentTimeMillis();
	}

	public static long endalgo() {
		end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		Scanner take = new Scanner(System.in);
		int val = take.nextInt();
		int[] storage = new int[val + 1];
		startalgo();
		 System.out.println(countBoardDp(val, storage));
		 System.out.println(endalgo());
		startalgo();
		System.out.println(countDpIs(val));
		System.out.println(endalgo());
	}
  // recurrsive approach top down
	public static int countBoardDp(int val, int[] cache) {

		if (val == 0)
			return 1;
		if (cache[val] != 0) {
			return cache[val];
		}
		int ans = 0;
		for (int i = 1; i <= 6; i++) {
			if (val - i >= 0) {
				ans += countBoardDp(val - i, cache);
			} else
				break;
		}
		cache[val] = ans;
		// System.out.println(val + ": " + ans);
		return ans;
	}
 // bottom up
	public static int countDpIs(int val) {
		int[] cache = new int[val + 1];
		cache[val] = 1;
		for (int i = val - 1; i >= 0; i--) {
			int count = 0;
			for (int dice = 1; dice <= 6 && i + dice < cache.length; dice++) {
				count += cache[i + dice];
			}
			cache[i] = count;
		}
		int ans = cache[0];
		return ans;
	}
}
