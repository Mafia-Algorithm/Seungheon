package pro_keypad;

import java.util.Arrays;

public class Keypad {

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        String leftHandPosition = "30";
        String rightHandPosition = "32";

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(leftHandPosition + " : " + rightHandPosition);
            if (numbers[i] == 1) {
                sb.append("L");
                leftHandPosition = "00";
                continue;
            }

            if (numbers[i] == 4) {
                sb.append("L");
                leftHandPosition = "10";
                continue;
            }

            if (numbers[i] == 7) {
                sb.append("L");
                leftHandPosition = "20";
                continue;
            }

            if (numbers[i] == 3) {
                sb.append("R");
                rightHandPosition = "02";
                continue;
            }

            if (numbers[i] == 6) {
                sb.append("R");
                rightHandPosition = "12";
                continue;
            }

            if (numbers[i] == 9) {
                sb.append("R");
                rightHandPosition = "22";
                continue;
            }

            if (numbers[i] == 2) {
                int x = 1;
                int y = 0;
                int[] splitLeftPosition = Arrays.stream(leftHandPosition.split("")).mapToInt(Integer::parseInt).toArray();
                int[] splitRightPosition = Arrays.stream(rightHandPosition.split("")).mapToInt(Integer::parseInt).toArray();

                int leftDistance = Math.abs(y - splitLeftPosition[0]) + Math.abs(x - splitLeftPosition[1]);
                int rightDistance = Math.abs(y - splitRightPosition[0]) + Math.abs(x - splitRightPosition[1]);

                if (leftDistance > rightDistance) {
                    sb.append("R");
                    rightHandPosition = "01";
                    continue;
                }

                if (rightDistance > leftDistance) {
                    sb.append("L");
                    leftHandPosition = "01";
                    continue;
                }

                if (hand.equals("right")) {
                    sb.append("R");
                    rightHandPosition = "01";
                } else {
                    sb.append("L");
                    leftHandPosition = "01";
                }
                continue;
            }

            if (numbers[i] == 5) {
                int x = 1;
                int y = 1;
                int[] splitLeftPosition = Arrays.stream(leftHandPosition.split("")).mapToInt(Integer::parseInt).toArray();
                int[] splitRightPosition = Arrays.stream(rightHandPosition.split("")).mapToInt(Integer::parseInt).toArray();

                int leftDistance = Math.abs(y - splitLeftPosition[0]) + Math.abs(x - splitLeftPosition[1]);
                int rightDistance = Math.abs(y - splitRightPosition[0]) + Math.abs(x - splitRightPosition[1]);

                if (leftDistance > rightDistance) {
                    sb.append("R");
                    rightHandPosition = "11";
                    continue;
                }

                if (rightDistance > leftDistance) {
                    sb.append("L");
                    leftHandPosition = "11";
                    continue;
                }

                if (hand.equals("right")) {
                    sb.append("R");
                    rightHandPosition = "11";
                } else {
                    sb.append("L");
                    leftHandPosition = "11";
                }
                continue;
            }

            if (numbers[i] == 8) {
                int x = 1;
                int y = 2;
                int[] splitLeftPosition = Arrays.stream(leftHandPosition.split("")).mapToInt(Integer::parseInt).toArray();
                int[] splitRightPosition = Arrays.stream(rightHandPosition.split("")).mapToInt(Integer::parseInt).toArray();

                int leftDistance = Math.abs(y - splitLeftPosition[0]) + Math.abs(x - splitLeftPosition[1]);
                int rightDistance = Math.abs(y - splitRightPosition[0]) + Math.abs(x - splitRightPosition[1]);

                if (leftDistance > rightDistance) {
                    sb.append("R");
                    rightHandPosition = "21";
                    continue;
                }

                if (rightDistance > leftDistance) {
                    sb.append("L");
                    leftHandPosition = "21";
                    continue;
                }

                if (hand.equals("right")) {
                    sb.append("R");
                    rightHandPosition = "21";
                } else {
                    sb.append("L");
                    leftHandPosition = "21";
                }
                continue;
            }

            if (numbers[i] == 0) {
                int x = 1;
                int y = 3;
                int[] splitLeftPosition = Arrays.stream(leftHandPosition.split("")).mapToInt(Integer::parseInt).toArray();
                int[] splitRightPosition = Arrays.stream(rightHandPosition.split("")).mapToInt(Integer::parseInt).toArray();

                int leftDistance = Math.abs(y - splitLeftPosition[0]) + Math.abs(x - splitLeftPosition[1]);
                int rightDistance = Math.abs(y - splitRightPosition[0]) + Math.abs(x - splitRightPosition[1]);

                if (leftDistance > rightDistance) {
                    sb.append("R");
                    rightHandPosition = "31";
                    continue;
                }

                if (rightDistance > leftDistance) {
                    sb.append("L");
                    leftHandPosition = "31";
                    continue;
                }

                if (hand.equals("right")) {
                    sb.append("R");
                    rightHandPosition = "31";
                } else {
                    sb.append("L");
                    leftHandPosition = "31";
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                "right"
        ));
    }
}
