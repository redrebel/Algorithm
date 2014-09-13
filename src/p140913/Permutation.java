package p140913;

public class Permutation {
	
	public static int perm(int leftNum, int rightNum){
		int p = Factorial.facto(leftNum) / Factorial.facto(leftNum - rightNum);
		return p;
	}
	public static void main(String args[]){
		int p = perm(3,2);
		System.out.println(p);
	}
}
