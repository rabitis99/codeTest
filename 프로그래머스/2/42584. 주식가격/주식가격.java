import java.util.*;

class Solution {

    /**
     * 각 시점의 가격이 이후에 처음으로 떨어질 때까지 걸린 "초(혹은 틱)" 수를 구한다.
     *
     * 예) prices = [1, 2, 3, 2, 3]
     *  - index 0 (가격 1): 끝까지 1보다 작은 값이 나타나지 않으므로 4초 유지 -> answer[0] = 4
     *  - index 1 (가격 2): 끝까지 2보다 작은 값이 마지막에만 있으므로 3초 유지 -> answer[1] = 3
     *  - index 2 (가격 3): 다음 시점(index 3)에서 2로 하락 -> 1초 유지 -> answer[2] = 1
     *  - index 3 (가격 2): 끝까지 하락 없음 -> 1초 유지 -> answer[3] = 1
     *  - index 4 (가격 3): 이후 데이터 없음 -> 0초 유지 -> answer[4] = 0
     *
     * 알고리즘: 모노톤(내림차순을 깨면 처리) 스택.
     * 스택에는 "아직 하락 시점을 만나지 못한 인덱스"를 저장한다.
     * 새 가격이 들어왔을 때, 스택의 꼭대기 인덱스의 가격보다 작다면
     * 그 인덱스의 하락 시점이 현재 시점이므로 정답을 채우고 pop 한다.
     *
     * 시간복잡도: O(n) — 각 인덱스가 최대 한 번 push, 한 번 pop
     * 공간복잡도: O(n) — 스택과 결과 배열
     */
    public int[] solution(int[] prices) {
        // 정답 배열: answer[i] = i 시점의 가격이 '처음으로 떨어질 때'까지 걸린 시간(틱/초)
        int[] answer = new int[prices.length];

        // 인덱스를 저장하는 스택 (값이 아니라 '인덱스'를 저장해야 기간 계산이 쉬움)
        Stack<Integer> stack = new Stack<>();

        // i: 현재 시점(인덱스)
        for (int i = 0; i < prices.length; i++) {

            // 현재 가격이 스택 꼭대기 인덱스의 가격보다 '작다'면,
            // 스택에 쌓여 있던 그 인덱스의 가격이 "처음으로 떨어지는 순간"을 만난 것.
            // 이때 해당 인덱스의 지속 시간을 계산하고 answer에 기록한다.
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {

                // 하락이 확정된 인덱스(과거 시점)
                int topIndex = stack.peek();

                // 지속 시간 = (현재 시점 i) - (과거 시점 topIndex)
                //  i 에서 가격이 처음 떨어졌으므로 그 사이의 경과 시간
                answer[topIndex] = i - topIndex;

                // 처리 끝났으니 스택에서 제거
                stack.pop();
            }

            // 현재 시점 i는 아직 하락 시점을 만나지 못했으므로 스택에 보류
            // (이후 더 낮은 가격을 만나면 위 while에서 처리될 것)
            stack.push(i);
        }

        // 순회를 다 돌고 나면, 스택에 남아있는 인덱스들은
        // "끝까지 가격이 떨어지지 않은" 시점들이다.
        // 이 경우 지속 시간은 "끝까지 남은 길이"가 된다.
        while (!stack.isEmpty()) {
            int topIndex = stack.peek();

            // 남은 시간 = (마지막 인덱스 = prices.length - 1) - topIndex
            // = prices.length - topIndex - 1
            answer[topIndex] = prices.length - topIndex - 1;

            stack.pop();
        }

        return answer;
    }
}
