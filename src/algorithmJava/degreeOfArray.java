package algorithmJava;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class degreeOfArray {

	public static class node{
		int _count;
		int _lPos;
		int _rPos;
	}
	
	public static int []  smallestSubsegment(int _arr[]) {
		int subArrayNumber = 0;
		int MaxCount = 0;
		Map <Integer,node> map = new HashMap<>();
		
		for(int i=0;i<_arr.length;i++) {
			if(map.containsKey(_arr[i])) {
				node temp_obj = map.get(_arr[i]);
				temp_obj._count = temp_obj._count+1;
				temp_obj._rPos = i;
				
				map.put(_arr[i], temp_obj);
				
				if(temp_obj._count > MaxCount) {
					MaxCount =  temp_obj._count;
					subArrayNumber = _arr[i];
				}
			}
			else {
				node temp_obj = new node();
				temp_obj._count = 1;
				temp_obj._rPos = i;
				temp_obj._lPos = i;
				
				map.put(_arr[i], temp_obj);
			}
		}
		int subArray[] = new int[map.get(subArrayNumber)._rPos - map.get(subArrayNumber)._lPos +1];
		
		for(int j=0,i = map.get(subArrayNumber)._lPos;i<=map.get(subArrayNumber)._rPos;i++,j++) {
			subArray[j]  = _arr[i];
		}
		
		return subArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {4, 1, 1, 2, 2, 1, 3, 2,2} ;
		int result [] =  smallestSubsegment(arr);
		
		System.out.println(Arrays.toString(result));
	}

}
