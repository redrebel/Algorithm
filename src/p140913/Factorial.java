package p140913;

public class Factorial {
	/**
	 * Calculate Factorial
	 * @param n
	 * @return
	 */
	public static int facto(int n){
		int m = 1;
		for(int i = n; i >= 1 ; i--){
			m = m*i;
		}
		return m;
	}
	public static void main(String[] args) {
		// what is 7! (7*6*5*4*3*2*1)
		System.out.println(facto(7));
	}

}
