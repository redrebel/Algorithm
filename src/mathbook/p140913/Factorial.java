package mathbook.p140913;

/**
 * @author cjred77@gmail.com
 *
 */
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

  /**
   * Factorial (way of recursion)
   * @param n
   * @return
   */
	public static int recursion_facto(int n){
		if(n <= 1) return 1;
		else return n*recursion_facto(n-1);

	}
	public static void main(String[] args) {
		// what is 7! (7*6*5*4*3*2*1)
		System.out.println(facto(7));
		System.out.println(recursion_facto(7));
	}

}
