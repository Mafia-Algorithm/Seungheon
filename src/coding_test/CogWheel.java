package coding_test;

import java.io.*;
import java.util.*;

public class CogWheel {
    
    static class CogWheelInfo {

        int north;
        int northEast;
        int east;
        int southEast;
        int south;
        int southWest;
        int west;
        int northWest;

        public CogWheelInfo(int[] status) {
            this.north = status[0];
            this.northEast = status[1];
            this.east = status[2];
            this.southEast = status[3];
            this.south = status[4];
            this.southWest = status[5];
            this.west = status[6];
            this.northWest = status[7];
        }
        
        public void turnLeft() {
            int tmp = this.north;
            this.north = this.northEast;
            this.northEast = this.east;
            this.east = this.southEast;
            this.southEast = this.south;
            this.south = this.southWest;
            this.southWest = this.west;
            this.west = northWest;
            this.northWest = tmp;
        }

        public void turnRight() {
            int tmp = this.north;
            this.north = this.northWest;
            this.northWest = this.west;
            this.west = this.southWest;
            this.southWest = this.south;
            this.south = this.southEast;
            this.southEast = this.east;
            this.east = this.northEast;
            this.northEast = tmp;
        }
    }    

    static CogWheelInfo firstCogWheel;
    static CogWheelInfo secondCogWheel;
    static CogWheelInfo thirdCogWheel;
    static CogWheelInfo fourthCogWheel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        firstCogWheel = new CogWheelInfo(Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray());
        secondCogWheel = new CogWheelInfo(Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray());
        thirdCogWheel = new CogWheelInfo(Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray());
        fourthCogWheel = new CogWheelInfo(Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray());

        int operationCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < operationCount; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cogWheelNumber = input[0];
            int direction = input[1];

            if (cogWheelNumber == 1) {
                if (direction == 1) {
                    if (firstCogWheel.east != secondCogWheel.west) {
                        secondCogWheel.turnLeft();
                    }
                    firstCogWheel.turnRight();
                } else {
                    if (firstCogWheel.east != secondCogWheel.west) {
                        secondCogWheel.turnRight();
                    }
                    firstCogWheel.turnLeft();
                }
            }

            if (cogWheelNumber == 2) {
                if (direction == 1) {
                    if (secondCogWheel.east != thirdCogWheel.west) {
                        thirdCogWheel.turnLeft();
                    }
                    
                    if (secondCogWheel.west != firstCogWheel.east) {
                        firstCogWheel.turnLeft();
                    } 
                    secondCogWheel.turnRight();
               } else {
                    if (secondCogWheel.east != thirdCogWheel.west) {
                        thirdCogWheel.turnRight();
                    }

                    if (secondCogWheel.west != firstCogWheel.east) {
                        firstCogWheel.turnRight();
                    }
                    secondCogWheel.turnLeft();
                }
            }

            if (cogWheelNumber == 3) {
                if (direction == 1) {
                    if (thirdCogWheel.east != fourthCogWheel.west) {
                        fourthCogWheel.turnLeft();
                    }
                    
                    if (thirdCogWheel.west != secondCogWheel.east) {
                        secondCogWheel.turnLeft();
                    } 
                    thirdCogWheel.turnRight();
                } else {
                    if (thirdCogWheel.east != fourthCogWheel.west) {
                        fourthCogWheel.turnRight();
                    }

                    if (thirdCogWheel.west != secondCogWheel.east) {
                        secondCogWheel.turnRight();
                    }
                    thirdCogWheel.turnLeft();
                }
            }

            if (cogWheelNumber == 4) {
                if (direction == 1) {
                    if (fourthCogWheel.west != thirdCogWheel.east) {
                        thirdCogWheel.turnLeft();
                    }              
                    fourthCogWheel.turnRight();
                } else {
                    if (fourthCogWheel.west != thirdCogWheel.east) {
                        thirdCogWheel.turnRight();
                    }
                    fourthCogWheel.turnLeft();
                }
            }
        }

        int answer = 0;
        System.out.println(firstCogWheel.north);
        System.out.println(firstCogWheel.northEast);
        System.out.println(firstCogWheel.east);
        System.out.println(firstCogWheel.southEast);
        System.out.println(firstCogWheel.south);
        System.out.println(firstCogWheel.southWest);
        System.out.println(firstCogWheel.west);
        System.out.println(firstCogWheel.northWest);

        if (firstCogWheel.north == 1) {
            answer += 1;
        }
       
        if (secondCogWheel.north == 1) {
            answer += 2;
        }

        if (thirdCogWheel.north == 1) {
            answer += 4;
        }

        if (fourthCogWheel.north == 1) {
            answer += 8;
        }

        bw.write(Integer.toString(answer) + "\n");
        bw.flush();
        bw.close();
    }
}
