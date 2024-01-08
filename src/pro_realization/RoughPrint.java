package pro_realization;

public class RoughPrint {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String[] split = targets[i].split("");
            int pushCount = 0;
            for (String word : split) {
                int min = Integer.MAX_VALUE;
                for (String key : keymap) {
                    if (key.contains(word)) {
                        int index = key.indexOf(word) + 1;
                        if (min > index) min = index;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    pushCount = -1;
                    break;
                }
                pushCount += min;
            }

            answer[i] = pushCount;
        }

        return answer;
    }
}
