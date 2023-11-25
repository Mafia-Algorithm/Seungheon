package pro_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NearestChar {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();

        HashMap<Character, Integer> position = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);

            if (!position.containsKey(alphabet)) {
                answer.add(-1);
                position.put(alphabet, i);
            } else {
                answer.add(i - position.get(alphabet));
                position.put(alphabet, i);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
