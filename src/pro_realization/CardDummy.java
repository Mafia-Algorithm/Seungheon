package pro_realization;

import java.util.Stack;

public class CardDummy {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Stack<String> firstStack = new Stack<>();
        Stack<String> secondStack = new Stack<>();

        for (int i = cards1.length - 1; i >= 0; i--) {
            firstStack.push(cards1[i]);
        }

        for (int i = cards2.length - 1; i >= 0; i--) {
            secondStack.push(cards2[i]);
        }

        boolean canMake = true;
        for (String word : goal) {
            if (!firstStack.isEmpty() && word.equals(firstStack.peek())) {
                firstStack.pop();
                continue;
            }

            if (!secondStack.isEmpty() && word.equals(secondStack.peek())) {
                secondStack.pop();
                continue;
            }

            canMake = false;
            break;
        }

        return canMake ? "Yes" : "no";
    }
}
