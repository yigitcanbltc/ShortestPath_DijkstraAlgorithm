/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weightedgraphexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 *
 * @author yigit
 */
public class Graph  {
    ArrayList<Node> nodes; 
    ArrayList<Edge> edges;
    

    
    
    public Graph(){
       this.nodes = new ArrayList<Node>();
       this.edges = new ArrayList<Edge>();
      
   }
    
    public void addEdge(String src, String dst,int weight){
        edges.add(new Edge(src,dst,weight));
    }
    public void addNode(String character){
        nodes.add(new Node(character));
    }
    
    public void initializeSingleSource(Node root){
        for(Node node:nodes){
            if(node.character.equals(root.character)){
                node.cost=0;
            }
            else{
                node.cost=9999999;
            }
            node.parent=null;
        }
    }
    
   public Node getNodeByChar(String c) {
    for (Node node : nodes) {
        if (node.character.equals(c)) { 
            return node;
        }
    }
    return null;
}
    
public void findAdjectives() {
    for (Node node : nodes) {
        node.adjective = new ArrayList<>(); // Listeyi başlat
        for (Edge edge : edges) {
            if (edge.src.equals(node.character)) {
                Node destinationNode = getNodeByChar(edge.dst);
                if (destinationNode != null) { // Eğer hedef düğüm bulunduysa ekle
                    node.adjective.add(destinationNode);
                }
            }
        }
    }
}
public void Dijkstra(){
    initializeSingleSource(getNodeByChar("A"));
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
    priorityQueue.addAll(nodes);
    while(!priorityQueue.isEmpty()){
       Node u =   priorityQueue.poll();   
       for(Node node : u.adjective){
         Relax(u,node,getCost(u.character,node.character));  
       }
    }
}
public void Relax(Node u,Node v, int cost){
    if(v.cost>(u.cost+cost)){
    v.cost = (u.cost+cost);
    v.parent=u;
    }
}
public int getCost(String src,String dst){
    for(Edge edge: edges){
        if(edge.src.equals(src) && edge.dst.equals(dst)){
            return edge.weight;
        }
    }
    return 0;
}
public void printPath(String src,String dst){
    ArrayList<String> path = new ArrayList<>();
    Node ds = getNodeByChar(dst);
    Node sr = getNodeByChar(src);
    while(ds!=sr){
        path.add(ds.character);
        ds = ds.parent;
    }
    path.add(sr.character);
    Collections.reverse(path);
    System.out.print(path.get(0)+"->");
    for (int i=1;i<path.size()-1;i++) {
        System.out.print(path.get(i)+"->");   
    }   
    System.out.print(path.get(path.size()-1));
    System.out.println();
}


       
}
