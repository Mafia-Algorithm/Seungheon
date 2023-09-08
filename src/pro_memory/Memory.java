package pro_memory;

import java.util.Arrays;
import java.util.HashMap;

public class Memory {

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> missPoint = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            missPoint.put(name[i], yearning[i]);
        }

        System.out.println(missPoint);

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (missPoint.containsKey(photo[i][j])) {
                    answer[i] += missPoint.get(photo[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"},
                }
        );

        System.out.println(Arrays.toString(result));
    }
}
