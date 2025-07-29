import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 인덱스와 우선순위를 함께 저장하기 위한 큐 생성
        Queue<int[]> queue = new LinkedList<>();

        // 각 문서의 인덱스와 우선순위를 큐에 삽입
        // 예: priorities = [2, 1, 3, 2] -> queue: [ [0,2], [1,1], [2,3], [3,2] ]
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]}); // [문서의 위치(index), 우선순위(priority)]
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 가장 앞에 있는 문서를 꺼냄
            boolean hasHigher = false;    // 뒤에 더 높은 우선순위가 있는지 확인할 변수

            // 현재 문서보다 우선순위가 더 높은 문서가 있는지 확인
            for (int[] item : queue) {
                if (item[1] > current[1]) { // 더 높은 우선순위 발견
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                // 뒤에 더 높은 우선순위의 문서가 있다면, 현재 문서를 큐의 맨 뒤로 보냄
                queue.offer(current);
            } else {
                // 현재 문서를 인쇄 (실제로 처리한 문서로 간주)
                answer++;

                // 방금 인쇄한 문서가 처음에 우리가 요청한 문서인지 확인
                if (current[0] == location) {
                    // 요청한 문서가 인쇄된 순서를 반환
                    return answer;
                }
            }
        }

        // 이론상 이 return문은 실행되지 않지만, 문법적으로 필요함
        return answer;
    }
}
