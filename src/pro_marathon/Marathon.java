package pro_marathon;

import java.util.HashMap;
import java.util.Map;

public class Marathon {

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String person : participant) {
            if (map.containsKey(person)) {
                map.put(person, map.get(person) + 1);
            } else {
                map.put(person, 1);
            }
        }

        for (String complete : completion) {
            map.put(complete, map.get(complete) - 1);
        }

        return getKey(map, 0);
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}
        ));
    }
}
