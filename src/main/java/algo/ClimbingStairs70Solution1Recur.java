package algo;

public class ClimbingStairs70Solution1Recur {

    public static void main(String[] args) {
        ClimbingStairs70Solution1Recur obj=new ClimbingStairs70Solution1Recur();
        int r=obj.climbStairs(45);
        System.out.println(r);
    }

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        return dg(n);
    }

    private int dg(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return dg(n - 1) + dg(n - 2);
    }

}
