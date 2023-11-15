package pro_realization;

public class RockScissorsPaper {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rsp.length(); i++) {
            char round = rsp.charAt(i);

            switch (round) {
                case '2':
                    sb.append("0");
                    break;
                case '0':
                    sb.append("5");
                    break;
                case '5':
                    sb.append("2");
                    break;
            }
        }

        return sb.toString();
    }
}
