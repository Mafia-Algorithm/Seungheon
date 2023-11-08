package pro_string;

public class StringCalculation {

    public int solution(String myString) {
        int answer = 0;

        boolean isMinus = false;
        String[] sentence = myString.split(" ");
        for (String s : sentence) {
            if (s.equals("-")) {
                isMinus = true;
                continue;
            }

            if (s.equals("+")) {
                isMinus = false;
                continue;
            }

            int number = Integer.parseInt(s);
            if (isMinus) {
                number *= -1;
            }

            answer += number;
        }

        return answer;
    }
}
