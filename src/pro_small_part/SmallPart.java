package pro_small_part;

public class SmallPart {

    public static int solution(String t, String p) {
        int answer = 0;
        long numberP = Long.parseLong(p);
        for (int i = 0; i <= t.length() - p.length(); i++) {
            int lastIndex = i + p.length();

            long now = Long.parseLong(t.substring(i, lastIndex));
            if (now <= numberP) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("500220839878", "7"));
    }
}
