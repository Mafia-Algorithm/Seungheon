package pro_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Process {

    static class ProcessInfo implements Comparable<ProcessInfo> {

        int priority;
        int location;

        public ProcessInfo(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        public int getPriority() {
            return this.priority;
        }

        public int getLocation() {
            return this.location;
        }

        @Override
        public int compareTo(ProcessInfo processInfo) {

            if (this.priority > processInfo.getPriority())
                return 1;
            else if (this.priority < processInfo.getPriority())
                return -1;
            return 0;
        }
    }

    int findMax(Queue<ProcessInfo> queue) {
        int max = Integer.MIN_VALUE;
        for (ProcessInfo processInfo : queue) {
            if (processInfo.getPriority() > max) {
                max = processInfo.getPriority();
            }
        }

        return max;
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<ProcessInfo> processQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            processQueue.add(new ProcessInfo(priorities[i], i));
        }

        while (!processQueue.isEmpty()) {
            for (ProcessInfo p : processQueue) {
                System.out.print(p.getPriority() + " ");
            }
            System.out.println();
            int max = findMax(processQueue);
            ProcessInfo tmp = processQueue.poll();
            if (tmp.getPriority() != max) {
                processQueue.add(tmp);
            } else {
                answer++;
                if (location == tmp.getLocation()) {
                    break;
                }
            }
        }

        return answer;
    }
}
