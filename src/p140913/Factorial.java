package p140913;

public class Factorial {

	public static int facto(int n){
		int m = 1;
		for(int i = n; i >= 1 ; i--){
			m = m*i;
		}
		return m;
	}
	public static void main(String[] args) {
		System.out.println(facto(7));
	}

}
