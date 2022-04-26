package com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem1249 {

    // 최단 거리 변수 생성
    static int shortestDistance;

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1249.txt")
        );

        /*
        // 온라인 제출용
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        */

        // testCase 입력
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            int mapSize = Integer.parseInt(bufferedReader.readLine());
            int[][] map = new int[mapSize][mapSize];

            // map 정보 생성
            for (int j = 0; j < mapSize; j++) {
                String mapInput = bufferedReader.readLine();

                for (int k = 0; k < mapSize; k++) {
                    map[j][k] = mapInput.charAt(k) - '0';
                }
            }

            shortestDistance = 10000;
            getShortWay(map, 0, 0, 0);

            // 결과 출력
            System.out.println("#" + (i + 1) + " " + shortestDistance);
        }
    }

    public static void getShortWay(int[][] map, int x, int y, int distance) {
        // 목표지점 도달시 반환
        if (x == (map[0].length - 1) && y == (map[0].length - 1)) {
            if (distance <= shortestDistance) {
                shortestDistance = distance;
            }
            return;
        } else if (distance > shortestDistance) {
            return;
        }

        int[] temps = new int[4];
        temps[0] = 10000; temps[1] = 10000; temps[2] = 10000; temps[3] = 10000;
        if ((x - 1) > 0) {
            temps[0] = map[x - 1][y];
        }
        if ((x + 1) < map.length) {
            temps[1] = map[x + 1][y];
        }
        if ((y - 1) > 0) {
            temps[2] = map[x][y - 1];
        }
        if ((y + 1) < map.length) {
            temps[3] = map[x][y + 1];
        }

        for (int i = 3; i > 0; i--) {
            if (temps[i] != 10000) {
                distance += map[x][y];
                int tempValue = map[x][y];
                map[x][y] = 10000;

                switch (i) {
                    case 0 -> getShortWay(map, (x - 1), y, distance);
                    case 1 -> getShortWay(map, (x + 1), y, distance);
                    case 2 -> getShortWay(map, x, (y - 1), distance);
                    case 3 -> getShortWay(map, x, (y + 1), distance);
                }

                distance -= tempValue;
                map[x][y] = tempValue;
            }
        }
    }
}