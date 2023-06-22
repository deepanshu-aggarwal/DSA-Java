package Graph.UndirectedGraph.NumberOfEnclaves;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 1},
                        {0, 1, 1, 0}};
        int count = countBfs(grid);
        System.out.println(count);
    }

    private static int countBfs(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && grid[i][j]==1){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int r = pair.r, c = pair.c;
            for(int i=0; i<4; i++){
                int new_r = r+dr[i], new_c = c+dc[i];
                if(new_r<0 || new_c<0 || new_r>=m || new_c>=n || vis[new_r][new_c] || grid[new_r][new_c]==0)    continue;
                q.add(new Pair(new_r, new_c));
                vis[new_r][new_c] = true;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !vis[i][j]) count++;
            }
        }
        return count;
    }
}

class Pair{
    int r, c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
