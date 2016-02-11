package mathbook.p140913;

/**
 * Combination
 * @author cjred77@gmail.com
 *
 */
public class Combination {

	/**
	 * Calculate Combination
	 * @param n
	 * @param k
	 * @return
	 */
	public static int comb(int n, int k){
		// n장에서 k장을 선택하는 모든 순열의 수 / k장을 치환하는 모든 가지의 수.
		int c = Permutation.perm(n, k) / Permutation.perm(k, k);
		return c;
	}
	public static void main(String[] args) {
		// what is 5C3
		// 3개의 카드중에 2개를 선택할 경우의 갯수는? (순서 구별안. {A,B,C} = {C,B,A})
		int c = comb(5,3);
		System.out.println(c);
	}

}
