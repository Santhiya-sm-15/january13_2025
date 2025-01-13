class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> l=new ArrayList<>();
        int i=0,n=nums.length;
        while(i<n)
        {
            int j=i;
            while(j<n-1 && nums[j]+1==nums[j+1])
                j++;
            if(nums[i]!=nums[j])
                l.add(new String(nums[i]+"->"+nums[j]));
            else
                l.add(new String(""+nums[i]));
            i=j+1;
        }
        return l;
    }
}