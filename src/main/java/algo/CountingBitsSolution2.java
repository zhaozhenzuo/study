package algo;

public class CountingBitsSolution2 {

    public static void main(String[] args) {
        CountingBitsSolution2 countingBits = new CountingBitsSolution2();
        int[] r = countingBits.countBits(3);
        for (int i : r) {
            System.out.println(i);
        }
    }

    public int[] countBits(int num) {
        if (num <= 0) {
            int[] r = {0};
            return r;
        }

        int[] rArr = new int[num + 1];
        int[] cacheArr = new int[num + 1];
        rArr[0]=0;
        for (int i = 1; i <= num; i++) {
            int v = cacheArr[i & (i - 1)] + 1;
            cacheArr[i] = v;
            rArr[i] = v;
        }
        return rArr;
    }

}
