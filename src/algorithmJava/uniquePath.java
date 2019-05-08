package algorithmJava;

import java.util.ArrayList;
import java.util.List;

public class uniquePath {
	//Solution #1: using an auxilliary matrix

	class Solution1 {
	    public int uniquePaths(int m, int n) {
	        int[][] dp = new int[m][n];
	        for(int i = 0;i < m;i++) 
	            for(int j = 0;j < n;j++) 
	                dp[i][j] = i == 0 || j == 0 ? 1 : dp[i - 1][j] + dp[i][j - 1];
	        return dp[m - 1][n - 1];
	    }
	}
	//Solution #2: using recursive calling with an memoir

	class Solution2 {
	    public int uniquePaths(int m, int n) {
	        return traverse(m - 1, n - 1, new int[m][n]);
	    }
	    
	    private int traverse(int m, int n, int[][] memo) {
	        if(m == 0 || n == 0)return 1;
	        if(memo[m][n] != 0)return memo[m][n];
	        memo[m][n] = traverse(m - 1, n, memo) + traverse(m, n - 1, memo);
	        return memo[m][n];
	    }
	}

	class Solution {
	    
	    class Node{
	        int x;
	        int y;
	        Node(int x,int y){
	            this.x  = x;
	            this.y = y;
	        }
	    }
	    
	    public boolean isValidMove(boolean[][] matrix, int x, int y){
	        return!(x<0  || x >= matrix.length || y  < 0 || y >= matrix[0].length);
	    }
	    public List<Node> getNeighbors(boolean[][] matrix, Node node){
	        List<Node> neighbors = new ArrayList<>();
	        if(isValidMove(matrix, node.x+1, node.y) && !(matrix[node.x+1][node.y])){
	            // matrix[node.x+1][node.y] = true;
	            // System.out.println((node.x+1)+ "  " + node.y);
	            neighbors.add(new Node(node.x+1,node.y));
	        }
	        if(isValidMove(matrix, node.x, node.y+1)&& !(matrix[node.x][node.y+1])){
	            // matrix[node.x][node.y+1] = true;
	            // System.out.println(node.x+ "  " + (node.y+1));
	            neighbors.add(new Node(node.x,node.y+1));
	        }
	        return  neighbors;  
	    }
	    public int uniquePaths(int m, int n) {
	        boolean [][] matrix = new boolean[m][n];
	        
	        if(m<2||n<2){ return 1;}
	        
	        int countPath = 0;
	        List<Node> queue = new ArrayList<>();
	        queue.add(new Node(0,0));
	        // matrix[0][0]  = true;
	        
	        while(!queue.isEmpty()){
	            Node current = queue.remove(0);
	            if(current.x == m-1 && current.y == n-1){
	                countPath++;
	            }
	            queue.addAll(getNeighbors(matrix,current));
	        }
	        
	        return countPath;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
