/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weightedgraphexample;

import java.util.ArrayList;

/**
 *
 * @author yigit
 */
public class Node implements Comparable<Node> {
    public String character;
    public int cost;
    public Node parent;
    ArrayList<Node> adjective;
    
    public Node(String character){
        this.character=character;
        this.parent=null;

    }
   @Override
    public int compareTo(Node other) {
        // Düğümleri maliyetlerine göre karşılaştırma yapacak şekilde compareTo metodunu uygulayalım.
        // Düşük maliyetli düğümler öncelikli olacak şekilde sıralama yaparız.
        return Integer.compare(this.cost, other.cost);
    }
} 

