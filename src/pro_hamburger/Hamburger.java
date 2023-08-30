package pro_hamburger;

import java.util.Stack;

public class Hamburger {

    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int j : ingredient) {
            stack.push(j);
            if (stack.size() >= 4) {
                int one = stack.pop();
                int two = stack.pop();
                int three = stack.pop();
                int four = stack.pop();
                if (one == 1 && two == 3 && three == 2 && four == 1) {
                    answer++;
                } else {
                    stack.push(four);
                    stack.push(three);
                    stack.push(two);
                    stack.push(one);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}
        ));
    }
}
