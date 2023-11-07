package pro_maze;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {

    public static int solution(String[] maps) {

        // 필요 변수들 지정 및 초기화
        // 시작점
        int startX = 0;
        int startY = 0;
        // 레버위치 및 시작점>레버 까지 걸린 시간
        int leverLength = 0;
        int leverX = 0;
        int leverY = 0;
        // 종료점 및 레버>종료점 까지 걸린 시간
        int endLength = 0;
        int endX = 0;
        int endY = 0;

        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
                else if(maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                }
                else if(maps[i].charAt(j) == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // 시작점 > 레버 까지 bfs 최단 거리 찾기 (못찾았으면 RETURN -1)
        leverLength = bfs(maps, startX, startY, leverX, leverY);
        if(leverLength == -1) {
            return -1;
        }

        // 레버 > 종료점 까지 bfs로 최단 거리 찾기
        endLength = bfs(maps, leverX, leverY, endX, endY);
        if(endLength == -1) {
            return -1;
        }

        return leverLength + endLength;
    }

    public static int bfs(String[] maps, int startX, int startY, int endX, int endY) {
        // 방문 여부
        Boolean[][] visited = new Boolean[maps.length][maps[0].length()];
        for (Boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }

        // bfs 용 큐
        Queue<Integer[]> bfsQueue = new LinkedList<>();

        // 시작점 입력
        Integer[] startPoint = new Integer[]{startX, startY, 0};
        bfsQueue.add(startPoint);
        visited[startX][startY] = true;

        while(!bfsQueue.isEmpty()) {
            Integer[] point = bfsQueue.poll();

            int x = point[0];
            int y = point[1];
            int level = point[2];

            if(x != 0 && maps[x-1].charAt(y) != 'X' && !visited[x-1][y]) {
                // 상
                if(x-1 == endX && y == endY) {
                    return level+1;
                }
                Integer[] newPoint = new Integer[]{x-1, y, level+1};
                bfsQueue.add(newPoint);
                visited[x-1][y] = true;
            }
            if(x != maps.length-1 && maps[x+1].charAt(y) != 'X' && !visited[x+1][y]) {
                // 하
                if(x+1 == endX && y == endY) {
                    return level+1;
                }
                Integer[] newPoint = new Integer[]{x+1, y, level+1};
                bfsQueue.add(newPoint);
                visited[x+1][y] = true;
            }
            if(y != 0 && maps[x].charAt(y-1) != 'X' && !visited[x][y-1]) {
                // 좌
                if(x == endX && y-1 == endY) {
                    return level+1;
                }
                Integer[] newPoint = new Integer[]{x, y-1, level+1};
                bfsQueue.add(newPoint);
                visited[x][y-1] = true;
            }
            if(y != maps[0].length()-1 && maps[x].charAt(y+1) != 'X' && !visited[x][y+1]) {
                // 우
                if(x == endX && y+1 == endY) {
                    return level+1;
                }
                Integer[] newPoint = new Integer[]{x, y+1, level+1};
                bfsQueue.add(newPoint);
                visited[x][y+1] = true;
            }

        }

        // 목적지에 닿지 못함.
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    }
}
