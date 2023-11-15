package pro_realization;

public class ContinuousNumber {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int extra = 0;
        for (int i =0; i < num; i++) {
            extra += i;
        }

        int startNumber = (total - extra) / num;

        for (int i = 0; i < answer.length; i++) {
            answer[i] = startNumber;
            startNumber++;
        }

        return answer;
    }
}
