package algorithmJava;

import java.util.HashSet;
import java.util.Set;

public class GetFirstRepeatedWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "This First A a first function is going to find the very first repeated word if the words is duplicate in the string ";
		System.out.println(firstRepeatedWord (str));
	}
	
	public static String firstRepeatedWord (String _str) {
		Set <String> tempSet = new HashSet <String>();
		
		String [] strArray = _str.split(" ");
	
		for (String strVal: strArray) {
			if(tempSet.contains(strVal)) {
				return strVal;
			}
			tempSet.add(strVal);
		}
		
		return null;
	}
}
