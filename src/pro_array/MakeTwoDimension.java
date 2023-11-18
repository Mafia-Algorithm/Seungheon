package pro_array;

public class MakeTwoDimension {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];

        int[] split = new int[n];
        for (int i = 0; i < num_list.length; i++) {
            int index = i;
            if (index > 1) {
                index %= n;
            }

            split[index] = num_list[i];

            if (index == n - 1) {
                answer[i / n] = split;
                split = new int[n];
            }
        }

        return answer;
    }
}
