package algo;

public class PowerTwo231SendSolution {

    public static void main(String[] args) {
        PowerTwo231SendSolution powerTwo231 = new PowerTwo231SendSolution();
        boolean r = powerTwo231.isPowerOfTwo(7);
        System.out.println(r);
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        int r = n & (n - 1);
        return r == 0;
    }

}
