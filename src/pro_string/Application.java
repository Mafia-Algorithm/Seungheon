package pro_string;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        OXQuiz oxQuiz = new OXQuiz();
        System.out.println(Arrays.toString(oxQuiz.solution(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"})));
    }
}
