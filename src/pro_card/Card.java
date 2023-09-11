package pro_card;

import java.util.Stack;

public class Card {

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
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

        String answer = "";
        if (canMake) {
            answer = "Yes";
        } else {
            answer = "No";
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        ));
    }
}
