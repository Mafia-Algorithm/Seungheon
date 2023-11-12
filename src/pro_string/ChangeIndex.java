package pro_string;

public class ChangeIndex {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String first = Character.toString(my_string.charAt(num1));
        String second = Character.toString(my_string.charAt(num2));
        for (int i = 0; i < my_string.length(); i++) {
            if (i == num1) {
                sb.append(second);
                continue;
            }

            if (i == num2) {
                sb.append(first);
                continue;
            }

            sb.append(Character.toString(my_string.charAt(i)));
        }

        answer = sb.toString();
        return answer;
    }
}
