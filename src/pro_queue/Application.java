package pro_queue;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        FeatureDevelop featureDevelop = new FeatureDevelop();
        System.out.println(Arrays.toString(featureDevelop.solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        )));
    }
}
