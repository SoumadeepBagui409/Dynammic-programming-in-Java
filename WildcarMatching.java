class Solution {
    public boolean isMatch(String str, String str1) {
     int[][] cache = new int[str.length()][str1.length()];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
	    return wildcardrecurrsion(str, str1, 0, 0, cache);   
    }
    public static boolean wildcardrecurrsion(String str, String str1, int idx1, int idx2, int[][] cache) {
		// System.out.println(2);
		if (str.length() == idx1 && str1.length() == idx2)
			return true;
		if (str.length() != idx1 && str1.length() == idx2)
			return false;
		if (str.length() == idx1 && str1.length() != idx2) {
			for (int i = idx2; i < str1.length(); i++) {
				if (str1.charAt(i) != '*')
					return false;
			}
			return true;
		}
		if (cache[idx1][idx2] != -1) {
			if (cache[idx1][idx2] == 1)
				return true;
			else
				return false;
		}
		boolean ans = false;
		char fs1 = str.charAt(idx1);
		char fs2 = str1.charAt(idx2);
		if (fs1 == fs2 || fs2 == '?')
			ans = wildcardrecurrsion(str, str1, idx1 + 1, idx2 + 1, cache);
		else if (fs2 == '*') {
			boolean op1 = wildcardrecurrsion(str, str1, idx1, idx2 + 1, cache);
			boolean op2 = wildcardrecurrsion(str, str1, idx1 + 1, idx2, cache);
			ans = op1 || op2;
		} else {
			return false;
		}
		if (ans == true)
			cache[idx1][idx2] = 1;
		else
			cache[idx1][idx2] = 0;
		return ans;
	}
}
