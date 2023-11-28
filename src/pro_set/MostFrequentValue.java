package pro_set;

import java.util.HashMap;

public class MostFrequentValue {
    public int solution(int[] array) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int number : array) {
            if (map.containsKey(number)) {
                if (max < map.get(number) + 1) {
                    max = map.get(number) + 1;
                }
                map.put(number, map.get(number) + 1);
            } else {
                if (max < 1) {
                    max = 1;
                }
                map.put(number, 1);
            }
        }

        int maxCount = 0;
        for (Integer key : map.keySet()) {
            if (max == map.get(key)) {
                maxCount++;
            }

            if (maxCount > 1) {
                answer = -1;
                return answer;
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                answer = key;
            }
        }

        return answer;
    }
}
