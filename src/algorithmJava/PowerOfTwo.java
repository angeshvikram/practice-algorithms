package algorithmJava;

public class PowerOfTwo {

	public static boolean isPowerOfTwo(int _num) {
		if(_num == 2) return true;
		if((_num < 2)||(_num == 3) || (_num%2!=0)) return false;
		return isPowerOfTwo(_num/2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPowerOfTwo(64));

	}

}
