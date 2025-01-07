# january7_2025
The problems that I solved today

Leetcode Daily Challenge

1.Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.A substring is a contiguous sequence of characters within a string

Code:
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

2.Given an array nums of size n, return the majority element. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Code:
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

3.Given an integer array nums, find the subarray with the largest sum, and return its sum.

Code:
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

4.You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Code:
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int min=prices[0];
        int i;
        int max=0;
        for(i=1;i<n;i++)
        {
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
}

5.You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers. You should return the array of nums such that the the array follows the given conditions: Every consecutive pair of integers have opposite signs. For all integers with the same sign, the order in which they were present in nums is preserved. The rearranged array begins with a positive integer. Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

Code:
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0,neg=1,i,n=nums.length;
        int[] res=new int[n];
        for(i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                res[pos]=nums[i];
                pos+=2;
            }
            else
            {
                res[neg]=nums[i];
                neg+=2;
            }
        }
        return res;
    }
}

6.Given an m x n matrix, return all elements of the matrix in spiral order.

Code:
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i,n=matrix.length,m=matrix[0].length;
        List<Integer> res=new ArrayList<>();
        int rowS=0,colS=0,rowE=n-1,colE=m-1;
        while(rowS<=rowE && colS<=colE)
        {
            for(i=colS;i<=colE;i++)
                res.add(matrix[rowS][i]);
            rowS++;
            for(i=rowS;i<=rowE;i++)
                res.add(matrix[i][colE]);
            colE--;
            if(rowS<=rowE)
            {
                for(i=colE;i>=colS;i--)
                    res.add(matrix[rowE][i]);
                rowE--;
            }
            if(colS<=colE)
            {
                for(i=rowE;i>=rowS;i--)
                    res.add(matrix[i][colS]);
                colS++;
            }
        }
        return res;
    }
}

7.Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

Code:
class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j,n=matrix.length,m=matrix[0].length;
        List<int[]> l=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                    l.add(new int[]{i,j});
            }
        }
        for(int[] x:l)
        {
            for(i=0;i<m;i++)
                matrix[x[0]][i]=0;
            for(i=0;i<n;i++)
                matrix[i][x[1]]=0;
        }
    }
}

8.According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970." The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously. Given the current state of the board, update the board to reflect its next state.

Code:
class Solution {
    public void gameOfLife(int[][] board) {
        int i,j,k,n=board.length,m=board[0].length;
        int[][] dir={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        List<int[]> ones=new ArrayList<>();
        List<int[]> zeros=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                int live=0;
                for(int[] d:dir)
                {
                    int nr=i+d[0];
                    int nc=j+d[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && board[nr][nc]==1)
                        live++;
                    if(i==1 && j==0)
                        System.out.println(nr+" "+nc);
                }
                if(board[i][j]==1)
                {
                    if(live<2)
                        zeros.add(new int[]{i,j});
                    else if(live>3)
                        zeros.add(new int[]{i,j});
                }
                else
                {
                    if(live==3)
                        ones.add(new int[]{i,j});
                }
            }
        }
        for(int[] x:zeros)
            board[x[0]][x[1]]=0;
        for(int[] x:ones)
            board[x[0]][x[1]]=1;
    }
}

9.Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise. Each letter in magazine can only be used once in ransomNote.

Code:
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
