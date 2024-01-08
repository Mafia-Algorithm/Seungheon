package pro_realization;

public class PushKeypad {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int[][] positions = {
                {3, 1}, // 0
                {0, 0}, // 1
                {0, 1}, // 2
                {0, 2}, // 3
                {1, 0}, // 4
                {1, 1}, // 5
                {1, 2}, // 6
                {2, 0}, // 7
                {2, 1}, // 8
                {2, 2}  // 9
        };

        int[] left = {3, 0};
        int[] right = {3, 2};

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                left = positions[number];
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = positions[number];
            } else {
                int leftDistance = calculateDistance(left, positions[number]);
                int rightDistance = calculateDistance(right, positions[number]);

                if (leftDistance < rightDistance || (leftDistance == rightDistance && hand.equals("left"))) {
                    answer.append("L");
                    left = positions[number];
                } else {
                    answer.append("R");
                    right = positions[number];
                }
            }
        }

        return answer.toString();
    }

    private int calculateDistance(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }
}
