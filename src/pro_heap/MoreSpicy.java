package pro_heap;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (long s : scoville) {
            queue.add(s);
        }

        while (queue.peek() < K) {

            if (queue.size() < 2) {
                answer = -1;
                break;
            }

            long firstSmall = queue.poll();
            long secondSmall = queue.poll();

            queue.add(firstSmall + secondSmall * 2);
            answer++;
        }

        return answer;
    }
}
