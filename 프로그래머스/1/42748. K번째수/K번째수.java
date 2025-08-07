import java.util.*;
class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer =new int[commands.length];
            int index=0;
            for (int[] command:commands){
                int startNum= command[0]-1;
                int finishNum= command[1];
                int foundNum= command[2]-1;
                
                int[] buffer= Arrays.copyOfRange(array,startNum,finishNum);
                Arrays.sort(buffer);
                answer[index]=buffer[foundNum];
                
                index++;
            }
            
            return answer;
        }
    }