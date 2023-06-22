package Graph.UndirectedGraph.NearestCellHaving1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NearestCellHavingOne {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,1}, {1,1,0}, {1,0,0}};
        int[][] res = bfsFind(grid);
        for(int[] arr: grid){
            System.out.println(Arrays.toString(arr));
        }
        for(int[] arr: res){
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] bfsFind(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) {
                    q.add(new Pair(i, j, 0));
                    res[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int r = pair.r, c = pair.c, dist = pair.dist;
            if(grid[r][c]==0)   res[r][c] = dist;
            for(int i=0; i<4; i++){
                int new_r = r+dr[i], new_c = c+dc[i];
                if(new_r<0 || new_c<0 || new_r>=m || new_c>=n || vis[new_r][new_c]) continue;
                q.add(new Pair(new_r, new_c, dist+1));
                vis[new_r][new_c] = true;
            }
        }
        return res;
    }
}

class Pair{
    int r, c, dist;
    Pair(int r, int c, int dist){
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}
