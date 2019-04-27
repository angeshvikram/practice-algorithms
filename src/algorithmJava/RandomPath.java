package algorithmJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPath {

	
	public static void getNextVal(int i, int j){
		
	}
	
	public static List<List<Integer>> findRandomPath(int _n){
		List<List<Integer>> _path = new ArrayList<>();
		Random rand = new Random();
		
		int [][] _matrix = new int [_n][_n];
		int i  =  0;
		int j = 0;
		
		while(true) {
			if((_n-1 == i) && (_n-1 == j)) {
				break;
			}
			
			int  _nextVal = rand.nextInt(4);
			
	
		
		}
		
		return _path;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		
		System.out.println(" Random"+rand.nextInt(4));
		
		findRandomPath(4);
	}

}
