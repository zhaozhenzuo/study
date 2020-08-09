package algo;

public class NumberBit191 {

    public static void main(String[] args) {
        NumberBit191 numberBit191=new NumberBit191();
        int r=numberBit191.hammingWeight(7);
        System.out.println(r);
    }

    public int hammingWeight(int n) {
        if(n == 0){
            return 0;
        }
        int count=0;
        int cur=n;
        while(cur!=0){
            count++;
            cur=cur&(cur-1);
        }
        return count;
    }

}
