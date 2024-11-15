import java.util.*;

class FindCrash {
    
    static int answer = 0;
    static int[][] board = new int[101][101];
    static List<List<Integer>> robotPositionList = new ArrayList<>();
    
    static void shortestMove(int robotValue, int startX, int startY, int endX, int endY) {
        List<Integer> positionList = robotPositionList.get(robotValue - 1); 
        if (positionList.size() == 0) {
            positionList.add(startX);
            positionList.add(startY);
        }
        // 목적지에 도달할 때까지 반복
        while (startX != endX || startY != endY) {
            // 출발지점보다 도착지점의 x가 더 큰 경우
            if (startX < endX) {
                startX++;
                positionList.add(startX);
                positionList.add(startY);
                continue;
            }
        
            // 출발지점보다 도착지점의 x가 더 작은 경우
            if (startX > endX) {
                startX--;
                positionList.add(startX);
                positionList.add(startY);
                continue;
            }
        
            // 출발지점과 도착지점의 x가 같은 경우
            if (startX == endX) {
                // 출발지점보다 도착지점의 y가 더 큰 경우
                if (startY < endY) {
                    startY++;
                    positionList.add(startX);
                    positionList.add(startY);
                    continue;
                }
                
                // 출발지점보다 도착지점의 y가 더 작은 경우
                if (startY > endY) {
                    startY--;
                    positionList.add(startX);
                    positionList.add(startY);
                    continue;
                }
            }
            positionList.add(startX);
            positionList.add(startY);
        }
    }
    
    static int getCrashCount() {
        int max = Integer.MIN_VALUE;
        for (List<Integer> list : robotPositionList) {
            if (list.size() > max) {
                max = list.size();
            }
        }
        
        int maxSecond = max / 2;
        // 각 초마다 로봇 위치 확인
        for (int i = 0; i < maxSecond; i++) {
            HashMap<List<Integer>, List<Integer>> map = new HashMap<>();
            int x = i * 2;
            int y = i * 2 + 1;
            for (int j = 0; j < robotPositionList.size(); j++) {
                List<Integer> positionList = robotPositionList.get(j);
                if (positionList.size() < y) {
                    continue;
                }
                int nowX = positionList.get(x);
                int nowY = positionList.get(y);
                if (!map.containsKey(List.of(nowX, nowY))) {
                    List<Integer> robotList = new ArrayList<>();
                    robotList.add(j + 1);
                    map.put(List.of(nowX, nowY), robotList);
                } else {
                    map.get(List.of(nowX, nowY)).add(j + 1);
                }
            }
            
            for (List<Integer> key : map.keySet()) {
                List<Integer> robotList = map.get(key);
                if (robotList.size() >= 2) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public int solution(int[][] points, int[][] routes) {
        
        int pointValue = 1;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            
            board[x][y] = pointValue;
            pointValue++;
        }
        
        int robotValue = 1;
        for (int[] route : routes) {
            robotPositionList.add(new ArrayList<>());
            for (int i = 0; i < route.length - 1; i++) {
                int startP = route[i] - 1;
                int endP = route[i + 1] - 1;
                int startX = points[startP][0];
                int startY = points[startP][1];
                int endX = points[endP][0];
                int endY = points[endP][1];
                shortestMove(robotValue, startX, startY, endX, endY);
            }
            robotValue++;
        }
        
        return getCrashCount();
    }
}
