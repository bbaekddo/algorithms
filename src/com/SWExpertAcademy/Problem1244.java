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

            // 숫자판 교환 시작
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
        // 교환 회수가 0 이상일 때만 함수 실행
        if (exchangeCount > 0) {
            // index가 마지막 숫자일 때
            if (index == (numbers.length - 1)) {
                // 중복 숫자가 있으면 함수 종료
                for (int i = 0; i < (numbers.length - 1); i++) {
                    for (int j = 1; j < numbers.length; j++) {
                        if (numbers[i] == numbers[j]) {
                            exchangeCount = 0;
                            return;
                        }
                    }
                }

                // 중복 숫자가 없으면 1의 자리와 10의 자리 교환
                int tempExchange = numbers[index];
                numbers[index] = numbers[index - 1];
                numbers[index - 1] = tempExchange;

                exchangeCount--;

                getExchange(index);
            // index가 마지막 숫자가 아닐 때
            } else {

                // 현재값이 들어갈 위치 판단
                int countIndex = -1;
                for (int number : numbers) { // 자기 자리 찾음
                    if (number >= numbers[index]) {
                        countIndex++;
                    }
                }

                // 숫자판 중 가장 큰 수와 위치 구하기
                int maxNumber = 0;
                int maxNumberIndex = 0;
                for (int i = index; i < numbers.length; i++) {
                    if (maxNumber < numbers[i]) {
                        maxNumber = numbers[i];
                        maxNumberIndex = i;
                    } else if (maxNumber == numbers[i]) {
                        if (i <= countIndex) {
                            maxNumberIndex = i;
                        }
                    }
                }

                // 현재 가장 왼쪽의 수가 가장 클 경우
                if (maxNumber == numbers[index]) {
                    getExchange(index + 1);
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
}