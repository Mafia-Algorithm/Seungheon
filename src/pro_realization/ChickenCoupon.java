package pro_realization;

public class ChickenCoupon {

    public int solution(int chicken) {
        int answer = 0;
        int extra = chicken;

        while (extra / 10 != 0) {
            answer += extra / 10;
            int service = extra / 10;
            extra -= service * 10;
            extra += service;
        }

        return answer;
    }
}
