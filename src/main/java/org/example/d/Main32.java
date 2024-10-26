package org.example.d;

import java.util.HashSet;

// 32. 영어 끝말잇기
public class Main32 {
    public int[] solution(int n, String[] words){
        // 1. 이미 사용한 단어를 저장하는 set
        HashSet<String> usedWords = new HashSet<>();

        // 2. 이전 단어의 마지막 글자, 최초 상태는 첫 번째 사람이 말하는 첫 번째 글자로 초기화
        char preWord = words[0].charAt(0);

        for(int i = 0; i < words.length; i++){
            // 3. 이미 사용한 단어이거나 첫 글자가 이전 단어와 일치하지 않으면
            if(usedWords.contains(words[i]) || words[i].charAt(0) != preWord){
                // 4. 탈락하는 사람의 번호와 차례를 반환
                return new int[]{(i%n)+1, (i/n) + 1};
            }
            // 5. 사용한 단어로 추가
            usedWords.add(words[i]);
            // 6. 이전 단어의 마지막 글자 업데이트
            preWord = words[i].charAt(words[i].length()-1);
        }
        // 7. 모두 통과했을 경우 반환 값
        return new int[]{0,0};
    }
}
