class Solution {
    public int waysToMakeFair(int[] nums) {    
        int[] arr = new int[nums.length+2];
        for(int i= 2;i<arr.length;i++){
            arr[i] = nums[i-2];
        }
        int odd = 0;
        int even = 0;
        for(int i =2;i<arr.length;i++){
            arr[i]+=arr[i-2];
            if((i-1)%2!=0){
                odd = Math.max(odd ,arr[i]);
            }else{
                even = Math.max(even,arr[i]);
            }
        }
        int val = 0;
        for(int i=2;i<arr.length;i++){
            if((i-1)%2!=0){
                int part1 = odd-arr[i];
                int part2 = even-arr[i-1];
                int eql1 = arr[i]-nums[i-2]+part2;
                int eql2 = arr[i-1]+part1;
                if(eql1==eql2)val++;
                //System.out.println(i-1+" "+eql1+" "+eql2);
            }
            else{
                int part1 = even-arr[i];
                int part2 = odd-arr[i-1];
                int eql1 = arr[i]-nums[i-2]+part2;
                int eql2 = arr[i-1]+part1;
                if(eql1==eql2)val++;
                //System.out.println(i-1+" "+eql1+" "+eql2);
            }   
        
        }
        return val;
    }
}
