package Graph.UndirectedGraph;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},
                        {0,1,1,0},
                        {0,0,1,0},
                        {0,0,0,0},
                        {1,1,0,1}};
        int count = 0;
        boolean[][] vis = new boolean[5][4];
        for(int i=0; i<5; i++){
            for(int j=0; j<4; j++){
                if(!vis[i][j] && grid[i][j]!=0){
                    dfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int r, int c, int[][] grid, boolean[][] vis){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0 || vis[r][c])   return;
        vis[r][c] = true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int i=0; i<4; i++){
            int nr = r + dr[i], nc = c + dc[i];
            dfs(nr, nc, grid, vis);
        }
    }
}
