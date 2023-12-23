package pro_greedy;

public class AntArmy {
    public int solution(int hp) {
        int answer = 0;

        int generalAnt = hp / 5;
        hp -= generalAnt * 5;

        int soldierAnt = hp / 3;
        hp -= soldierAnt * 3;

        int workAnt = hp;

        answer = generalAnt + soldierAnt + hp;

        return answer;
    }
}
