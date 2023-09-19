package pro_string_split;

import java.util.HashMap;

public class StringSplit {

    public static int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char criteria = s.charAt(0);
        int anotherLetter = 0;
        int answer = 0;

        for (int i = 0 ; i < s.length(); i++) {
            if (map.isEmpty()) {
                map.put(s.charAt(i), 1);
                criteria = s.charAt(i);
                if (i == s.length() - 1) answer++;
                continue;
            }

            if (map.containsKey(s.charAt(i))) {
                map.put(criteria, map.get(criteria) + 1);
            } else {
                anotherLetter++;
            }

            if (map.get(criteria) == anotherLetter) {
                answer++;
                anotherLetter = 0;
                map.clear();
            } else {
                if (i == s.length() - 1) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aa"));
    }
}
