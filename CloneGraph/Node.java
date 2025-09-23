package CloneGraph;

import java.util.*;

public class Node {
    public int val;
    public ArrayList<Node> neighbours;

    public Node(int val){
        this.val = val;
        this.neighbours = new ArrayList<>();
    }
    public Node(int val, ArrayList<Node> neighbours){
        this.val = val;
        this.neighbours = neighbours;
    }
    
    public static void main(String[] args) {
    }
}
