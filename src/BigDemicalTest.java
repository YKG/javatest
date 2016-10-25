import java.math.BigDecimal;

public class BigDemicalTest {
    public static void main(String[] args) {
        a3();
    }
    public static void main0(String[] args) {
        BigDecimal b0 = BigDecimal.ZERO;
        BigDecimal b1 = BigDecimal.ONE;
        BigDecimal b3 = BigDecimal.valueOf(3);
        BigDecimal b10 = BigDecimal.TEN;

        BigDecimal scaleTest = BigDecimal.valueOf(1234567000010L, 3);
        System.out.println(scaleTest.toString());

        try {
            BigDecimal c = b1.divide(b3);
        } catch (ArithmeticException e){
//            e.printStackTrace();
        }

        BigDecimal a, b, c, d;

        a = BigDecimal.valueOf(5, 3);
        System.out.println(a); // 0.005
        System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN)); // 0.00
        System.out.println(a.setScale(1, BigDecimal.ROUND_HALF_EVEN)); // 0.0

        a = BigDecimal.valueOf(15, 3);
        System.out.println(a); // 0.005
        System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN)); // 0.02
        System.out.println(a.setScale(1, BigDecimal.ROUND_HALF_EVEN)); // 0.0

        a = BigDecimal.valueOf(32);
        System.out.println(b1.divide(a)); // 0.03125
        System.out.println(b1.divide(a, 4, BigDecimal.ROUND_HALF_EVEN)); // 0.0312
    }

    public static void a1() {
        BigDecimal b1 = BigDecimal.ONE;
        BigDecimal b3 = new BigDecimal("99.9999999999999");
        BigDecimal result;

        result = b1.divide(b3, 100000, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(result);
    }

    public static void a0() {
        BigDecimal x = BigDecimal.valueOf(501, 4);
        System.out.println(x + " --> " + x.setScale(2, BigDecimal.ROUND_HALF_EVEN));

        BigDecimal bi, bj, bsum, bsum2, bi2, bj2, bsum_S, bsum2_S;
        int max = 100000;
        int scale1 = 10;
        int scale2 = 8;
        int scale = 2;
        boolean stop = false;
        for (int i = 1000; !stop && i < max; i++){
            bi = BigDecimal.valueOf(i, scale1);
            bi2 = bi.setScale(scale2, BigDecimal.ROUND_HALF_EVEN);

            for (int j = 0; !stop && j < max; j++){
                bj = BigDecimal.valueOf(j, scale1);
                bj2 = bj.setScale(scale2, BigDecimal.ROUND_HALF_EVEN);

                bsum = bi.add(bj);
                bsum2 = bi2.add(bj2);

                bsum_S = bsum.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
                bsum2_S = bsum2.setScale(scale, BigDecimal.ROUND_HALF_EVEN);

                if (!bsum_S.equals(bsum2_S)) {
                    System.out.print(bi + " + " + bj + " = " + bsum + " [" + bsum_S + ", 2]  ");
                    System.out.println(bi2 + " + " + bj2 + " = " + bsum2 + " [" + bsum2_S + ", 2]");
//                    stop = true;
                }
//                if (bi.add(bj).compareTo(BigDecimal.valueOf(1, 1)) >= 0){
//                    System.out.println(bi + " + " + bj + " = " + bi.add(bj));
//                    stop = true;
//                }
            }
        }
    }

    public static void a3() {
        System.out.println(BigDecimal.ONE.divide(new BigDecimal(9999.99999), 5, BigDecimal.ROUND_HALF_EVEN));
//        BigDecimal x = BigDecimal.valueOf(1000000000000L);
//        BigDecimal y = BigDecimal.ONE.divide(x, 11, BigDecimal.ROUND_HALF_EVEN);
//        System.out.println(x + " --> " + y);
    }
}
