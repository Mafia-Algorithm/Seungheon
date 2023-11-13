package pro_string;

public class NumberOfDigitPlus {
    public int solution(int n) {
        int answer = 0;
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            answer += Integer.parseInt(Character.toString(number.charAt(i)));
        }

        return answer;
    }
}
