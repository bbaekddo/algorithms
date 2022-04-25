package com.SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1247 {

    // 최단거리 저장 변수
    static int shortestWay;

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1247.txt")
        );

        /*
        // 온라인 제출용
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        */

        // testCase 입력
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            // 고객 수
            int totalCustomer = Integer.parseInt(bufferedReader.readLine());

            // 좌표 위치 배열 생성
            int[][] locations = new int[totalCustomer + 2][2];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            // 회사, 집, 고객 순서대로 좌표 저장
            for (int j = 0; j < (totalCustomer + 2); j++) {
                locations[j][0] = Integer.parseInt(stringTokenizer.nextToken());
                locations[j][1] = Integer.parseInt(stringTokenizer.nextToken());
            }

            shortestWay = 100000;
            getDistance(locations, (totalCustomer + 2), 0, 0, 0);

            // 결과 출력
            System.out.println("#" + (i + 1) + shortestWay);
        }
    }

    public static void getDistance(int[][] locations, int totalLocation, int index, int level, int distance) {
        // 도착지점에 도달하면 탐색 종료
        if (level >= (totalLocation - 1) && distance < shortestWay) {
            shortestWay = distance;
            return;
        }

        for (int i = 0; i < ((totalLocation - 2) - level); i++) {
            // 이미 탐색한 곳은 패스
            if (locations[index][0] != -1) {
                int nextDistance = Math.abs(locations[index + i][0] - locations[index][0]) + Math.abs(locations[index + i][1] - locations[index][1]);
                distance += nextDistance;

                // 현재 최단거리보다 계산 경로가 크면 탐색 종료
                if (distance > shortestWay) {
                    return;
                } else {
                    locations[index][0] = -1;
                    locations[index][1] = -1;

                    getDistance(locations, totalLocation, (index + i), (level - 1), distance);
                }
            }
        }
    }
}