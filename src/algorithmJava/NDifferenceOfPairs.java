package algorithmJava;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class NDifferenceOfPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []iArray = {133,4,555,1,1,2,3,4,3,5,6,4,7,4,8,9,0,0,12};
		
		Integer []tempArray = removeDuplicate(iArray);
		System.out.println("Array");
		System.out.println(Arrays.toString(tempArray));
		
		System.out.println("And number of NDifferenceOfPairs are:");
		System.out.println(findNDifferenceOfPairs(tempArray,3));
		

	}

	public static Integer[] removeDuplicate (int []_iArray) {
		Set <Integer> _mySet = new TreeSet<Integer>();
		for(int iVal:_iArray) {
			_mySet.add(iVal);
		}			
			
		return _mySet.toArray(new Integer[0]);
	}

	public static int findNDifferenceOfPairs (Integer []_iArray,int _nDiff) {
		int count = 0;
		int iLastVal = 0;
		int iFirst = 0;
		for(int iVal:_iArray) {
			
			if(((iVal - iLastVal) ==  _nDiff)&& (iFirst != 0)) {
				count++;
			}
			
			if(iFirst == 0) {
				iFirst = 1;
			}
			iLastVal = iVal;
		}			
			
		return count;
	}

}
