package pro_string;

public class HideNumber {
    public long solution(String my_string) {
        long answer = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isDigit(my_string.charAt(i))) {
                sb.append(my_string.charAt(i));
                if (i == my_string.length() - 1) {
                    answer += Long.parseLong(sb.toString());
                }
            } else {
                if (sb.toString().isEmpty()) {
                    continue;
                }
                answer += Long.parseLong(sb.toString());
                sb = new StringBuilder();
            }
        }

        return answer;
    }
}
