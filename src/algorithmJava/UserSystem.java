package algorithmJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;


public class UserSystem {

	/*
     * Complete the 'usernamesSystem' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY u as parameter.
     */

	
	
	
	public static boolean checkConstraints (List<String> u) {
		
		if(u.size() > 104) {
			return false;
		}
		
		for (String str:u) {
			if(str.length() > 20) {
				return false;
			}
		}
		
		return true;
	}
	
	public static String isNameExist (List<String> u,String _name, int _number) {
		
		String name = _name;
		if(_number>0) {
			name = name + _number;
		}
		
		if(u.contains(name)) {
			_number++;
			return isNameExist (u,_name,_number);
		}
		
		return name;
	}
	
    public static List<String> usernamesSystem(List<String> u) {
        // Write your code here
    	    	
    	if(!checkConstraints(u)) {
    		return null;
    	}
    	
    	List<String> userList = new ArrayList<String>();
    	
    	for (String str:u) {
    		userList.add(isNameExist(userList,str,0));
    	}
    	
        return userList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int uCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> u = IntStream.range(0, uCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = usernamesSystem(u);
        
        System.out.println(result.toString());

    }
    
    /*

    Create the username portion of a registration system that requires all usernames are unique.  
    If a new user requests a name that is already used, an integer should be added to the end of the username to make it unique.  
    The numbering begins with 1 and is incremented by 1 for each new instance per username.



    As an example, if username requests were for [bob, alice, bob, alice, bob, alice], 
    the system should assign usernames [bob, alice, bob1, alice1, bob2, alice2].



    Given a list of username requests in the order given, process all requests and return an array of the usernames as assigned by the function.



    Function Description

    Complete the function usernamesSystem in the editor below. 
    The function must return an array of usernames in the order assigned.



    usernamesSystem has the following parameter(s):

        u[u[0],...u[n-1]]:  an array of username strings in the order requested



    Constraints

    1 ≤ n ≤ 104
    1 ≤ |u[i]| ≤ 20
    u[i] contains only lowercase English letters in the range ascii[a-z].
    Input Format for Custom Testing
    Input from stdin will be processed as follows and passed to the function.



    The first line contains n, the number of strings in array u.

    The next n lines each contain a string u[i] representing a username request in the order received.

    Sample Case 0
    Sample Input

    4
    alex
    xylos
    alex
    alan


    Sample Output 0

    alex
    xylos
    alex1
    alan


    Explanation 0

    There are 4 usernames requested.  Each username is unique with the exception of "alex":  u[2] = "alex" must be modified.  Since this is the first duplicate request for the username "alex", the function should insert "alex1" to that position in u.

    Sample Case 1
    Sample Input

    2
    bob
    alice


    Sample Output 1

    bob
    alice


    Explanation 1

    Each of the users has a different username so no modifications are needed.

    Sample Case 2
    Sample Input

    4
    john
    john
    tom
    john


    Sample Output 2

    john
    john1
    tom
    john2
    Explanation 2

    Three instances of "john" require that usernames "john", "john1" and "john2" be inserted into the array at the appropriate positions.

     */

}
