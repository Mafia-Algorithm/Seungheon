package pro_paint;

public class PaintOver {

    public static int solution(int n, int m, int[] section) {
        int start = section[0];
        int end = section[0] + (m - 1);
        int ans = 1;

        for(int i : section){
            if(!(i >= start && i <= end)) {
                start = i;
                end = i + (m - 1);
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 1, new int[]{1, 2, 3, 4}));
    }
}
