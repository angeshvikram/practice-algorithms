package algorithmJava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findNumberOfPalindromeInString {
	
	
	// ----------------Solution 1--------
	
	// To check  if it is palindrome or Not;
	public static boolean isPalindrome(String _str) {
		if(_str.length() < 2) {
			return  true;
		}
		// Check from Both ends
		for(int i = 0, j = _str.length()-1;i  < _str.length()/2;i++,j--) {
			if(_str.charAt(i) != _str.charAt(j)) {
				return  false;
			}
		}
		return true;
	}
	
	// to get all subString
	public static int getAllSubstringsSolution1(String _str) {
		// Using Set for unique result
		Set <String> strSet = new HashSet<>();
		
		for (int i = 0; i < _str.length(); i++) {
			   for (int j = i+1; j <= _str.length(); j++) {
				   String tempStr = _str.substring(i,j);
				   if(isPalindrome(tempStr)) {
					   strSet.add(_str.substring(i,j));
				   }
			   }
		}
		System.out.println(strSet);
        return strSet.size();
    }
	
	
	// ----------------Solution 2--------
	
	private static void helper(String _str,String _currentString, int _charNumber, Set<String> _strSet) {
		// TODO Auto-generated method stub
		if(_charNumber < _str.length()) {
			String s = String.valueOf(_str);
			
			if(!_str.contains(_currentString)){
				return;
			}
			if((_currentString  != "") && (isPalindrome(_currentString))) {
					_strSet.add(_currentString);
			}
			
			helper(_str,_currentString,_charNumber+1,_strSet);
			String tempString = _currentString + _str.charAt(_charNumber);
			helper(_str,tempString,_charNumber+1,_strSet);
		}
		else {
			if(isPalindrome(_str)) {
				if(_str  != "") {
					_strSet.add(_str);
				}
			}
		}
		
	}
	
	// to get all subString
	public static int getAllSubstringsSolution2(String _str) {
		// Using Set for unique result
		Set <String> strSet = new HashSet<>();
		
		helper(_str,"",0,strSet);
		System.out.println(strSet);
        return strSet.size();
    }

	// ----------------Solution 3--------
	
    private static int allPalindromes(int left, int right, char[] arr, Set<String> _palindromeSet){
        if (left < 0 || right >= arr.length){
            return 0;
        }
        if(arr[left] == arr[right]){
        	
        	_palindromeSet.add(String.valueOf(Arrays.copyOfRange(arr, left, right + 1)));
            return 1 + allPalindromes(left-1, right+1, arr,_palindromeSet);
        }
        return 0;
    }	

	public static int getAllSubstringsSolution3(String s) {
        int result = 0;
        Set<String> palindromeSet = new HashSet<>();
        result = s.length() + result;
        char[] arr = s.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {

        	palindromeSet.add(String.valueOf(arr[i]));
            result += allPalindromes(i, i+1, arr,palindromeSet) + allPalindromes(i, i+2, arr,palindromeSet);
        }
        
        System.out.println(palindromeSet.toString());

        return palindromeSet.size();
    }


	// Main Block
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test Case I
		System.out.println("**************************************************************************************");
		System.out.println("Test Case I \"\"");
		String testCaseI  = "";
		
		System.out.println("----------------Solution 1--------");
		System.out.println(getAllSubstringsSolution1(testCaseI));
		System.out.println("----------------Solution 2--------");
		System.out.println(getAllSubstringsSolution2(testCaseI));
		System.out.println("----------------Solution 3--------");
		System.out.println(getAllSubstringsSolution3(testCaseI));

		System.out.println("**************************************************************************************");
		//Test Case II
		System.out.println("Test Case II \"a\"");
		String testCaseII  = "a";
		
		System.out.println("----------------Solution 1--------");
		System.out.println(getAllSubstringsSolution1(testCaseII));
		System.out.println("----------------Solution 2--------");
		System.out.println(getAllSubstringsSolution2(testCaseII));
		System.out.println("----------------Solution 3--------");
		System.out.println(getAllSubstringsSolution3(testCaseII));

		System.out.println("**************************************************************************************");
		//Test Case III
		System.out.println("Test Case III \"aabaa\"");
		String testCaseIII  = "aabaa";
		
		System.out.println("----------------Solution 1--------");
		System.out.println(getAllSubstringsSolution1(testCaseIII));
		System.out.println("----------------Solution 2--------");
		System.out.println(getAllSubstringsSolution2(testCaseIII));
		System.out.println("----------------Solution 3--------");
		System.out.println(getAllSubstringsSolution3(testCaseIII));

		System.out.println("**************************************************************************************");
		//Test Case IV
		System.out.println("Test Case IV \"aabaaabbaab\"");
		String testCaseIV  = "aabaaabbaab";
		
		System.out.println("----------------Solution 1--------");
		System.out.println(getAllSubstringsSolution1(testCaseIV));
		System.out.println("----------------Solution 2--------");
		System.out.println(getAllSubstringsSolution2(testCaseIV));
		System.out.println("----------------Solution 3--------");
		System.out.println(getAllSubstringsSolution3(testCaseIV));
		System.out.println("**************************************************************************************");
	}
}
