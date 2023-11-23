package pro_map;

import java.util.HashMap;
import java.util.Map;

public class PersonalityType {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<String, Integer> score = new HashMap<>(Map.of(
                "R", 0,
                "T", 0,
                "C", 0,
                "F", 0,
                "J", 0,
                "M", 0,
                "A", 0,
                "N", 0
        ));

        for (int i = 0; i < survey.length; i++) {
            String[] typeSplit = survey[i].split("");
            String first = typeSplit[0];
            String second = typeSplit[1];
            int choice = choices[i];

            if (choice == 1) {
                score.put(first, score.get(first) + 3);
            }

            if (choice == 2) {
                score.put(first, score.get(first) + 2);
            }

            if (choice == 3) {
                score.put(first, score.get(first) + 1);
            }

            if (choice == 5) {
                score.put(second, score.get(second) + 1);
            }

            if (choice == 6) {
                score.put(second, score.get(second) + 2);
            }

            if (choice == 7) {
                score.put(second, score.get(second) + 3);
            }
        }

        if (score.get("R") < score.get("T")) {
            answer += "T";
        } else {
            answer += "R";
        }

        if (score.get("C") < score.get("F")) {
            answer += "F";
        } else {
            answer += "C";
        }

        if (score.get("J") < score.get("M")) {
            answer += "M";
        } else {
            answer += "J";
        }

        if (score.get("A") < score.get("N")) {
            answer += "N";
        } else {
            answer += "A";
        }

        return answer;
    }
}
