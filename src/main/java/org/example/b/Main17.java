package org.example.b;

import java.util.ArrayDeque;
import java.util.Arrays;

// 17. 카트뭉치
public class Main17 {
    public String solution(String[] cards1, String[] cards2, String[] goal){
        // cards의 goal을 deque로 변환
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        // 1. goalDeque에 문자열이 남아 있으면 계속 반복
        while(!goalDeque.isEmpty()){
            // 2. cardsDeque1의 front와 일치하는 경우
            if(!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(goalDeque.peekFirst())){
                cardsDeque1.pollFirst();
                goalDeque.pollFirst();
            }
            // 3. cardsDeque2의 front와 일치하는 경우
            else if(!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(goalDeque.peekFirst())){
                cardsDeque2.pollFirst();
                goalDeque.pollFirst();
            }
            else{
                break; // 일치하는 원소를 찾지 못했으므로 종료
            }
        }
        //
        return goalDeque.isEmpty() ? "Yes" : "No";
    }
}
