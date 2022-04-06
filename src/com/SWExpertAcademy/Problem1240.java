package com.SWExpertAcademy;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1240 {

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1240.txt")
        );

        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int test = 1; test <= testCase; test++) {
            // 입력 배열 저장할 배열 리스트 선언
            ArrayList<String> inputStrings = new ArrayList<>();
            // 배열의 세로, 가로 길이 저장
            String[] nbym = bufferedReader.readLine().split("\\s");
            int height = Integer.parseInt(nbym[0]);
            int width = Integer.parseInt(nbym[1]);

            // 테스트 케이스 배열 저장 후 '1'이 있는 인덱스 저장
            int indexN = 0;
            int indexM = 0;
            String tempInput = "";
            for (int i = 0; i < height; i++) {
                tempInput = bufferedReader.readLine();
                inputStrings.add(tempInput);
                if (tempInput.matches("(.*)1(.*)") && indexN == 0 && indexM == 0) {
                    indexN = i;
                    indexM = tempInput.indexOf("1");
                }
            }

            // 한 줄의 코드 길이 내 불필요한 '0'의 개수
            String secretCodeString = inputStrings.get(indexN);
            int unneccessaryZeros = width - 56;

            for (int i = 0; i < unneccessaryZeros; i++) {
                if (secretCodeString.charAt(secretCodeString.length() - 1) == '0') {
                    secretCodeString = secretCodeString.substring(0, secretCodeString.length() - 1);
                } else {
                    if (secretCodeString.charAt(0) == '0') {
                        secretCodeString = secretCodeString.substring(1);
                    }
                }
            }

            int[] codeArray = new int[8];
            for (int i = 0; i < 8; i++) {
                codeArray[i] = getCode(secretCodeString.substring((i * 7), ((i * 7) + 6)));
            }
            // 암호 홀수, 짝수 총합 계산
            int sum = 0;
            for (int i : codeArray) {
                if ((i % 2) == 0) {
                    sum += i;
                } else {
                    sum += i * 3;
                }
            }

            // 암호 검증, 맞을 시 총합 계산
            int answer = 0;
            if (sum % 10 == 0) {
                for (int i : codeArray) {
                    answer += i;
                }
            }

            System.out.println("#" + test + " " + answer);
            /*// 온라인 제출용
            Scanner scanner = new Scanner(System.in);
            for (int test = 1; test <= testCase; test++) {
                ArrayList<String> inputArrayList = new ArrayList<>();
                int keyCount = Integer.parseInt(scanner.nextLine());
                for (int i = 1; i <= keyCount; i++) {
                    inputArrayList.add(scanner.nextLine());
                }
            }*/

            inputStrings.clear();
        }
    }

    public static int getCode(String codeString) {
        // 1번째 자리가 0인 경우 => 0, 9, 1, 2
        if (codeString.charAt(1) == '0') {
            if (codeString.charAt(2) == '0') {
                // 0 0 1 0
                if (codeString.charAt(4) == '0') {
                    return 9;
                // 0 0 1 1
                } else {
                    return 0;
                }
            } else {
                // 0 1 0
                if (codeString.charAt(3) == '0') {
                    return 2;
                // 0 1 1
                } else {
                    return 1;
                }
            }
        } else {
            if (codeString.charAt(2) == '0') {
                // 1 0 0
                if (codeString.charAt(3) == '0') {
                    return 4;
                // 1 0 1
                } else {
                    return 6;
                }
            } else {
                if (codeString.charAt(3) == '0') {
                    // 1 1 0 0
                    if (codeString.charAt(4) == '0') {
                        return 5;
                    // 1 1 0 1
                    } else {
                        return 8;
                    }
                } else {
                    // 1 1 1 0
                    if (codeString.charAt(4) == '0') {
                        return 7;
                    // 1 1 1 1
                    } else {
                        return 3;
                    }
                }
            }
        }
    }
}