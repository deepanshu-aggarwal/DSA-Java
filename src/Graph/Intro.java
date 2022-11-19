package Graph;
import java.util.ArrayList;

public class Intro {
    public static void main(){
        int n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // initializing the list
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        // adding edges to the list
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(2);
        adj.get(2).add(3);

        // retrieving data
        for(int i=1; i<adj.size(); i++){
            for(int j=0; j<adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }
}
