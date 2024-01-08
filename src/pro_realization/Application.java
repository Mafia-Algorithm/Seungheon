package pro_realization;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        RoughPrint roughPrint = new RoughPrint();
        System.out.println(Arrays.toString(roughPrint.solution(
                new String[]{"AGZ", "BSSS"},
                new String[]{"ASA","BGZ"}
        )));
    }
}
