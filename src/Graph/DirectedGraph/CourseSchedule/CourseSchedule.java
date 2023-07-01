package Graph.DirectedGraph.CourseSchedule;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        int numOfCourses = 4;
//        int[][] prerequisite = {{1, 0},
//                                {0, 1}};
        int[][] prerequisite = {{1, 0},
                                {2, 1},
                                {3, 2}};
        boolean[] vis = new boolean[numOfCourses];
        boolean[] pathVis = new boolean[numOfCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numOfCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisite.length; i++){
            adj.get(prerequisite[i][1]).add(prerequisite[i][0]);
        }
        boolean res = true;
        for(int i=0; i<numOfCourses; i++){
            if(!vis[i]){
                if(!findDfs(i, adj, vis, pathVis)){       // got cycle
                    res = false;
                    break;
                }
            }
        }
        System.out.println(res ? "true" : "false");
    }

    private static boolean findDfs(int u, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis){
        if(vis[u] && pathVis[u])  return false;
        if(vis[u])  return true;
        vis[u] = true;
        pathVis[u] = true;
        for(int v: adj.get(u)){
            if(!findDfs(v, adj, vis, pathVis))  return false;
        }
        pathVis[u] = false;
        return true;
    }
}
