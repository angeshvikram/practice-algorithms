package algorithmJava;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LargestSubSquareGridSide {

	
	/* Constraints
	 * */
	
	
	public static boolean constraintsCheck (List<List<Integer>> _grid, int _k) {
		//1 ≤ k ≤ 109
		if(!((1 <= _k) && (_k <= 109))) {
			return false;
		}
		//1 ≤ n ≤ 1550
		if(!((1<=_grid.size()) && (_grid.size() <= 1550) )) {
			return false;
		}
		
		int totalVal = 0;
		//1 ≤ grid[i][j] ≤ 107
		for(int i = 0;i < _grid.size();i++) {
			for(int j = 0;j < _grid.get(i).size();j++) {
				if(!((1 <= (_grid.get(i)).get(j)) && ((_grid.get(i)).get(j) <= 107)) ){
					return false;
				}
				totalVal = totalVal + (_grid.get(i)).get(j);
			}			
		}
		
		//the total value of a grid is ≤ 109
		if(!((1 <= totalVal)&&(totalVal <=109))) {
			return false;
		}
		return true;
	}
	
	public static int addGrid(List<List<Integer>> _grid,int _n, int _iStart,int _jStart) {
		int totalVal = 0;
		for(int i = _iStart; ((i < _grid.size()) && (i < _n));i++) {
			for (int j = _jStart;((j < (_grid.get(i)).size()) &&(j < _n));j++) {
				totalVal = totalVal + (_grid.get(i)).get(j);
			}
		}
		return totalVal;
	}
	
    /*
     * Complete the 'largestSubsquareSide' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY grid
     *  2. INTEGER k
     */

    public static int largestSubsquareSide(List<List<Integer>> _grid, int k) {
        // Write your code here
    	
    	if(!constraintsCheck(_grid,k)) {
    		return 0;
    	}
    	int maxValue = 0;
    	int validSubgridSize = 0;
		foundMax: for(int i = 1; i <= _grid.size();i++) {
			for(int j = 0; j < _grid.size();j++) {
				for(int l = 0;l < _grid.get(j).size();l++) {
					int iStart = j;
					int lStart = l;
					int n = i;
					if((iStart <= _grid.size())&&(lStart <= _grid.get(iStart).size())) {
						int retMaxVal = addGrid(_grid,n,iStart,lStart);
						if(retMaxVal > k) {
							validSubgridSize = i-1;
							break foundMax;
						}
						if (maxValue < retMaxVal) {
							maxValue  = retMaxVal;
						}
					}
				}
			}
			validSubgridSize = i;
		}

    	
        return validSubgridSize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gridRows = Integer.parseInt(bufferedReader.readLine().trim());
        int gridColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> grid = new ArrayList<>();

        IntStream.range(0, gridRows).forEach(i -> {
            try {
                grid.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = largestSubsquareSide(grid, k);
        
        System.out.println(result);

    }
}
