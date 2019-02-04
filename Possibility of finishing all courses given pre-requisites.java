public class Solution {
    int dfs(ArrayList<ArrayList<Integer>> F,int a[],int i)
    {
        a[i] = 1;
        for(int j = 0; j < F.get(i).size(); j++)
        {
            if(a[F.get(i).get(j)] == 1)
            {
                return 0;
            }
            else if(a[F.get(i).get(j)] == 2)
            {
                continue;
            }
            else
            {
                int h =  dfs(F,a,F.get(i).get(j));
                if(h == 0)
                    return 0;
            }
            
        }
        a[i] = 2;
        return 1;
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList<ArrayList<Integer>> F = new ArrayList();
        for(int i = 0; i < A; i++)
        {
           ArrayList<Integer> l = new ArrayList();
           F.add(l);     
        }
        for(int i = 0; i < B.size(); i++)
        {
            F.get(C.get(i)-1).add(B.get(i)-1);
        }
        int[] a = new int[A];
        for(int i = 0; i < A; i++)
        {
            a[i] = 0;
        }
        for(int i = 0; i < F.size(); i++)
        {
            int h = dfs(F,a,i);
            if(h == 0)
                return 0;
        }
        return 1;
    }
}
