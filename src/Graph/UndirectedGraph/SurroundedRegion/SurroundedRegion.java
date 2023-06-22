package Graph.UndirectedGraph.SurroundedRegion;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SurroundedRegion {
    public static void main(String[] args) {
        char[][] grid = {{'X', 'X', 'X', 'X', 'X'},
                         {'X', 'O', 'O', 'X', 'O'},
                         {'X', 'X', 'O', 'X', 'O'},
                         {'X', 'O', 'X', 'O', 'X'},
                         {'O', 'O', 'X', 'X', 'X'}};
        findBfs(grid);
        for(char[] arr: grid) System.out.println(Arrays.toString(arr));
    }

    private static void findBfs(char[][] grid){
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && grid[i][j]=='O'){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r, c = p.c;
            for(int i=0; i<4; i++){
                int new_r = r+dr[i], new_c=c+dc[i];
                if(new_r<0 || new_c<0 || new_r>=m || new_c>=n || vis[new_r][new_c] || grid[new_r][new_c]=='X')  continue;
                q.add(new Pair(new_r, new_c));
                vis[new_r][new_c] = true;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='O' && !vis[i][j])   grid[i][j] = 'X';
            }
        }
    }
}

class Pair{
    int r, c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
