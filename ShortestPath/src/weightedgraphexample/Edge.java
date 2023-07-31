/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weightedgraphexample;

/**
 *
 * @author yigit
 */
public class Edge {
    public int weight;
    public String src;
    public String dst;
    
    public Edge(String src, String dst,int weight){
        this.src=src;
        this.dst=dst;
        this.weight=weight;
    }
   
}
