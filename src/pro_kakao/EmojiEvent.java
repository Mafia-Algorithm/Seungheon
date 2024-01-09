package pro_kakao;

import java.util.ArrayList;
import java.util.List;

public class EmojiEvent {
    static List<int[]> list;
    static int[] dis = new int[] {10,20,30,40};
    public int[] solution(int[][] users, int[] emoticons) {

        int[] answer;
        list = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        com(0, emoticons.length, 0, new int[emoticons.length]);

        int cnt = 0;
        while (cnt < list.size()) {
            int userPlus = 0;
            int userSum = 0;

            for (int[] user : users) {
                int sum = 0;
                int[] discount = list.get(cnt);
                for (int j = 0; j < emoticons.length; j++) {
                    if (user[0] <= discount[j]) {
                        sum += emoticons[j] - emoticons[j] * discount[j] / 100;
                    }
                }
                if (sum >= user[1]) {
                    userPlus++;
                    sum = 0;
                }
                userSum += sum;
            }

            cnt++;
            result.add(new int[]{userPlus, userSum});
        }

        result.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o2[0] - o1[0];
            }
        });


        answer = result.get(0);

        return answer;
    }

    public void com(int idx, int size, int depth, int[] arr) {
        if (size == depth) {
            int[] temp = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            list.add(temp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[idx] = dis[i];
            com(idx + 1, size, depth + 1, arr);
        }
    }
}
