package pro_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class TurnArray {
    public int[] solution(int[] numbers, String direction) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int number : numbers) {
            deque.add(number);
        }

        if (direction.equals("left")) {
            if (!deque.isEmpty()) {
                int tmp = deque.removeFirst();
                deque.addLast(tmp);
            }
        } else {
            if (!deque.isEmpty()) {
                int tmp = deque.removeLast();
                deque.addFirst(tmp);
            }
        }

        return deque.stream().mapToInt(i -> i).toArray();
    }
}
