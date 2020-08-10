package algo;

public class CountingBits {

    public static void main(String[] args) {
        CountingBits countingBits=new CountingBits();
        int[] r=countingBits.countBits(5);
        for(int i:r){
            System.out.println(i);
        }
    }

    public int[] countBits(int num) {
        if (num <= 0) {
            int[] r = {0};
            return r;
        }

        int[] rArr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int v = getOneBitValueCnt(i);
            rArr[i] = v;
        }
        return rArr;
    }

    private int getOneBitValueCnt(int num) {
        if (num == 0) {
            return 0;
        }
        int cnt = 0;
        int cur = num;
        while (cur != 0) {
            cnt++;
            cur = cur & (cur - 1);
        }
        return cnt;
    }

}
