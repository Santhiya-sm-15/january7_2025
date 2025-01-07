class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> rm=new HashMap<>();
        Map<Character,Integer> m=new HashMap<>();
        int i;
        for(i=0;i<ransomNote.length();i++)
        {
            char c=ransomNote.charAt(i);
            rm.put(c,rm.getOrDefault(c,0)+1);
        }
        for(i=0;i<magazine.length();i++)
        {
            char c=magazine.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> x:rm.entrySet())
        {
            if(m.containsKey(x.getKey()))
            {
                if(m.get(x.getKey())<x.getValue())
                    return false;
            }
            else
                return false;
        }
        return true;
    }
}