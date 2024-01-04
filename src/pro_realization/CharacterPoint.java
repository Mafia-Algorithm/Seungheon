package pro_realization;

public class CharacterPoint {
    public int[] solution(String[] keyinput, int[] board) {

        int maxX = (board[0] - 1) / 2;
        int minX = maxX * -1;
        int maxY = (board[1] - 1) / 2;
        int minY = maxY * -1;

        int x = 0;
        int y = 0;

        for (String input: keyinput) {
            if (input.equals("up")) {
                if (minY <= y + 1 && y + 1 <= maxY) {
                    y += 1;
                    continue;
                }
            }

            if (input.equals("down")) {
                if (minY <= y - 1 && y - 1 <= maxY) {
                    y -= 1;
                    continue;
                }
            }

            if (input.equals("left")) {
                if (minX <= x - 1 && x - 1 <= maxX) {
                    x -= 1;
                    continue;
                }
            }

            if (input.equals("right")) {
                if (minX <= x + 1 && x + 1 <= maxX) {
                    x += 1;
                }
            }
        }

        return new int[]{x, y};
    }
}
