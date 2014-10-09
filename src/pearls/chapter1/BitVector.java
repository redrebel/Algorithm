package pearls.chapter1;

/**
 * Created by cjred77@gmail.com on 2014-10-08.
 * transfer int to BitVector for java
 */
public class BitVector {
    private final int SHIFT = 3;
    private final byte MASK = 0x07;
    private int size;
    private byte[] bits;

    /**
     * initialize
     * @param size : Bit Size
     * @throws Exception
     */
    public BitVector(int size) throws Exception {
        if(size < 0){
            throw new Exception("too small size");
        }
        bits = new byte[(size>>SHIFT)+1];
        this.size = bits.length * 8;//size;
        System.out.println("Maximum BitVector size : "+this.size);

    }

    /**
     * clearBit
     * @param n
     */
    public void clearBit(int n){
        int offset = n>>SHIFT;
        byte procMask = (byte)(1<<(n&MASK));

        bits[offset] &= ~procMask;
    }

    /**
     * setBit
     * @param n
     * @return
     */
    public boolean setBit(int n){
        int offset = n>>SHIFT;
        byte procMask = (byte)(1<<(n&MASK));

        bits[offset] |= procMask;
        return true;
    }

    /**
     * getBit
     * @param n
     * @return
     */
    public boolean getBit(int n){
        int offset = n>>SHIFT;
        byte procMask = (byte)(1<<(n&MASK));

        return (bits[offset] & (procMask)) != 0;
    }

    /**
     * toString
     * @return
     */
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

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int size = 870 * 1000000;
        int n = 300 * 1000000;
        BitVector bv = new BitVector(size);

        bv.setBit(n);
        //System.out.println("BitVector setting (" + n + ") : " + bv.toString());
        System.out.println("BitVector (" + n + ") is set ? :" + bv.getBit(n));

        bv.setBit(5);
        //System.out.println("BitVector setting (" + 5 + ") : " + bv.toString());
        System.out.println("BitVector (" + 5 + ") is set ? :" + bv.getBit(5));

        System.out.println("BitVector (" + 2 + ") is set ? :" + bv.getBit(2));

        bv.clearBit(n);
        System.out.println("BitVector clear (" + n + ") : "); // + bv.toString());
        System.out.println("BitVector (" + n + ") is set ? :" + bv.getBit(n));

        //System.out.println(n);
        //System.out.println((n>>3)+1);
        return;
    }
}
