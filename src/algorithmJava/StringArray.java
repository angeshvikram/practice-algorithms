package algorithmJava;

import java.util.ArrayList;

public class StringArray {

	public static String getCompoundString(ArrayList <String> compoundString) {
		String localStr = "";
		for (String s : compoundString)
		{
			localStr += s;
		}
		return localStr;
	}
	
	public static void getSetOfWords(String [] str,String compWord,ArrayList <String> compoundString,int currentWord,ArrayList <String> largestPossibleSet){
		//Base Case to check if we reach end
		if(currentWord== str.length) {
			if(compWord.equals(getCompoundString(compoundString))){
				
				if(compoundString.size() > largestPossibleSet.size()){
					largestPossibleSet.removeAll(largestPossibleSet);
					largestPossibleSet.addAll(compoundString);
				}
				return;
			}
			
		}
		if(currentWord < str.length) {
			// if it is the string than return 
			if(compWord.equals(getCompoundString(compoundString))){
				
					// To save the largest Possible  Set
				if(compoundString.size() > largestPossibleSet.size()){
					largestPossibleSet.removeAll(largestPossibleSet);
					largestPossibleSet.addAll(compoundString);
				}
				return;
				}
				// if it is not the compound word; than run with or with out current String
				ArrayList <String> compoundStringWithoutCurrentString = compoundString;
				getSetOfWords(str,compWord,compoundStringWithoutCurrentString,currentWord+1, largestPossibleSet);
				ArrayList <String> compoundStringWithCurrentStringcompoundString = new ArrayList<>(compoundString);
				compoundStringWithCurrentStringcompoundString.add(str[currentWord]);
				getSetOfWords(str,compWord,compoundStringWithCurrentStringcompoundString,currentWord+1, largestPossibleSet);
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] testCase1  = {"foo","bar"};
		ArrayList <String> largestPossibleSet = new ArrayList <>();
		ArrayList <String> compoundString = new ArrayList <>();
		
		getSetOfWords(testCase1,"foobar",compoundString,0,largestPossibleSet);

		System.out.println("testCase1, [\"foo\",\"bar\"] and \"foobar\" ");
		System.out.println("return set is:  "+largestPossibleSet.toString());
		System.out.println("return set Size is:  "+largestPossibleSet.size());

		
		String [] testCase2  = {"a","ab","bcd","c","d"};
		largestPossibleSet = new ArrayList <>();
		compoundString = new ArrayList <>();
		
		getSetOfWords(testCase2,"abcd",compoundString,0,largestPossibleSet);

		System.out.println("testCase1, [\"a\",\"ab\",\"bcd\",\"c\",\"d\"] and \"abcd\" ");		
		System.out.println("return set is:  "+largestPossibleSet.toString());
		System.out.println("return set Size is:  "+largestPossibleSet.size());
		
	}

}
