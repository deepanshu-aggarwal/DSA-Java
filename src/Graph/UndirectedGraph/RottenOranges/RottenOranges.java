package Graph.UndirectedGraph.RottenOranges;

import Graph.UndirectedGraph.Graph;

import java.util.*;

class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int m=grid.length, n=grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0 ;i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int maxTime = 0;
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Pair curr = q.poll();
                int r = curr.row, c = curr.col, t = curr.time;
                maxTime = Math.max(maxTime, t);
                for(int i=0; i<4; i++){
                    int n_row = r+row[i];
                    int n_col = c+col[i];
                    if(n_row>=0 && n_row<m && n_col>=0 && n_col<n
                            && grid[n_row][n_col]==1 && !vis[n_row][n_col]){
                        vis[n_row][n_col] = true;
                        q.add(new Pair(n_row, n_col, t+1));
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]==1) System.out.print(-1);
            }
        }
        System.out.print(maxTime);
    }
}
