package org.example.a;

import java.util.Arrays;

// 1번 배열 정렬하기
public class Main01 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[]{1,-5,2,4,3})));
//        System.out.println(Arrays.toString(solution(new int[]{2,1,1,3,2,5,4})));
//        System.out.println(Arrays.toString(solution(new int[]{6,1,7})));

        int[] arr = new int[100000];
        long start = System.currentTimeMillis();
        int[] bubble = bubleSort(arr);
        long end = System.currentTimeMillis();
        // Buble 정렬 코드 시간 측정
        System.out.println((end-start) / 1000.0 + "초");

        start = System.currentTimeMillis();
        int[] sort = solution(arr);
        end = System.currentTimeMillis();
        // 정렬 API 코드 시간 측정
        System.out.println((end-start) / 1000.0 + "초");

        // 두 개의 배열이 같은지 확인
        System.out.println(Arrays.equals(bubble, sort));

    }

    // 정렬 api
    private static int[] solution(int[] arr){
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }

    // 버블정렬
    private static int[] bubleSort(int[] org){
        int[] arr = org.clone();
        int n = arr.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }
}
