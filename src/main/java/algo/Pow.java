package algo;

import java.util.HashMap;
import java.util.Map;

public class Pow {

    public static void main(String[] args) {
        Pow pow = new Pow();

        System.out.println(Integer.MIN_VALUE);

        double r = pow.myPow(2, -2147483647);
        System.out.println(r);

        System.out.println(Integer.MAX_VALUE);
    }

    private Map<Integer, Double> cache;

    public double myPow(double x, int n) {
        if (x < -100 || x > 100 || n<Integer.MIN_VALUE ||
        n>Integer.MAX_VALUE) {
            //非法
            throw new IllegalArgumentException("值不合法");
        }
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            if (n % 2 == 0 && x == -1) {
                return 1;
            } else if (n % 2 != 0 && x == -1) {
                return -1;
            }
            return 0;
        }
        if (n == Integer.MAX_VALUE) {
            if (n % 2 == 0 && x == -1) {
                return 1;
            } else if (n % 2 != 0 && x == -1) {
                return -1;
            }
            return 0;
        }

        cache = new HashMap<>();
        double r;
        if (n < 0) {
            r = recur(x, -n);
        } else {
            r = recur(x, n);
        }
        if (n < 0) {
            r = 1 / r;
        }
        return r;
    }

    /**
     * 递归计算
     * 2,3
     *
     * @param x
     * @param n
     * @return
     */
    private double recur(double x, int n) {
        if (n == 1) {
            return x;
        }

        //从缓存找
        Double valueFromCache = cache.get(n);
        if (valueFromCache != null) {
            return valueFromCache;
        }

        //计算
        Double value;
        if (n % 2 == 0) {
            //偶数
            value = recur(x, n / 2) * recur(x, n / 2);
        } else {
            //奇数
            int t = (n - 1) / 2;
            value = recur(x, t) * recur(x, t) * x;
        }

        //加入缓存
        cache.put(n, value);
        return value;
    }

}
