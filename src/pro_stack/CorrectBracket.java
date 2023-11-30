package pro_stack;

import java.util.Stack;

public class CorrectBracket {
    public boolean solution(String s) {
        boolean answer = true;

        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                bracketStack.push(c);
            } else {
                if (bracketStack.isEmpty()) {
                    answer = false;
                    break;
                }
                else bracketStack.pop();
            }
        }

        if (!bracketStack.isEmpty()) answer = false;

        return answer;
    }
}
