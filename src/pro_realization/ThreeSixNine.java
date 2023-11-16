package pro_realization;

public class ThreeSixNine {
    public int solution(int order) {
        int answer = 0;

        String numbers = Integer.toString(order);
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '3' || numbers.charAt(i) == '6' || numbers.charAt(i) == '9') {
                answer++;
            }
        }

        return answer;
    }
}
