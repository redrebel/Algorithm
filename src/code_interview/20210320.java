/*
1. 정수 n에 대하여
2. n이 홀수면 3 * n + 1 을 하고,
3. n이 짝수이면 n을 2로 나눕니다.
4. 이렇게 계속 진행하여 n 이 결국 1이 될때까지 2와 3 단계를 반복합니다.

예를 들어 n 에 3을 넣으면,
3
10
5
16
8
4
2
1

이 됩니다.

이렇게 정수 n을 입력받아, 위 알고리즘에 의해 1이 되는 과정을 모두 출력하는 함수를 작성하세요.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void solution(int n){
		int mod = n;
		while(mod != 1){
			if(mod % 2 == 1){
				mod = 3 * mod + 1;
			}
			else{
				mod = mod / 2;
			}
			System.out.println(mod);
		}
	}
	public static void solution2(int n){
		System.out.println(n);
		if(n == 1) return;
 
		if(n % 2 == 1){
			solution2(3 * n + 1);
		}
		else{
			solution2(n / 2);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		solution(3);
		solution2(3);
	}
}