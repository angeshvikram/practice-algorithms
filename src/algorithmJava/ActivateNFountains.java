package algorithmJava;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ActivateNFountains {

	/* 
	 * Constraints
	 */
	public static boolean checkConstraints(List<Integer> a) {
		
		//1 ≤ n ≤ 105
		if((a.size() <1 ) || (a.size() > 105)) {
			return false;
		}
		//0 ≤ a[i] ≤ min( n,100) (where 1 ≤ i ≤ 105)
		for (int iVal: a) {
			if((iVal <0) || (iVal > min(a.size(),100))) {
				return false;
			}
		}
		
		return true;
		
	}
	
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(j > i) {
    		return j;
    	}
		return i;
	}

    private static int min(int size, int i) {
		// TODO Auto-generated method stub
    	if(size > i) {
    		return i;
    	}
		return size;
	}
	
	public static int getToRange (List<Integer> _a,int _pos) {
		
		int ToRange = min( (_pos + _a.get(_pos)), _a.size() );
				
		return ToRange;
	}

	public static int getFromRange (List<Integer> _a,int _pos) {
		
		int fromRange = max( (_pos - _a.get(_pos)), 1 );	
		
		return fromRange;
	}

	private static int getNextRange(List<Integer> _a, int _pos) {
		// TODO Auto-generated method stub
		int toRange = getToRange(_a,_pos);
		int fromRange = getFromRange(_a,_pos);
		int _temp = toRange+1;
		for(int i = _temp; ((toRange >= fromRange) && (i<_a.size()));i++) {
			fromRange = getFromRange(_a,i);
			_temp = i;
		}
		return _temp;
	}
	    
	public static List<Integer> numberOfRuns(List<Integer> _a,int _pos) {
		List<Integer> lFountainPos = new ArrayList<Integer>();
		for (int i=_pos;i<_a.size();) {
			lFountainPos.add(i);
			i = getNextRange(_a,i);
		}
		return lFountainPos;
	}

	/*
     * Complete the 'fountainActivation' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int fountainActivation(List<Integer> a) {
        // Write your code here
    	int minActivatedFountain = 105;
    	List<Integer> lFountainPos = new ArrayList<Integer>();
	
    	for(int i=0;i<a.size();i++) {
    		int temp = getFromRange(a,i) ;
    		if((!lFountainPos.contains(i)) &&(temp <= (i+1))){
    			List<Integer> tempRun = numberOfRuns(a,i);
    			lFountainPos.addAll(tempRun);
    			if(tempRun.size() < minActivatedFountain) {
    				minActivatedFountain = tempRun.size();
    			}    			
    		}
    	}
    	
        return minActivatedFountain;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println("Answer :");
        int result = fountainActivation(a);
        
        System.out.println(result);

    }
}
