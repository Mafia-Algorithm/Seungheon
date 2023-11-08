package pro_string;

public class Babbling1 {

    static String[] possible = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;

        for (String word : babbling) {
            boolean isPossible = true;
            for (String announce : possible) {
                word = word.replace(announce, " ");
            }

            for (int i = 0; i < word.length(); i++) {
                if (!Character.toString(word.charAt(i)).equals(" ")) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                answer++;
            }
        }

        return answer;
    }
}
