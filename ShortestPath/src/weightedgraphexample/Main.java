/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weightedgraphexample;

/**
 *
 * @author yigit
 */
public class Main {
    
     public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        
        graph.addEdge("A","B",10 );
        graph.addEdge("A","C", 5);
        graph.addEdge("B","A",3);
        graph.addEdge("B","C",3);
        graph.addEdge("B","D", 6);
        graph.addEdge("C","B", 2);
        graph.addEdge("C","D", 10);
        graph.addEdge("D","B", 2);
        
        
        graph.findAdjectives();
        graph.Dijkstra();
        graph.printPath("A","D");
        
        
        
    }
    
}
