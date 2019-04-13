package algorithmJava;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

// Algorithms. Implementation. Hard. Problem Solving. Core Skills.
public class AngryZooAnimals {

    /*
     * Complete the 'angryAnimals' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

	public static boolean isEnemy(List<Integer> _aList,List<Integer> _bList,int _animal1,int _animal2) {

		for(int i=0;i<_aList.size();i++) {
			
			if(((_aList.get(i) == _animal1 ) && (_bList.get(i) == _animal2)) ||
					((_aList.get(i) == _animal2 ) && (_bList.get(i) == _animal1)))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public static List<Integer> getAnimalList(int _number) {
		
		List<Integer> tempList = new ArrayList<Integer>(_number);
				
		for(int i = 1; i <= _number;i++) {
			tempList.add(i);
		}
		
		return tempList;
	}
	
	public static long animalGroups(List <Integer> _animalSet,List<Integer> _aList,List<Integer> _bList) {
		Long lVal = 0L;
				
		Set<String> animalGroup = new TreeSet<String>();
		
		for(int i=0;i<_animalSet.size();i++) {
			for(int j=i;j<_animalSet.size();j++) {

				if(i == j) {
					animalGroup.add(""+_animalSet.get(i));
				}else if (!isEnemy(_aList,_bList,_animalSet.get(i),_animalSet.get(j))) {
					animalGroup.add(_animalSet.get(i)+","+_animalSet.get(j));
				} else {
					if(i<=j) {
						break;
					}
				}
			}			
		}
		for(String str:animalGroup) {
			System.out.println(str);
		}
		lVal = (long) animalGroup.size();
		
		return lVal;
	}
	
	
	
    public static long angryZooAnimals(int n, List<Integer> a, List<Integer> b) {
        // Write your code here

    	List<Integer> animalList = getAnimalList(n);
    	
    	if(animalList.size() != n) {
    		 throw new RuntimeException();
    	}
    	
        return animalGroups(animalList,a,b);
    }

    public static void main(String[] args) throws IOException {
    	    	
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

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

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println("result is " + angryZooAnimals(n, a, b));

    }

}
