package algorithmJava;

import java.util.Arrays;

public class CherryPick {

	
	public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        if(m < 1){
            return 0;
        }
        int[][] visited = new int[m][m];
        System.out.println(Arrays.deepToString(grid));
        int retVal = Traverses(m-1,m-1,grid,visited);
        // System.out.println(retVal);
        
        if(retVal < 1){
            return 0; 
        }
        // return retVal; 
        System.out.println(Arrays.deepToString(grid));
        grid[m-1][m-1] = 0;
        int[][] visited2 = new int[m][m];
        int retVal2 = Traverses(m-1,m-1,grid,visited2);
        // System.out.println(retVal2);
        if(retVal2 < 1){
            return retVal; 
        }
        System.out.println(Arrays.deepToString(grid));
        
        return retVal+retVal2;
    }
    public static int Traverses(int m,int n,int [][] grid,int [][] Visited){
        if((m == 0)&&(n==0))  {
            if(grid[m][n] == -1){
                return -1;
            }
            Visited[m][n]  = grid[m][n];
             System.out.println("m: "+m+ " and n: "+n);
             System.out.println("1: "+Visited[m][n]);
            return Visited[m][n];
        }
        // already Visited Node
        if(Visited[m][n] > 0){
             System.out.println("m: "+m+ " and n: "+n);
             System.out.println("4: "+Visited[m][n]);
            return Visited[m][n];
        }

        // Top border
        if(m == 0){
            if(grid[m][n] == -1){
                return -1;
            }
            int retVal = Traverses(m,n-1,grid,Visited);
            if(retVal == -1){
                return -1;
            }
            Visited[m][n]  = grid[m][n] + retVal;
             System.out.println("m: "+m+ " and n: "+n);
             System.out.println("2: "+Visited[m][n]);
            return Visited[m][n];
        }
        // Left border border
        if(n == 0){
            if(grid[m][n] == -1){
                return -1;
            }
            int retVal = Traverses(m-1,n,grid,Visited);
            if(retVal == -1){
                return -1;
            }
            Visited[m][n]  = grid[m][n] + retVal;
             System.out.println("m: "+m+ " and n: "+n);
             System.out.println("3: "+Visited[m][n]);
            return Visited[m][n];
        }
        if(grid[m][n] == -1){
                return -1;
        }
        // main logic
        int left = Traverses(m-1,n,grid,Visited);
        int top = Traverses(m,n-1,grid,Visited);
        if((left == -1) &&  (top == -1)) return -1;
        if((left == 0) &&  (top == 0)) return 0;
           
        Visited[m][n] = grid[m][n] + (left > top? left: top);
        // grid[m][n] = 0;
         System.out.println("m: "+m+ " and n: "+n);
         System.out.println("5: "+Visited[m][n]);
         if(left == top) {
             grid[m-1][n] = 0;
         }
         else if(left > top) {
            grid[m-1][n] = 0;
        }
        else if(top > left){
            grid[m][n-1] = 0;
        }
        return Visited[m][n];  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  [][] matrix = {{0,1,1,0,0},
							{1,1,1,1,0},
							{-1,1,1,1,-1},
							{0,1,1,1,0},
							{1,0,-1,0,0}};
		
		System.out.println(cherryPickup(matrix));
	}

}
