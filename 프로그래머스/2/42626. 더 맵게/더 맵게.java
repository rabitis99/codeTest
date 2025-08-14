import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int mixCount = 0; // 섞은 횟수 저장

        // 최소 힙 생성: 가장 맵지 않은 음식부터 꺼낼 수 있도록
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 모든 음식의 스코빌 지수를 힙에 추가
        for (int spiciness : scoville) {
            minHeap.add(spiciness);
        }

        // 가장 맵지 않은 음식의 스코빌 지수가 목표 K 이상이 될 때까지 반복
        while (minHeap.peek() < K) {
            // 힙에서 가장 맵지 않은 음식 꺼내기
            int leastSpicy = minHeap.poll();

            // 두 번째로 맵지 않은 음식이 없다면 더 이상 섞을 수 없음
            if (minHeap.isEmpty()) {
                return -1; // 목표 달성 불가
            }

            int secondLeastSpicy = minHeap.poll(); // 두 번째로 맵지 않은 음식 꺼내기

            // 두 음식을 섞어 새로운 음식 만들기
            // 공식: 새로운 스코빌 = 가장 맵지 않은 음식 + 2 * 두 번째로 맵지 않은 음식
            int mixedSpiciness = leastSpicy + 2 * secondLeastSpicy;

            // 새로 만든 음식 힙에 추가
            minHeap.add(mixedSpiciness);

            // 섞은 횟수 증가
            mixCount++;
        }

        // 목표 스코빌 지수 이상이 되었을 때 섞은 횟수 반환
        return mixCount;
    }
}
