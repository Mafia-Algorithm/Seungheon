class QuadZip {
    
    static int[][] board;
    static boolean[][] isCounted;
    static int[] answer = new int[2];
    static int zeroCount = 0;
    static int oneCount = 0;
    
    static void recursion(int startX, int startY, int size) {
        int value = board[startX][startY];
        boolean isAllSame = true;
        
        // 모두 같은 수인지 확인
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (board[i][j] != value) {
                    isAllSame = false;
                    break;
                }
            }
            if (!isAllSame) {
                break;
            }
        }
        
        // 만약 모든 수가 동일하다면 정답에 1 덧셈
        if (isAllSame) {
            if (board[startX][startY] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
        } else { 
            int nextSize = size / 2;
            if (nextSize == 0) {
                return;
            }
            recursion(startX, startY, nextSize);
            recursion(startX, startY + nextSize, nextSize);
            recursion(startX + nextSize, startY, nextSize);
            recursion(startX + nextSize, startY + nextSize, nextSize);
        }
    }
    
    public int[] solution(int[][] arr) {
        
        board = arr;
        isCounted = new boolean[board.length][board.length];
        recursion(0, 0, board.length);

        answer[0] = zeroCount;
        answer[1] = oneCount;
        return answer;
    }
}
