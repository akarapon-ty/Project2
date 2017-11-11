package com.findtheway;

/**
 * Created by Ty on 11/10/2017.
 */

public class Main {
    public static void main(String[] args){
        Edge[] edges = {
                new Edge(0,2,1),
                new Edge(0,3,4),
                new Edge(0,4,2),
                new Edge(0,1,3),
                new Edge(1,3,2),
                new Edge(1,4,3),

        };
        Graph g = new Graph(edges);
        g.calculateShortestDistance();

        g.printresult();
    }
}

