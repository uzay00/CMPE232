package Lecture4;

import Lecture3.Graph;
import Lecture3.BreadthFirstPaths;
import edu.princeton.cs.algs4.StdIn;

public class DegreesOfSeparation {

    public static void findWay(BreadthFirstPaths bfs, SymbolGraph sg, String source, String sink){ 
        System.out.println("The way from " + source + " to " + sink);
        if (sg.contains(sink)) {
            int t = sg.index(sink);
            if (bfs.hasPathTo(t)) {
                for (int v : bfs.pathTo(t)) {
                    System.out.println(" " + sg.name(v));
                }
            } else {
                System.out.println("Not connected");
            }
        } else {
            System.out.println("Not in database.");
        }   
    }
    
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("routes.txt", " ");
        Graph G = sg.G();
        System.out.println("Graph");
        System.out.println(sg);
        
        String source = "JFK";
        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        String sink = "DEN";
        findWay(bfs, sg, source, sink);
    }
}
