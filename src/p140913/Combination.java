package p140913;

public class Combination {

	/**
	 * Calculate Combination
	 * @param n
	 * @param k
	 * @return
	 */
	public static int comb(int n, int k){
		// n�忡�� k���� �����ϴ� ��� ������ �� / k���� ġȯ�ϴ� ��� ������ ��.
		int c = Permutation.perm(n, k) / Permutation.perm(k, k);
		return c;
	}
	public static void main(String[] args) {
		// what is 5C3
		// 3���� ī���߿� 2���� ������ ����� ������? (���� ������. {A,B,C} = {C,B,A})
		int c = comb(5,3);
		System.out.println(c);
	}

}
