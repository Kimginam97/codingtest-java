package org.example.c;

// 26. 예상 대진표
public class Main26 {
    public int solution(int n, int a, int b){
        int answer;

        for(answer = 0; a != b; answer++){
            a = (a+1) / 2;
            b = (b+1) / 2;
        }

        return answer;
    }
}
