import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
/*
정수 4를 1, 2, 3의 조합으로 나타내는 방법은 다음과 같이 총 7가지가 있음.
1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 입력으로 주어졌을 때, n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구하시오.
*/

class Ideone
{
	public static int solution(int n){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		if(n == 3){
			return 4;
		}
		return solution(n-1) + solution(n-2) + solution(n-3);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int result = solution(5);
		System.out.println(result);
	}
}