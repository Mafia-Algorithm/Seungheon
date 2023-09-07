package pro_run;

import java.util.*;

public class Run {

    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String player : callings) {
            int tmp = map.get(player);
            String front = players[tmp - 1];
            map.put(player, map.get(front));
            map.put(front, tmp);

            players[tmp] = players[tmp - 1];
            players[tmp - 1] = player;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer[entry.getValue()] = entry.getKey();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"}
        )));
    }
}
