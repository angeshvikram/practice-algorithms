// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    
    public boolean isInputValid(int [] _A,int elem){
        boolean input = false;
        if(_A.length  < 1) return false;
        if(_A.length > 100000) return false;
        if(elem < -1000000) return false;
        if(elem > 1000000) return false;
        
        return true;
    }
    
    public int solution(int[] A) {
        // write your code in Java SE 8
        
       // if(!isInputValid(A)) return 0;
        //  Using a Tree Set 
        
        Set<Integer> mySet  = new TreeSet<Integer>();
        for (int elem:A){
            if(!isInputValid(A,elem)) return 0;
            mySet.add(elem);
        }
        //starting a Count from  1
        int count = 1;
        for (int elem:mySet){
            if(elem>0){
                if(elem!= count){
                    break;
                }
                count++;
            }
        }
        return count;
    }
}