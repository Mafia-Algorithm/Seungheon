package pro_array;

public class SplitArray {
    public String[] solution(String my_str, int n) {
        int count = 0;
        if (my_str.length() % n == 0) {
            count = my_str.length() / n;
        } else {
            count = my_str.length() / n + 1;
        }
        String[] answer = new String[count];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_str.length(); i++) {
            sb.append(my_str.charAt(i));
            if (i == my_str.length() - 1) {
                answer[i / n] = sb.toString();
                break;
            }

            if (sb.length() == n) {
                answer[i / n] = sb.toString();
                sb = new StringBuilder();
            }
        }

        return answer;
    }
}
