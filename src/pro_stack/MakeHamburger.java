package pro_stack;

import java.util.Stack;

public class MakeHamburger {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int number : ingredient) {
            stack.push(number);
            if (stack.size() >= 4) {
                int four = stack.pop();
                int three = stack.pop();
                int two = stack.pop();
                int one = stack.pop();

                if (one == 1 && two == 2 && three == 3 && four == 1) answer++;
                else {
                    stack.push(one);
                    stack.push(two);
                    stack.push(three);
                    stack.push(four);
                }
            }
        }

        return answer;
    }
}
