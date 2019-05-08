package algorithmJava;

public class minPathSum {

	public static int minPath (int[][] grid) {
        int m = grid.length;
        int n = grid[m-1].length;
        int [][] visited = new int [m][n];
        return traverse(m - 1, n - 1, grid,visited);
    }
    private static int traverse(int m, int n, int[][] memo,int[][] visited) {
        if(m == 0 && n == 0){
            visited[m][n] = memo[m][n] ;
            return memo[m][n];
        }
        if(visited[m][n] != 0){
             return memo[m][n] ;
        }
        
        if(m == 0 ){
            memo[m][n] = memo[m][n] + traverse(m, n - 1, memo,visited);
            visited[m][n] = memo[m][n] ;
            return memo[m][n] ;
        }
        
        if(n == 0 ){
            memo[m][n] = memo[m][n] + traverse(m-1, n, memo,visited);
            visited[m][n] = memo[m][n] ;
            return memo[m][n] ;
        }
        int left = traverse(m - 1, n, memo,visited);
        int up = traverse(m, n - 1, memo,visited);

        memo[m][n] = memo[m][n] + (left < up? left:up);

        visited[m][n] = memo[m][n] ;
        return memo[m][n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]dungeon3 = {{2,3,3},
							{5,10,1},
							{10,30,5}};
		
		System.out.println(minPath(dungeon3));
	}

}
