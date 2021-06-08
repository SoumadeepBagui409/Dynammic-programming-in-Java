//Top Down Approach 
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length];
        int cal =  minCost(days,costs,0,cache);
        return cal;
    }
    public static int minCost(int[] days,int[] cost,int idx,int[] cache){
        
        if(idx == days.length)
            return 0;
        if(cache[idx]!=0)
            return cache[idx];
        int ans = 0;
        int op1 = cost[0] + minCost(days,cost,idx+1,cache);
        int upto = days[idx]+7-1;
        int i;
        for(i =idx;i<days.length;i++){
            if(days[i]>upto)
                break;
        }
        int op2 = cost[1]+minCost(days,cost,i,cache);
        upto = days[idx]+30-1;
        for(i =idx;i<days.length;i++){
            if(days[i]>upto)
                break;
        }
        int op3 = cost[2] + minCost(days,cost,i,cache);
        ans =Math.min(op1,Math.min(op2,op3));
        //System.out.println(ans+" "+idx);
        cache[idx] = ans;
        return ans;
    }
}
