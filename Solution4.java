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