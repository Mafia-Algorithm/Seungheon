package pro_string;

public class Babbling2 {

    static String[] can = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;

        for (String announce : babbling) {
            for (int i = 0; i < can.length; i++) {
                announce = announce.replace(can[i], Integer.toString(i));
            }

            boolean isPossible = true;
            for (int i = 0; i < announce.length(); i++) {
                if (!Character.isDigit(announce.charAt(i))) {
                    isPossible = false;
                    continue;
                }

                if (i == announce.length() -1) {
                    continue;
                }

                if (announce.charAt(i) == announce.charAt(i + 1)) {
                    isPossible = false;
                }
            }

            if (isPossible) {
                answer++;
            }
        }

        return answer;
    }
}
