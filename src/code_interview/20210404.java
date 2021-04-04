/*
어떠한 중학교의 수학평균점수를 구하려고 한다.
단. 최소점수와 최고점수를 1명씩 뺀 점수들의 평균점수를 구해야한다.
학교에는 1000명 이내의 학생이 있고 수학점수는 0점에서 100점까지이다.
O(N)의 시간복잡도를 가진 함수를 구현하시오.

예 10 60 40 80 90 의 평균은
최소점 10점과 최고점 90점을 제외한 180 / 3 = 60점이다.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int min = score.min();
		int max = score.max();
		
		int result = score.sum() / (score.length - 2) - (min + max); 
	}
}