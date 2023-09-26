package pro_crane;

import java.util.Stack;

public class Crane {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[j][i - 1]) {
                        answer += 2;
                        stack.pop();
                        board[j][i - 1] = 0;
                    } else {
                        stack.push(board[j][i - 1]);
                        board[j][i - 1] = 0;
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{
                        {0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}
                },
                new int[]{1,5,3,5,1,2,1,4}
        ));
    }
}
