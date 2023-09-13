package pro_keyboard;

import java.util.Arrays;
import java.util.HashMap;

public class Keyboard {

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : keymap) {
            String[] splitWord = s.split("");
            for (int j = 1; j <= splitWord.length; j++) {
                if (map.containsKey(splitWord[j - 1])) {
                    if (map.get(splitWord[j - 1]) > j) {
                        map.put(splitWord[j - 1], j);
                    }
                } else {
                    map.put(splitWord[j - 1], j);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String[] target = targets[i].split("");
            for (int j = 0; j < target.length; j++) {
                if (!map.containsKey(target[j])) {
                    answer[i] = -1;
                    break;
                }

                answer[i] += map.get(target[j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"AA"},
                new String[]{"B"}
        )));
    }
}
