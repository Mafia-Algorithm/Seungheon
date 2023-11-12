package pro_string;

public class StringPush {
    public int solution(String A, String B) {
        int answer = -1;

        String tmp = A;
        for (int i = 0; i < A.length(); i++) {
            if (tmp.equals(B)) {
                answer = i;
                break;
            }

            tmp = push(tmp);
        }

        return answer;
    }

    public String push(String tmp) {
        StringBuilder sb = new StringBuilder();
        sb.append(tmp.charAt(tmp.length() - 1));
        for (int i = 0; i < tmp.length() - 1; i++) {
            sb.append(tmp.charAt(i));
        }

        return sb.toString();
    }
}
