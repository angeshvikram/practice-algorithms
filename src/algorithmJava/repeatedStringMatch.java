package algorithmJava;

public class repeatedStringMatch {
	
	/*
	 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

	 */

	public static int repeatedStringMatchCount(String A, String B) {
		if(A.length() == B.length())  {
            if (A.contains(B)) return 1;
        }
        
        int counter = 0;
        
        if(B.length()<=A.length()){
            if (A.contains(B)) return 1;
            
            String tempStr = A+A;
            
            if (tempStr.contains(B)) return 2;
            else return -1;
        }
        else{
            String tempStr = "";    
            while(tempStr.length()<B.length()){
                tempStr = tempStr+A;
                counter++;
                if(tempStr.contains(B)) return counter;
            }
            tempStr = tempStr+A;
            counter++;
            if(tempStr.contains(B)) return counter;
            else return -1;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(repeatedStringMatchCount("a","b"));
	}

}
