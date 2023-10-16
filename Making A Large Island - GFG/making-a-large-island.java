//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class DSU
{
    int parent[];
    int height[];
    int size[];
 
    public DSU(int n)
    {
        height = new int[n];
        parent = new int[n];
        size = new int[n];
        Arrays.fill(height , 1);
        Arrays.fill(parent , -1);
        Arrays.fill(size , 1);
    }
 
    public int findRoot(int node)
    {
        if(parent[node] == -1)
            return node;
        return (parent[node] = findRoot(parent[node]));
    }
 
    public int union(int node1 , int node2)
    {
        int ra = findRoot(node1);
        int rb = findRoot(node2);
        if(ra != rb)
        {
            if(height[ra] < height[rb])
            {
                parent[ra] = rb;
                size[rb] += size[ra];
                return size[rb];
            }
            else if(height[rb] < height[ra])
            {
                parent[rb] = ra;
                size[ra] += size[rb];
                return size[ra];
            }
            else
            {
                parent[rb] = ra;
                height[ra] ++;
                size[ra] += size[rb];
                return size[ra];
            }
        }
        return -1;
    }
}
 
class Solution {
 
    public int bfs(DSU dsu , int i , int j , int[][] grid , boolean visited[][])
    {
        Queue<Integer> q = new LinkedList<>();
        int n = grid.length;
        int dir[][] = new int[][] {{0 , -1} , {0 , 1} , {-1 , 0} , {1 , 0}};
        visited[i][j] = true;
        q.add(i * n + j);
 
        int size = 0;
        while(!q.isEmpty())
        {
            int cell = q.poll();
            int r = cell / n;
            int c = cell % n;
            size ++;
 
            for(int k = 0 ; k < dir.length ; k ++)
            {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc] && grid[nr][nc] == 1)
                {
                   q.add(nr * n + nc);
                   dsu.union(nr * n + nc , cell);
                   visited[nr][nc] = true;
                }
            }
        }
 
        return size;
    }
 
    public int largestIsland( int n, int[][] grid) {
 
        
        DSU dsu = new DSU(n * n);
        int size = 0;
        int dir[][] = new int[][] {{0 , -1} , {0 , 1} , {-1 , 0} , {1 , 0}};
        int maxSize = 0;
        boolean visited[][] = new boolean[n][n];
 
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j < n ; j ++)
                if(grid[i][j] == 1 && !visited[i][j])
                    maxSize = Math.max(maxSize , bfs(dsu , i , j , grid , visited));
 
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j < n ; j ++)
                if(grid[i][j] == 0)
                {
                    Set<Integer> set = new HashSet<>();
                    for(int k = 0 ; k < dir.length ; k ++)
                    {
                        int nr = i + dir[k][0];
                        int nc = j + dir[k][1];
                        if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1)
                            set.add(dsu.findRoot(nr * n + nc));
                    }
                    int totSize = 1;
                    for(int root : set)
                        totSize += dsu.size[root];
                    maxSize = Math.max(maxSize , totSize);
                }
 
        return maxSize;
    }
}