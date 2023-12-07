package pro_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class OvertimeFigure {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            queue.add(work);
        }

        for (int i = 0; i < n; i++) {
            int work = queue.poll() - 1;
            if (work < 0) {
                queue.add(0);
                continue;
            }
            queue.add(work);
        }

        for (int number : queue) {
            answer += (long) number * number;
        }

        return answer;
    }
}
