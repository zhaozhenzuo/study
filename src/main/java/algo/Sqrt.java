package algo;

public class Sqrt {

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(5));
    }

//    public int mySqrt(int x) {
//        int left = 1, right = x;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (mid == x / mid) {
//                return mid;
//            } else if (mid < x / mid) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return right;
//    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) {
                //结果
                return (int) mid;
            } else if (mid > x / mid) {
                //值太大，r设置为mid
                r = mid - 1;
            } else {
                //值太小，l设置为mid
                l = mid + 1;
            }
        }
        return r;
    }

}
