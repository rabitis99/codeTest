import java.util.*;
class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<int[]> queue = new LinkedList<>();
            int time = 0;
            int totalWeight = 0;
            int index = 0;

            while (index<truck_weights.length || !queue.isEmpty()){
                time++;
                // 트럭이 다리를 빠져나가는 시점
                if (!queue.isEmpty() && queue.peek()[1] == time) {
                    totalWeight -= queue.poll()[0];
                }
                // 새로운 트럭을 올릴 수 있는지 확인
                if (index < truck_weights.length && totalWeight + truck_weights[index] <= weight && queue.size() < bridge_length) {
                    int truck = truck_weights[index++];
                    totalWeight += truck;
                    queue.offer(new int[]{truck, time + bridge_length});
                }
            }
            return time;
        }


    }