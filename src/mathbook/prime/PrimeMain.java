package mathbook.prime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by red on 2016. 2. 19..
 */
public class PrimeMain {
  /**
   * 100_000 input
   * 9592,
   * 23989 take ms
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
   * more faster then prime1()
   * @return
   */
  public static int prime2(int num){
    int numPrime = 0;
    for(int i = 2; i <= num; i++){
      int p = 0;
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

  public static int prime3(int num){
    int numPrime = 0;
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<String, String> map = new HashMap <>();

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

  public static void main(String[] args){
    int num = 100_000;
    long start;
//    start = System.currentTimeMillis();
//    System.out.println(prime1(num));
//    System.out.println(System.currentTimeMillis() - start);

    System.out.println();
    start = System.currentTimeMillis();
    System.out.println(prime2(num));
    System.out.println(System.currentTimeMillis() - start);

    System.out.println();
    start = System.currentTimeMillis();
    System.out.println(prime3(num));
    System.out.println(System.currentTimeMillis() - start);
  }
}
