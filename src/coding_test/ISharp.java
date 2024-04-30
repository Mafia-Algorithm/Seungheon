package coding_test;

import java.io.*;

public class ISharp {

    public static String reverseType(String str){
        char[] origin = str.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = str.length()-1; i >= 0; i--) {
            if(origin[i]!=']'){
                if(origin[i]=='*' || origin[i]=='&'){
                    result.append(origin[i]);
                }else{
                    result.append("#");
                    for(int j=0; j <= i; j++){
                        result.append(origin[j]);
                    }
                    break;
                }
            }else{
                result.append("[]");
                i--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().replace(",", "").replace(";", "");
        String[] variables = input.split(" ");

        for (int i = 1; i < variables.length; i++) {
            String[] variable = reverseType(variables[i]).split("#");
            bw.write(variables[0] + variable[0] + " " + variable[1] + ";");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
