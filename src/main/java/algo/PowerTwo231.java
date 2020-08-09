package algo;

public class PowerTwo231 {

    public static void main(String[] args) {
        PowerTwo231 powerTwo231 = new PowerTwo231();
        boolean r = powerTwo231.isPowerOfTwo(256);
        System.out.println(r);
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        int cur = n;
        while (cur != 0) {
            if (cur == 2) {
                return true;
            }
            if (cur % 2 == 1) {
                return false;
            }
            cur = cur / 2;
        }
        return true;
    }

}
