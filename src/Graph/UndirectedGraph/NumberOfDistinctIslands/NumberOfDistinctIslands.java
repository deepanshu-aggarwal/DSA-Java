package Graph.UndirectedGraph.NumberOfDistinctIslands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {1, 1, 0, 1, 0}};
        int distinct = findDistinct(grid);
        System.out.println(distinct);
    }

    private static int findDistinct(int[][] grid){
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        HashSet<List<String>> set = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    List<String> pattern = new ArrayList<>();
                    dfs(i, j, pattern, grid, vis, i, j);
                    set.add(pattern);
                }
            }
        }
        for(List<String> list: set){
            System.out.println(list);
        }
        return set.size();
    }

    private static void dfs(int r, int c, List<String> pattern, int[][] grid, boolean[][] vis, int row_s, int col_s){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0 || vis[r][c])   return;
        vis[r][c] = true;
        pattern.add(toString(r-row_s, c-col_s));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int i=0; i<4; i++){
            int new_r = r+dr[i], new_c = c+dc[i];
            dfs(new_r, new_c, pattern, grid, vis, row_s, col_s);
        }
    }

    private static String toString(int r, int c){
        return r + " " + c;
    }
}
