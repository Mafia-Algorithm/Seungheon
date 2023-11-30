package pro_stack;

import java.util.Stack;

public class ControlZ {
    public int solution(String s) {
        int answer = 0;

        String[] split = s.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String input : split) {
            if (input.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(input));
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}
