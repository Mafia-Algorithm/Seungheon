import java.util.*;

class RollCake {
    public int solution(int[] topping) {
        int n = topping.length;
        
        // 왼쪽 집합 크기 추적
        Set<Integer> leftSet = new HashSet<>();
        int[] leftCounts = new int[n];
        
        // 왼쪽 집합 계산
        for (int i = 0; i < n; i++) {
            leftSet.add(topping[i]);
            leftCounts[i] = leftSet.size();
        }
        
        // 오른쪽 집합 크기 추적
        Set<Integer> rightSet = new HashSet<>();
        int[] rightCounts = new int[n];
        
        // 오른쪽 집합 계산
        for (int i = n - 1; i >= 0; i--) {
            rightSet.add(topping[i]);
            rightCounts[i] = rightSet.size();
        }
        
        // 공평하게 나누는 경우 카운트
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftCounts[i] == rightCounts[i + 1]) {
                result++;
            }
        }
        
        return result;
    }
}
