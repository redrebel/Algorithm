package p140913;

public class Permutation {
	/**
	 * Calculate Permutation
	 * @param n
	 * @param k
	 * @return
	 */
	public static int perm(int n, int k){
		
		int p = Factorial.facto(n) / Factorial.facto(n - k);
		return p;
	}
	public static void main(String args[]){
		// what is 3P2
		// 3���� ī���߿� 2���� ������ ����� ������? (������ ������. {A,B,C} != {C,B,A})
		int p = perm(3,2);
		System.out.println(p);
	}
}
