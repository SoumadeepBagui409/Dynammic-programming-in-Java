class Solution {
    public int minCut(String str) {
        System.out.println(str.length());
        int[][] cache = new int[str.length()][str.length()];
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
        return PartitionPaltd(str, 0, str.length() - 1, cache);
    }
    public static int PartitionPaltd(String str, int st, int ed, int[][] cache) {

		if (st>ed || ispalindrome(str, st, ed)) {
			return 0;
		}
		if (cache[st][ed] != -1) {
			return cache[st][ed];
		}
		int ans = Integer.MAX_VALUE;
		for (int k = st; k < ed; k++) {
            if(ispalindrome(str,st,k)){
			//int op1 = PartitionPaltd(str, st, k, cache);
			int op2 = PartitionPaltd(str, k + 1, ed, cache);
			int total =  op2 + 1;
			if (total < ans)
				ans = total;
            }
            
		}
		cache[st][ed] = ans;
		return ans;
	}

	public static boolean ispalindrome(String str, int st, int ed) {
		int st1 = st;
		int ed1 = ed;
		while (st1 < ed1) {
			if (str.charAt(st1) != str.charAt(ed1))
				return false;
			st1++;
			ed1--;
		}
		return true;
	}
}
