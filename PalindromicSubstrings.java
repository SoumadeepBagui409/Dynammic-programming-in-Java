class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i =0;i<s.length();i++){
                int  st = i;
                int ed = i;
                while(st>=0 && ed<s.length() && s.charAt(st)==s.charAt(ed)){
                    ans++;
                    st--;
                    ed++;
                }
        }
        for(int i =0;i<s.length();i++){
            if(i>=1){
                int st = i-1;
                int ed = i;
                while(st>=0 && ed<s.length() && s.charAt(st)==s.charAt(ed)){
                    ans++;
                    st--;
                    ed++;
                }
            }
        }
        return ans;
    }
}
