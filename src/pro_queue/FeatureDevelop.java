package pro_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FeatureDevelop {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            int extraDay = (100 - progress) / speed;
            if ((100 - progress) % speed != 0) {
                extraDay++;
            }

            queue.add(extraDay);
        }

        while (!queue.isEmpty()) {
            if (queue.peek() == 0) {
                int count = 0;
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    if (queue.peek() == 0) {
                        queue.poll();
                        count++;
                    }
                }

                answer.add(count);
            } else {
                for (int j = 0; j < queue.size(); j++) {
                    int tmp = queue.remove();
                    if (tmp == 0) {
                        queue.add(0);
                        continue;
                    }
                    queue.add(tmp - 1);
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
