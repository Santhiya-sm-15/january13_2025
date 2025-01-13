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