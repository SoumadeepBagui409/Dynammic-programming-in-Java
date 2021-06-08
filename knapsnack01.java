package lecture18_dp;

import java.util.*;
import java.lang.*;

public class knapsnack01 {

	public static void main(String[] args) {
		Scanner take = new Scanner(System.in);
		int size = take.nextInt();
		int[] wgt = new int[size];
		int[] price = new int[size];
		for (int i = 0; i < size; i++)
			wgt[i] = take.nextInt();
		for (int i = 0; i < size; i++) {
			price[i] = take.nextInt();
		}
		int wt;
		wt = take.nextInt();
		System.out.println(ksk(price, wgt, 0, wt));
		System.out.println(ksktd(price, wgt, 0, wt, new int[price.length][wt + 1]));

	}

	public static int ksk(int[] price, int[] wgt, int idx, int wt) {
		if (wt == 0 || idx == price.length)
			return 0;
		int ans = 0;
		int op1 = Integer.MIN_VALUE;
		if (wt - wgt[idx] >= 0)
			op1 = price[idx] + ksk(price, wgt, idx + 1, wt - wgt[idx]);
		int op2 = ksk(price, wgt, idx + 1, wt);
		ans = Math.max(op1, op2);
		return ans;
	}

	public static int ksktd(int[] price, int[] wgt, int idx, int wt, int[][] cache) {
		if (wt == 0 || idx == price.length)
			return 0;
		if (cache[idx][wt] != 0)
			return cache[idx][wt];
		int ans = 0;
		int op1 = Integer.MIN_VALUE;
		if (wt - wgt[idx] >= 0)
			op1 = price[idx] + ksktd(price, wgt, idx + 1, wt - wgt[idx], cache);
		int op2 = ksktd(price, wgt, idx + 1, wt, cache);
		ans = Math.max(op1, op2);
		cache[idx][wt] = ans;
		return ans;
	}

}
