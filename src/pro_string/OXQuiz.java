package pro_string;

public class OXQuiz {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int j = 0; j < quiz.length; j++) {
            String[] split = quiz[j].split(" ");

            boolean isMinus = false;
            int expect = Integer.parseInt(split[split.length - 1]);
            int result = 0;
            for (int i = 0; i < 3; i++) {
                if (split[i].equals("-")) {
                    isMinus = true;
                    continue;
                }

                if (split[i].equals("+")) {
                    isMinus = false;
                    continue;
                }

                if (isMinus) {
                    result += -1 * Integer.parseInt(split[i]);
                } else {
                    result += Integer.parseInt(split[i]);
                }
            }

            if (result == expect) {
                answer[j] = "O";
            } else {
                answer[j] = "X";
            }
        }

        return answer;
    }
}
