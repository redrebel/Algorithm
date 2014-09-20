package p140920;

/**
 * Hanoi 
 * @author cjred77@gmail.com
 *
 */
public class Hanoi {

	static int i=0;
	public static void hanoi(int n, char x, char y, char z){
		if(n ==0){
			return;
		}else{
			hanoi(n-1, x, z, y);
			System.out.println((++i)+":"+x+"->"+y);
			hanoi(n-1, z,y,x);
		}
		
	}
	public static void main(String[] args) {
		hanoi(16,'A','B','C');
		
		System.out.println((int)Math.pow(2, 16) - 1);
		
	}

}
