package algorithmJava;

import java.util.ArrayList;
import java.util.List;

public class PathfinderIn2DArray {

	static class Node {
	    int x;
	    int y;
	    
	    Node(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
	
	public static boolean isValidPoint(char[][] matrix, int x, int y) {
        return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0');
    }
	
	public static List<Node> getNeighbors(char[][] matrix, Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        
        if(isValidPoint(matrix, node.x - 1, node.y)) {
            neighbors.add(new Node(node.x - 1, node.y));
        }
        
        if(isValidPoint(matrix, node.x + 1, node.y)) {
            neighbors.add(new Node(node.x + 1, node.y));
        }
        
        if(isValidPoint(matrix, node.x, node.y - 1)) {
            neighbors.add(new Node(node.x, node.y - 1));
        }
        
        if(isValidPoint(matrix, node.x, node.y + 1)) {
            neighbors.add(new Node(node.x, node.y + 1));
        }
        
        return neighbors;
    }
	
    public static boolean pathExists(char[][] matrix) {
        int N = matrix.length;
        
        List<Node> queue = new ArrayList<Node>();
        queue.add(new Node(0, 0));
        boolean pathExists = false;
        
        while(!queue.isEmpty()) {
            Node current = queue.remove(0);
            if(matrix[current.x][current.y] == 'X') {
                pathExists = true;
                break;
            }
            
            matrix[current.x][current.y] = '0'; // mark as visited
            
            List<Node> neighbors = getNeighbors(matrix, current);
            queue.addAll(neighbors);
        }
        
        return pathExists;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] matrix = {
	            {'1', '0', '1', '1'},
	            {'0', '1', '1', '1'},
	            {'1', '1', '1', '1'},
	            {'1', '1', '1', 'X'}
	        };
	        
	        boolean pathExists = pathExists(matrix);
	        
	        System.out.println(pathExists ? "YES" : "NO");
	        
	}

}
