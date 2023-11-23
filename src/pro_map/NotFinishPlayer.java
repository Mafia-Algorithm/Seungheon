package pro_map;

import java.util.HashMap;

public class NotFinishPlayer {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> finish = new HashMap<String, Integer>();
        for (String player : completion) {
            if (finish.containsKey(player)) {
                finish.put(player, finish.get(player) + 1);
            } else {
                finish.put(player, 1);
            }
        }

        for (String player : participant) {
            if (!finish.containsKey(player)) {
                answer = player;
                return answer;
            } else {
                finish.put(player, finish.get(player) - 1);
            }
        }

        for (String player : completion) {
            if (finish.get(player) != 0) {
                answer = player;
            }
        }

        return answer;
    }
}
