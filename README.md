# january13_2025
The problem that i solved today in leetcode

1.You are given a string s. You can perform the following process on s any number of times: Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i]. Delete the closest character to the left of index i that is equal to s[i]. Delete the closest character to the right of index i that is equal to s[i]. Return the minimum length of the final string s that you can achieve.

Code:
class Solution {
    public int minimumLength(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray())
            freq[c-'a']++;
        int i,len=0;
        for(i=0;i<26;i++)
        {
            if(freq[i]>=3)
            {
                while(freq[i]>=3)
                    freq[i]-=2;
            }
            len+=freq[i];
        }
        return len;
    }
}

2.Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Code:
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

3.You are given a sorted unique integer array nums. A range [a,b] is the set of all integers from a to b (inclusive). Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums. Each range [a,b] in the list should be output as: "a->b" if a != b "a" if a == b

Code:
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

4.Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Code:
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1)
            return intervals;
        List<int[]> l=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0])
                return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        int i;
        for(int[] x:intervals)
        {
            if(l.isEmpty() || l.get(l.size()-1)[1]<x[0])
                l.add(x);
            else
                l.get(l.size()-1)[1]=Math.max(l.get(l.size()-1)[1],x[1]);
        }
        int[][] res=new int[l.size()][2];
        i=0;
        for(int[] a:l)
            res[i++]=a;
        return res;
    }
}
