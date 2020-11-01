/*
개구리는 모두 n-1번을 뛸수있습니다.
개구리는 a 만큼 혹은 b만큼 뛸수 있습니다. 
개구리가 갈수있는 거리의 배열을 출력하세요.

예)
input 
3, 1, 2
output
2 3 4 

input 
4, 10, 100
output 
30 120 210 300 
*/
public static int[] stone(int n, int a, int b){
    int[] result = new int[n];
    
    if(a>b){
        int temp=a;
        a=b;
        b=temp;
    }
    else if(a==b){
        result[0] = (n-1)*a;
        return result;
    }
    
    
    for(int i=(n-1); i>=0; i--){
        int j = (n-1)-i;
        result[i] = (a*i) + (b*j);
    }
    return result;
}
