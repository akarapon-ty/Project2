package com.findtheway;

import android.util.Log;

import java.util.ArrayList;
// now we must create graph object and implement dijkstra algorithm
public class Graph {
    ArrayList<Node> nodes = new ArrayList<>();
    private int noOfNodes;
    ArrayList<Edge> edges = new ArrayList<>();
    private int noOfEdges;

    public Graph(ArrayList<Edge> edges, ArrayList<Node> nodes) {
        this.edges = edges;
        // create all nodes ready to be updated with the edges
        this.noOfNodes = nodes.size();
        this.nodes = nodes;
        // add all the edges to the nodes, each edge added to two nodes (to and from)
        this.noOfEdges = edges.size();

        for (int i = 0; i < this.noOfEdges; i++) {
            Edge edgeToAdd = edges.get(i);
            edgeToAdd.getNodefrom().getEdges().add(edgeToAdd);
            edgeToAdd.getNodeto().getEdges().add(edgeToAdd);
        }
    }

    // next video to implement the Dijkstra algorithm !!!
    public void calculateShortestDistances(Node sourceNode) {
        // node 0 as source

        for (int n = 0; n < this.noOfNodes; n++) {
            this.nodes.get(n).setDistanceFromSource(Integer.MAX_VALUE);
            this.nodes.get(n).setVisited(false);
        }
        sourceNode.setDistanceFromSource(0);
        sourceNode.setVisited(true);
        Node nextNode = sourceNode;
        // visit every node
        for (int i = 0; i < nodes.size(); i++) {
            // loop around the edges of current node
            ArrayList<Edge> currentNodeEdges = nextNode.getEdges();
            for (int joinedEdgeIndex = 0; joinedEdgeIndex < currentNodeEdges.size(); joinedEdgeIndex++) {
                Edge jointEdge = currentNodeEdges.get(joinedEdgeIndex);
                Node neighbour = jointEdge.getNeighbour(nextNode);
                // only if not visited
                if (!neighbour.isVisited()) {
                    int tentative = nextNode.getDistanceFromSource() + jointEdge.getDistance();
                    if (tentative < neighbour.getDistanceFromSource()) {
                        neighbour.setDistanceFromSource(tentative);
                        neighbour.setPrevNode(nextNode);
                        neighbour.setPrevEdge(jointEdge);
                    }
                }
            }
            // all neighbours checked so node visited
            nextNode.setVisited(true);
            // next node must be with shortest distance
            nextNode = getNodeShortestDistanced();

        }
    }

    // now we're going to implement this method in next part !
    private Node getNodeShortestDistanced() {
        Node node = nodes.get(0);
        int storedDist = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            int currentDist = nodes.get(i).getDistanceFromSource();
            if (!this.nodes.get(i).isVisited() && currentDist < storedDist) {
                storedDist = currentDist;
                node = nodes.get(i);
            }
        }
        return node;
    }

    public ArrayList<Edge> getNavigationto(Node node)
    {
        ArrayList<Edge> edgeindex = new ArrayList<>();
        while(node.getPrevNode() != null)
        {
            Log.d("Check Station", ""+node.getID() + ","+node.getLine());
            edgeindex.add(0,node.getPrevEdge());
            node = node.getPrevNode();
        }
        return edgeindex;
    }

    // display result
    public void printResult() {
        String output = "Number of nodes = " + this.noOfNodes;
        output += "\nNumber of edges = " + this.noOfEdges;
        for (int i = 0; i < nodes.size(); i++) {
            output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes.get(i).getDistanceFromSource());
      }
        System.out.println(output);
    }
}