package pro_number_pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class NumberPair {

    public static String solution(String X, String Y) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < X.length(); i++) {
            if (map.containsKey(X.charAt(i))) {
                map.put(X.charAt(i), map.get(X.charAt(i)) + 1);
            } else {
                map.put(X.charAt(i), 1);
            }
        }

        for (int i = 0; i < Y.length(); i++) {
            if (map.containsKey(Y.charAt(i)) && map.get(Y.charAt(i)) >= 1) {
                list.add(Integer.parseInt(Character.toString(Y.charAt(i))));
                map.put(Y.charAt(i), map.get(Y.charAt(i)) - 1);
            }
        }

        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        boolean onlyZero = list.contains(0);
        int zeroCount = 0;

        for (int i : list) {
            sb.append(i);
            if (i != 0) {
                onlyZero = false;
            } else {
                zeroCount++;
            }
        }

        if (sb.toString().length() == 0) {
            sb.append(-1);
        }

        if (onlyZero && zeroCount >= 2) {
            StringBuilder newSb = new StringBuilder();
            newSb.append(0);
            return newSb.toString();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("5525", "1255"));
    }
}
