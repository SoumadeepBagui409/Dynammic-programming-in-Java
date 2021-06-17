class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] cache = new int[s.length()][s.length()];
        return longestss(s,0,s.length()-1,cache);
    }
    public static int longestss(String str, int st, int ed, int[][] cache) {
		if (st == ed) {
			return 1;
		}
		if(st>ed)
            return 0;
		if (cache[st][ed] != 0)
			return cache[st][ed];
		int ans;
		if (str.charAt(st) == str.charAt(ed)) {
			ans = longestss(str, st + 1, ed - 1,cache) + 2;
		} else {
			int op1 = longestss(str, st + 1, ed,cache);
			int op2 = longestss(str, st, ed - 1,cache);
			ans = Math.max(op1, op2);
		}
		return cache[st][ed] = ans;
	}
}
