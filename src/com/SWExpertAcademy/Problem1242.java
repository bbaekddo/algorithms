/*
package com.SWExpertAcademy;

import java.io.*;
import java.util.ArrayList;

public class Problem1242 {
    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1242.txt")
        );

        // testCase 입력
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] NMInputs = bufferedReader.readLine().split("\\s");
            int N = Integer.parseInt(NMInputs[0]);
            int M = Integer.parseInt(NMInputs[1]);
            ArrayList<String> binaryArray = new ArrayList<>();

            // 16진수 암호코드를 2진수로 변환
            StringBuilder tempLine = new StringBuilder();
            for (int j = 0; j < N; j++) {
                String inputLine = bufferedReader.readLine();

                for (int k = 0; k < M; k++) {
                    char hex = inputLine.charAt(k);
                    tempLine.append(getBinary(hex));
                }
                binaryArray.add(tempLine.toString());
                // StringBuilder 객체 초기화
                tempLine.setLength(0);
            }

            // 암호코드 디코딩
            for (int j = 0; j < N; j++) {
                int x, y, z;
                for (int k = ((4 * M) - 1); k >= 0; k--) {
                    if (binaryArray.get(j).charAt(k) == '1') {

                    }
                }
            }



            // ArrayList 객체 초기화
            binaryArray.clear();
        }

        */
/*
        // 온라인 제출용
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        *//*




    }

    public static String getBinary(char hex) {
        return switch (hex) {
            case '0' -> "0000";
            case '1' -> "0001";
            case '2' -> "0010";
            case '3' -> "0011";
            case '4' -> "0100";
            case '5' -> "0101";
            case '6' -> "0110";
            case '7' -> "0111";
            case '8' -> "1000";
            case '9' -> "1001";
            case 'A' -> "1010";
            case 'B' -> "1011";
            case 'C' -> "1100";
            case 'D' -> "1101";
            case 'E' -> "1110";
            case 'F' -> "1111";
            default -> "xxxx";
        };
    }

}
*/
