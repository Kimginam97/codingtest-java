package org.example.b;

import java.util.Stack;

// 13. 크레인 인형 뽑기 게임
public class Main13 {
    public int solution(int[][] board, int[] moves){
        // 1. 각 열에 대한 스택을 생성한다
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++){
            lanes[i] = new Stack<>();
        }

        // 2. board를 역순으로 탐색하며, 각 열의 인형을 lanes에 추가한다
        for(int i = board.length - 1; i >= 0; i--){
            for(int j = 0; j < board[j].length; j++){
                if(board[i][j] > 0){
                    lanes[j].push(board[i][j]);
                }
            }
        }

        // 3. 인형을 담음 bucket 생성
        Stack<Integer> bucket = new Stack<>();
        // 4. 사라진 인형의 총 개수를 저장할 변수를 초기화
        int answer = 0;

        // 5. moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가
        for(int move: moves){
            if(!lanes[move-1].isEmpty()){ // 해당 열에 인형이 있는 경우
                int doll = lanes[move-1].pop();
                // 6. 바구니에 인형이 있고, 가장 위에 있는 인형과 같은경우
                if(!bucket.isEmpty() && bucket.peek() == doll){
                    bucket.pop();
                    answer += 2;
                }else{ // 7.바구니에 인형이 없거나, 가장 위에 있는 인형과 다른경우
                    bucket.push(doll);
                }
            }
        }
        return answer;
    }
}
