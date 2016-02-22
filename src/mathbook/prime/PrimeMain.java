package mathbook.prime;

/**
 * Created by red on 2016. 2. 19..
 */
public class PrimeMain {
  public static int prime1(){
    int numPrime = 0;
    for(int i = 1; i < 10000; i++){
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
  public static int prime2(){
    int numPrime = 0;
    for(int i = 1; i < 10000; i++){
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

  public static void main(String[] args){
    long t1 = System.currentTimeMillis();
    System.out.println(prime1());
    System.out.println(System.currentTimeMillis() - t1);
    System.out.println();
    long t2 = System.currentTimeMillis();
    System.out.println(prime2());
    System.out.println(System.currentTimeMillis() - t2);

  }
}
