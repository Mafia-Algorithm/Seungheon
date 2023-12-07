package pro_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            if (queue.size() <= k) {
                answer[i] = Collections.min(queue);
            } else {
                int[] tmp = new int[k];
               for (int j = 0; j < k; j++) {
                   tmp[j] = queue.poll();
               }

               answer[i] = tmp[k - 1];

               for (int t : tmp) {
                   queue.add(t);
               }
            }
        }

        return answer;
    }
}
