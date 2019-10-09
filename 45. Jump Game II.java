class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i]==Integer.MAX_VALUE){
                return -1;
            }
            for(int j=i+1;j<=i+nums[i] && j<nums.length;j++){
                dp[j]=Math.min(dp[j],dp[i]+1);
            }
        }
        if(dp[dp.length-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[dp.length-1];
    }
}