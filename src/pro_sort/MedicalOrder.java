package pro_sort;

public class MedicalOrder {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for(int i = 0; i < emergency.length; i ++) {
            for (int k : emergency) {
                if (emergency[i] < k) {
                    answer[i]++;
                }
            }

            answer[i]++;
        }
        return answer;
    }
}
