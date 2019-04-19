package algorithmJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WeightedLexicographicallyStrings {

	/*
     * Complete the 'smallestString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER weight as parameter.
     */

	public static Map<Character, Long> getCharactersWeight (){
		
		Map<Character, Long> mWChar = new TreeMap<>();
		
		mWChar.put('A', (long) 1);
		
		for (long i = 2, j=1; i <  27; i++) {
			if(!checkConstrain(j)) {
				break;
			}
			j = (i)*j + i;
			mWChar.put((char) (i+64), (long)j);			
		}
		
		return mWChar;
	}
	public static List<String> getMaxWeightedChar(long weight) {
		//n = m*(n-1) + m [n = A-Z , m = 1,2,3,..., A=1]

		Map<Character, Long> mWChar = getCharactersWeight();
		List<String> sWChar = new ArrayList<>();
		
		for (int i = mWChar.size(); i >  0; i--) {
			if(mWChar.get((char) (i+64)) <= weight) {
				sWChar.add(""+(char) (i+64));
				if(weight >= 1) {
					sWChar.addAll(getMaxWeightedChar(weight-mWChar.get((char) (i+64))));
				}
				break;
			}
		}
		
		return sWChar;
	}
	
	public static boolean checkConstrain (long weight) {
		
		if((1 <= weight) && (weight <= 1016)) {
			return true;
		}
		
		return false;
	}
	
    public static String smallestString(long weight) {
        // Write your code here
    	
    	if(!checkConstrain(weight)) {
    		return null;
    	}
    	
    	List<String> tempObj = getMaxWeightedChar(weight);
    	
    	Collections.sort(tempObj);
    	String wStr = "";

    	for(String str: tempObj) {
    		wStr = wStr+str;
    	}    	
    	
        return wStr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long weight = Long.parseLong(bufferedReader.readLine().trim());

        String result = smallestString(weight);
        
        System.out.println(result);

    }

}
