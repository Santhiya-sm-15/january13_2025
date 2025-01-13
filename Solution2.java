class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i,n=nums.length;
        HashMap<Integer,Integer> m=new HashMap<>();
        for(i=0;i<n;i++)
        {
            if(m.containsKey(nums[i]))
            {
                if(i-m.get(nums[i])<=k)
                    return true;
            }
            m.put(nums[i],i);
        }
        return false;
    }
}