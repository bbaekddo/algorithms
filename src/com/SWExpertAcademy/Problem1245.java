package com.SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1245 {

    // 이진탐색 횟수
    static int searchCount;

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1245.txt")
        );

        /*
        // 온라인 제출용
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        */

        // testCase 입력
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            // 자성체 개수 저장
            int magneticMaterialCount = Integer.parseInt(bufferedReader.readLine());

            // 자성체 데이터 문자열 토큰화
            double[][] magneticMaterials = new double[magneticMaterialCount][2];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            // 자성체 x좌표 저장
            for (int j = 0; j < magneticMaterialCount; j++) {
                magneticMaterials[j][0] = Integer.parseInt(stringTokenizer.nextToken());
            }
            // 자성체 무게 저장
            for (int j = 0; j < magneticMaterialCount; j++) {
                magneticMaterials[j][1] = Integer.parseInt(stringTokenizer.nextToken());
            }

            // 결과 출력
            System.out.print("#" + (i + 1));
            for (int j = 0; j < (magneticMaterialCount - 1); j++) {
                // 이진탐색 회수 초기화
                searchCount = 100;

                double midPoint = (magneticMaterials[j][0] + magneticMaterials[j + 1][0]) / 2.0;
                double leftPoint = magneticMaterials[j][0];
                double rightPoint = magneticMaterials[j + 1][0];
                System.out.print(" " + String.format("%.10f", getMidPoint(magneticMaterials, j, midPoint, leftPoint, rightPoint)));
            }
            System.out.println();
        }
    }

    // 이진탐색 재귀함수
    public static double getMidPoint(double[][] materials, int index, double mid, double left, double right) {
        // 탐색 회수가 100회 이상일 경우 정지
        if (searchCount <= 0) {
            return mid;
        }

        // 왼쪽, 오른쪽 중력값 비교
        double leftGravity = getLeftGravity(materials, index, mid);
        double rightGravity = getRightGravity(materials, (index + 1), mid);
        double checkDistance = leftGravity - rightGravity;

        // 이진탐색 회수 감소
        searchCount--;

        // 중력값 비교에 따른 재귀함수 호출
        if (checkDistance < 0) {
            double newMidPoint = (left + mid) / 2.0;
            return getMidPoint(materials, index, newMidPoint, left, mid);
        } else if (checkDistance > 0){
            double newMidPoint = (mid + right) / 2.0;
            return getMidPoint(materials, index, newMidPoint, mid, right);
        } else {
            return mid;
        }
    }

    // 왼쪽 중력값 산출 함수
    public static double getLeftGravity(double[][] materials, int index, double mid) {
        if (index < 0) {
            return 0;
        }

        double gravity = materials[index][1] / ((mid - materials[index][0]) * (mid - materials[index][0]));
        return (gravity + getLeftGravity(materials, (index - 1), mid));
    }

    // 오른쪽 중력값 산출 함수
    public static double getRightGravity(double[][] materials, int index, double mid) {
        if (index >= materials.length) {
            return 0;
        }

        double gravity = materials[index][1] / ((mid - materials[index][0]) * (mid - materials[index][0]));
        return (gravity + getRightGravity(materials, (index + 1), mid));
    }
}