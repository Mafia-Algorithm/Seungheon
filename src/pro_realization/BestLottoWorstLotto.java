package pro_realization;

public class BestLottoWorstLotto {
    static int checkRank(int number) {
        switch (number){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int correctCount = 0;
        int zeroCount = 0;

        for (int lotto: lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            for (int win_num: win_nums) {
                if (win_num == lotto) {
                    correctCount++;
                }
            }
        }

        int max = correctCount + zeroCount;
        int min = correctCount;

        max = checkRank(max);
        min = checkRank(min);

        return new int[]{max, min};
    }
}
