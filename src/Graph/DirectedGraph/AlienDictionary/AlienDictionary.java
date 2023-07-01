package Graph.DirectedGraph.AlienDictionary;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        int k = 3;
//        String[] dict = {"baa","abcd","abca","cab","cad"};
        String[] dict = {"caa","aaa","aab"};
        HashMap<Character, List<Character>> adj = new HashMap<>();
        for(int i=0; i<k; i++)  adj.put((char)(i+97), new ArrayList<>());
        generateGraph(dict, adj);
        HashSet<Character> vis = new HashSet<>();
        HashSet<Character> pathVis = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(Map.Entry<Character, List<Character>> entry: adj.entrySet()){
            if(!vis.contains(entry.getKey())){
                if(checkCycle(entry.getKey(), adj, vis, pathVis, st))   break;
            }
        }
        while(!st.isEmpty())    sb.append(st.pop());
        System.out.println(sb);
    }

    private static boolean checkCycle(char u, HashMap<Character, List<Character>> adj, HashSet<Character> vis, HashSet<Character> pathVis, Stack<Character> st){
        if(vis.contains(u) && pathVis.contains(u)) return true;
        if(vis.contains(u)) return false;
        vis.add(u);
        pathVis.add(u);
        for(char v: adj.get(u)){
            if(checkCycle(v, adj, vis, pathVis, st)) return true;
        }
        st.push(u);
        pathVis.remove(u);
        return false;
    }

    private static void generateGraph(String[] dict, HashMap<Character, List<Character>> adj){
        int n = dict.length;
        for(int i=0; i<n-1; i++){
            int len = Math.min(dict[i].length(), dict[i+1].length());
            for(int j=0; j<len; j++){
                if(dict[i].charAt(j)!=dict[i+1].charAt(j)){
                    adj.get(dict[i].charAt(j)).add(dict[i+1].charAt(j));
                    break;
                }
            }
        }
    }
}
