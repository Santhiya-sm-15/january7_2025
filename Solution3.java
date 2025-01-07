class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,max=Integer.MIN_VALUE;
        int i;
        for(i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            max=Math.max(max,sum);
            if(sum<0)
                sum=0;
        }
        return max;
    }
}