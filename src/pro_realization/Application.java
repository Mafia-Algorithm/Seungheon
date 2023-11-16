package pro_realization;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        BestLottoWorstLotto bestLottoWorstLotto = new BestLottoWorstLotto();
        System.out.println(Arrays.toString(bestLottoWorstLotto.solution(
                new int[]{44, 1, 0, 0, 31, 25},
                new int[]{31, 10, 45, 1, 6, 19}
        )));
    }
}
