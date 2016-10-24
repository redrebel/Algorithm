package mathbook.prime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;
/**
 * Created by red on 2016. 2. 19..
 */
public class PrimeMain {
  /**
   * divide all value. too bad, Don't Use
   * 100_000 input
   * 9592,
   * take 24.0 s
   * @param num
   * @return
   */
  public static int prime1(int num){
    int numPrime = 0;
    for(int i = 2; i <= num; i++){
      int p = 0;
      for(int j=2; j<i; j++){
        int a = i % j;
        if( a == 0){
          p++;
        }
      }

      if(p < 1){
        numPrime++;
        //System.out.println(i);
      }
    }
    return numPrime;
  }

  /**
   * 100_000 input
   * 9592,
   * takes 2.75 s
   * faster then prime1()
   * @return
   */
  public static int prime2(int num){
    int numPrime = 0;
    for(int i = 2; i <= num; i++){
      boolean isPrime = true;
      for(int j=2; j<i; j++){
        if((i % j) == 0) {
          isPrime = false;
          break;
        };
      }

      if(isPrime){
        numPrime++;
        //System.out.println(i);
      }
    }
    return numPrime;
  }

  /**
   * use List
   * 100_000 input
   * 9592, takes 0.25 s
   * faster then prime2()
   * @return
   */
  public static int prime3(int num){
    ArrayList<Integer> list = new ArrayList<>();

    for(int i = 2; i<=num; i++){
      boolean isPrime = true;
      for(int j=0; j<list.size(); j++){
        if(i%list.get(j)==0){
          isPrime = false;
          break;
        }
      }

      if(isPrime){
        list.add(i);
      }
    }

    return list.size();
  }

  /**
   * use Sqrt
   * @param num
   * @return
   */
  public static int primeSqrt(int num){
    int numPrime=0;

    for(int i=2; i<=num; i++){
      boolean isPrime = true;
      for(int j=2;j<=Math.sqrt(i);j++){
        if(i%j == 0){
          isPrime = false;
          break;
        }
      }
      if(isPrime){
        numPrime++;
      }
    }
    return numPrime;
  }

  /**
   * use Sqrt & List
   * @param num
   * @return
   */
  public static int prime4(int num){
    int numPrime=0;
    int arr[] = new int[num+1];

    for(int i=2;i<=num;i++){
      arr[i]=i;
    }

    for(int i=2;i<=Math.sqrt(num);i++){
      if(arr[i]==0){
        continue;
      }

      for(int j=i+i; j<=num;j+=i){
        arr[j]=0;
      }
    }

    for(int i=2;i<num;i++){
      if(arr[i]!=0){
        numPrime++;
      }
    }
    return numPrime;
  }

  /**
   * use Sqrt & List
   * @param num
   * @return
   */
  public static int prime5(int num){
    int numPrime=0;
    int arr[] = new int[num+1];

    for(int i=2;i<=num;i++){
      arr[i]=i;
    }

    for(int i=2;i<=Math.sqrt(num);i++){
      if(arr[i]==0){
        continue;
      }

      for(int j=i*i; j<=num;j+=i){
        arr[j]=0;
      }
    }

    for(int i=2;i<num;i++){
      if(arr[i]!=0){
        numPrime++;
      }
    }
    return numPrime;
  }

  public static boolean isPrime(int candidate){
    int candidateRoot = (int) Math.sqrt((double) candidate);
    return IntStream.rangeClosed(2, candidateRoot)
            .noneMatch(i -> candidate % i == 0);
  }

  /**
   * 100_000 input
   * 9592,
   * takes 0.18 s
   * slower then primeSqrt()
   * @return
   */
  public static int primeStream(int n){
    /*return IntStream.rangeClosed(2,n).boxed()
            .collect(partitioningBy(candidate -> isPrime(candidate)));*/
    return (int)IntStream.rangeClosed(2,n).boxed()
            .filter(candidate -> isPrime(candidate)).count();
  }

  public static void main(String[] args){
    int num = 1_000_000;

    long start;
//    start = System.currentTimeMillis();
//    System.out.println(prime1(num));
//    System.out.println(System.currentTimeMillis() - start);

//    System.out.println();
//    start = System.currentTimeMillis();
//    System.out.println(prime2(num));
//    System.out.println("prime2() : " + (float)(System.currentTimeMillis() - start)/1000);

    System.out.println();
    start = System.currentTimeMillis();
    System.out.println(prime3(num));
    System.out.println("prime3() : " + (float)(System.currentTimeMillis() - start)/1000);

    System.out.println();
    start = System.currentTimeMillis();
    System.out.println(prime4(num));
    System.out.println("prime4() : " + (float)(System.currentTimeMillis() - start)/1000);

    System.out.println();
    start = System.currentTimeMillis();
    System.out.println(prime5(num));
    System.out.println("prime5() : " + (float)(System.currentTimeMillis() - start)/1000);

    System.out.println();
    start = System.currentTimeMillis();
    System.out.println(primeSqrt(num));
    System.out.println("primeSqrt() : " + (float)(System.currentTimeMillis() - start)/1000);

    System.out.println();
    start = System.currentTimeMillis();
    System.out.println(primeStream(num));
    System.out.println("primeStream() : " + (float)(System.currentTimeMillis() - start)/1000);

  }
}
