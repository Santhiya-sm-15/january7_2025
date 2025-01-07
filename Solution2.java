class Solution {
    public int majorityElement(int[] nums) {
        int val=-1,cnt=0,i,n=nums.length;
        for(i=0;i<n;i++)
        {
            if(cnt==0)
            {
                val=nums[i];
                cnt=0;
            }
            if(val==nums[i])
                cnt++;
            else
                cnt--;
        }
        cnt=0;
        for(i=0;i<n;i++)
        {
            if(nums[i]==val)
                cnt++;
        }
        System.out.println(val+" "+cnt);
        return cnt>n/2?val:-1;
    }
}