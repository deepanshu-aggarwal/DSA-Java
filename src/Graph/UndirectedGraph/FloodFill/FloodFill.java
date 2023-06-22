package Graph.UndirectedGraph.FloodFill;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1}, {1,1,0}, {1,0,1}};
        int s_row = 1, s_col = 1;
        int color = 2;

        fillBfs(s_row, s_col, grid, color);
        for(int[] arr: grid) System.out.println(Arrays.toString(arr));
    }

    private static void fillBfs(int row, int col, int[][] grid, int color){
        int prev = grid[row][col];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, col));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int r = pair.r, c = pair.c;
            grid[r][c] = color;
            for(int i=0; i<4; i++){
                int new_r = r+dr[i], new_c = c+dc[i];
                if(new_r<0 || new_c<0 || new_r>=grid.length || new_c>=grid[0].length || grid[new_r][new_c]!=prev)   continue;
                q.add(new Pair(new_r, new_c));
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
