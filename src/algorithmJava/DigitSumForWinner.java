package algorithmJava;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitSumForWinner { 
	
		/* Constraints check */
    	public static boolean isInputValid (long _a, long _b) {
    	
    		if((1 <= _a)&& (_a < _b) &&(_b <= 1018)) {
    			return false;
    		}
    	
    		return true;
    	}
    	
    	/* Adding digits*/
    	public static long digitSum (long _num){
    		long val = 0L;
    		while(_num > 9 ) {
    			val = val  + (_num % 10);
    			_num  = _num/10;
    		}
    		
    		val = val + _num;
    		
    		if(val > 9) {
    			return digitSum(val);
    		}
    		return val;
    	}
    	
	    /*
	     * Complete the 'waysToChooseSum' function below.
	     *
	     * The function is expected to return a LONG_INTEGER_ARRAY.
	     * The function accepts following parameters:
	     *  1. LONG_INTEGER a
	     *  2. LONG_INTEGER b
	     */

	    public static List<Long> waysToChooseSum(long _a, long _b) {
	        // Write your code here
	    	
	    	if(isInputValid(_a,_b)) {
	    		System.out.println("Inputnis not valid");
	    		return null;
	    	}
	    	
	    	// creating the ticket and other var
	    	Map<Long,Long> tempMap = new HashMap<Long,Long>();
	    	
	    	long winnerNumber = 0;
	    	long waysToChoose = 0;
//	    	long TotalNumberOfWinners = 0;
	    	
	    	for (long i  = _a; i <= _b;i++) {
	    		long sumVal = digitSum(i);
	    		
	    		if(tempMap.containsKey(sumVal)) {
	    			tempMap.put(sumVal, (tempMap.get(sumVal) + 1));
	    			
	    			if(winnerNumber  < tempMap.get(sumVal)) {
	    				winnerNumber = tempMap.get(sumVal);
	    			}
	    		}
	    		else {	    			
	    			tempMap.put(sumVal,1L);
	    		}
	    	}
	    	
			if((winnerNumber == 0)&(!tempMap.isEmpty())) {
				winnerNumber = 1;
			}

	    	for(long tempEle: tempMap.values()) {
	    		if(tempEle == winnerNumber) {
//	    			TotalNumberOfWinners = TotalNumberOfWinners + winnerNumber;
	    			waysToChoose++;
	    		}
	    	}
	    	
	    	List <Long> winnerDetails  = new ArrayList<Long>();
	    	winnerDetails.add(waysToChoose);
	    	winnerDetails.add(winnerNumber);
	    	
	        return winnerDetails;
	    }

	    
	    
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        long a = Long.parseLong(bufferedReader.readLine().trim());

	        long b = Long.parseLong(bufferedReader.readLine().trim());

	        List<Long> result = waysToChooseSum(a, b);
	        
	        System.out.println(result);

	    }

}
