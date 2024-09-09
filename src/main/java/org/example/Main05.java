package org.example;

// 5번 행렬의곱셉
public class Main05 {
    public int[][] solution(int[][] arr1, int[][] arr2){
        // 행렬 arr1 과 arr2 의 행과 열의 수
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // 결과를 저장할 2차원 배열 초기화
        int[][] answer = new int[r1][r2];

        // 첫번째 행렬 arr1의 각 행과 두 번째 행렬 arr2의 각 열에 대해
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                for(int k = 0; k < c1; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
