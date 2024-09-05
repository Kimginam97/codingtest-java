package org.example;

import java.util.Arrays;
import java.util.HashSet;

// 3번 두개 뽑아서 더하기
public class Main03 {
    public static void main(String[] args){
        System.out.println(Arrays.toString( solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString( solution(new int[]{5,0,2,7})));
    }

    public static int[] solution(int[] numbers){
        HashSet<Integer> set = new HashSet<>(); // 중복값 제거를 위한 해시셋 생성

        // 두 수를 선택하는 모든 경우의 수를 반복문으로 구현
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){
                // 두 수를 더한 결과를 해시셋에 추가
                set.add(numbers[i]+numbers[j]);
            }
        }

        // 해시셋의 값을 오름차순 정렬하고 int[] 형태의 배열로 변환하여 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}