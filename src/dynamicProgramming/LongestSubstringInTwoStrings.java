package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringInTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1="CLCL";
		String str2="LCLC";
		
		System.out.println(longestSubstring(str1,str2).toString());
	}

	private static List<String> longestSubstring(String _str1, String _str2) {
		// TODO Auto-generated method stub
		
		List<String>  result  = new ArrayList<>();
				
		Integer matrix[][] = new Integer[_str1.length()][_str2.length()]; 
		int max = Integer.MIN_VALUE;
		
		
		for (int  i=0;i<_str1.length();i++) {
			for(int  j=0;j<_str2.length();j++) {
				if(_str1.charAt(i) == _str2.charAt(j)) {
					if((i==0)||(j==0)) matrix[i][j] = 1;
					else matrix[i][j] = matrix[i-1][j-1] + 1;
					
					if(matrix[i][j] > max) {
						max = matrix[i][j];
						result  = new ArrayList<>();
						
						result.add(_str1.substring(i-max+1,i+1));
					}
					else if(matrix[i][j] == max){
						result.add(_str1.substring(i-max+1,i+1));
					}
				}
				else {
					matrix[i][j] = 0;
				}
				
			}
		}
		
		return result;
	}

}
