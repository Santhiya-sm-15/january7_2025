class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> l=new ArrayList<>();
        int i,j,n=words.length;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(i!=j && words[j].contains(words[i]))
                {
                    l.add(words[i]);
                    break;
                }
            }
        }
        return l;
    }
}