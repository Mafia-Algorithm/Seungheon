package pro_realization;

public class Kcount {
    public int solution(int i, int j, int k) {
        int answer = 0;

        for (int start = i; start <= j; start++) {
            String startToString = Integer.toString(start);
            for (int l = 0; l < startToString.length(); l++) {
                if (Character.getNumericValue(startToString.charAt(l)) == k) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
