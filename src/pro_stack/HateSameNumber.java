package pro_stack;

import java.util.Stack;

public class HateSameNumber {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int number : arr) {
            if (stack.isEmpty()) {
                stack.push(number);
                continue;
            }

            if (stack.peek() == number) continue;
            stack.push(number);
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
