package pro_nearest_letter;

import java.util.Arrays;
import java.util.HashMap;

public class NearestLetter {

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                answer[i] = -1;
                map.put(s.charAt(i), i);
            } else {
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
    }
}
