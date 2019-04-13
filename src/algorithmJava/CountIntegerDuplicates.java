package algorithmJava;

import java.util.HashSet;
import java.util.Set;

public class CountIntegerDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []iArray = {1,1,2,3,4,3,5,6,4,7,4,8,9,0,0};
		System.out.println("numberOfduplicate");
		System.out.println(numberOfduplicate(iArray));

	}
	
	public static int numberOfduplicate (int []_iArray) {
		int duplicateCount = 0;
		Set <Integer> _mySet = new HashSet<Integer>();
		for(int iVal:_iArray) {
			if(_mySet.contains(iVal)) {
				duplicateCount++;
			}
			_mySet.add(iVal);
		}			
			
		return duplicateCount;
	}

}
