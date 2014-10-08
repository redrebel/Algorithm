package pearls.chapter1;

/**
 * Created by cjred77@gmail.com on 2014-10-08.
 * transfer int to BitVector for java
 */
public class BitVector {
    private int size;
    private byte[] bits;

    public BitVector(int size) throws Exception {
        if(size < 8){
            throw new Exception("too small");
        }
        this.size = size;
        bits = new byte[(size>>3)+1];

    }

    public void clearBit(int n){
        bits[n>>3] &= ~(1<<(n&7));
    }
    public boolean setBit(int n){
        bits[n>>3] |= (1<<(n&7));
        return true;
    }
    public boolean getBit(int n){
        return (bits[n>>3] & (1<<(n&7))) != 0;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        byte b = 0x01;
        for(int i=0; i<size;i++){

            if(getBit(i)){
                s.append(1);
            }
            else{
                s.append(0);
            }
            //System.out.println(bits[0>>i]&b);
            /*if((bits[0>>i]&b) == b)
            {
                s.append(1);
            }else
            {
                s.append(0);
            }*/
        }
        return s.reverse().toString();
    }
    public static void main(String[] args) throws Exception {
        int n = 8;
        BitVector bv = new BitVector(n);
        System.out.println(bv.toString());
        bv.setBit(2);
        System.out.println(bv.toString());
        System.out.println(bv.getBit(2));

        bv.clearBit(2);
        System.out.println(bv.toString());

        System.out.println(n);
        System.out.println((n>>3)+1);
        return;
    }
}
