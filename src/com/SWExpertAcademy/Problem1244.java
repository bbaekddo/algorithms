package com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Problem1244 {

    static int[] numbers;
    static int exchangeCount;

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1244.txt")
        );

        /*
        // 온라인 제출용
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        */

        // testCase 입력
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            // 숫자판 저장
            String tempNumber = stringTokenizer.nextToken();
            numbers = new int[tempNumber.length()];
            for (int j = 0; j < tempNumber.length(); j++) {
                numbers[j] = tempNumber.charAt(j) - '0';
            }

            // 교환 횟수 저장
            exchangeCount = Integer.parseInt(stringTokenizer.nextToken());

            getExchange(0);

            // 결과 출력
            int sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                sum += (numbers[numbers.length - (j + 1)] * Math.pow(10, j));
            }
            System.out.println("#" + (i + 1) + " " + sum);
        }
    }

    public static void getExchange(int index) {
        if (exchangeCount > 0) {
            // 숫자판 중 가장 큰 수와 위치 구하기
            int maxNumber = 0;
            int maxNumberIndex = index;
            for (int i = index; i < numbers.length; i++) {
                if (maxNumber <= numbers[i]) {
                    maxNumber = numbers[i];
                    maxNumberIndex = i;
                }
            }

            // 현재 가장 왼쪽의 수가 가장 클 경우
            if (maxNumberIndex == index) {
                getExchange(maxNumberIndex + 1);
                // 가장 큰 수와 제인 왼쪽의 수 교환
            } else {
                int tempExchange = numbers[index];
                numbers[index] = maxNumber;
                numbers[maxNumberIndex] = tempExchange;

                exchangeCount--;

                getExchange(index + 1);
            }
        }
    }
}