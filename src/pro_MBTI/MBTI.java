package pro_MBTI;

import java.util.HashMap;

public class MBTI {

    static String[] LIST = {"R", "T", "C", "F", "J", "M", "A", "N"};

    public static String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            String[] splitSurvey = survey[i].split("");
            int result = switch (choices[i]) {
                case 1, 7 -> 3;
                case 2, 6 -> 2;
                case 3, 5 -> 1;
                default -> 0;
            };

            if (map.containsKey(splitSurvey[0]) && map.containsKey(splitSurvey[1]) && choices[i] <= 3) {
                map.put(splitSurvey[0], map.get(splitSurvey[0]) + result);
                continue;
            }

            if (map.containsKey(splitSurvey[0]) && map.containsKey(splitSurvey[1]) && choices[i] >= 4) {
                map.put(splitSurvey[1], map.get(splitSurvey[1]) + result);
                continue;
            }

            if (choices[i] <= 3) {
                map.put(splitSurvey[0], result);
                map.put(splitSurvey[1], 0);
            } else {
                map.put(splitSurvey[0], 0);
                map.put(splitSurvey[1], result);
            }
        }

        for (String s : LIST) {
            if (!map.containsKey(s)) {
                map.put(s, 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        int R = map.get("R");
        int T = map.get("T");
        int C = map.get("C");
        int F = map.get("F");
        int J = map.get("J");
        int M = map.get("M");
        int A = map.get("A");
        int N = map.get("N");

        if (R >= T) {
            sb.append("R");
        } else {
            sb.append("T");
        }

        if (C >= F) {
            sb.append("C");
        } else {
            sb.append("F");
        }

        if (J >= M) {
            sb.append("J");
        } else {
            sb.append("M");
        }

        if (A >= N) {
            sb.append("A");
        } else {
            sb.append("N");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"TR", "RT", "TR"},
                new int[]{7, 1, 3}
        ));
    }
}
