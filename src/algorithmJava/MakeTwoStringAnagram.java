package algorithmJava;

import java.util.Map;
import java.util.TreeMap;

public class MakeTwoStringAnagram {

	private static int countExtraChar(Map<Character, Integer> str1Map, Map<Character, Integer> str2Map) {
		int count = 0;
		int singleCount1 = 0;
		int singleCount2 = 0;
		
		for(Character a:str1Map.keySet()) {
			if(str2Map.containsKey(a)) {
				if(str1Map.get(a) > str2Map.get(a)) {
					count = count+(str1Map.get(a)-str2Map.get(a));
				}else {
					count = count+(str2Map.get(a)-str1Map.get(a));
				}
				str2Map.remove(a);
			}
			else {
				singleCount1 = singleCount1+str1Map.get(a);
			}
		}
		for(Character a:str2Map.keySet()) {
			singleCount2 = singleCount2+str2Map.get(a);
		}
		
		if(singleCount2>singleCount1) {
			count = count + singleCount2;
		}
		else {
			count = count + singleCount1;
		}
		
		return count;
	}
	public static int removeExtraChar(String _str1, String _str2) {
		
		Map <Character,Integer> str1Map = new TreeMap<>(); 
		Map <Character,Integer> str2Map = new TreeMap<>();
		
		for(int i  = 0; i < _str1.length();i++) {
			if(str1Map.containsKey(_str1.charAt(i))){
				str1Map.put(_str1.charAt(i),str1Map.get(_str1.charAt(i))+1);
			}
			else {
				str1Map.put(_str1.charAt(i),1);
			}
		}
		for(int i  = 0; i < _str2.length();i++) {
			if(str2Map.containsKey(_str2.charAt(i))){
				str2Map.put(_str2.charAt(i),str2Map.get(_str2.charAt(i))+1);
			}
			else {
				str2Map.put(_str2.charAt(i),1);
			}
		}
		return countExtraChar(str1Map,str2Map);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(removeExtraChar("abc","Xya"));
		System.out.println(removeExtraChar("zqw","Xyz"));
		System.out.println(removeExtraChar("abc","aabc"));

	}

}
