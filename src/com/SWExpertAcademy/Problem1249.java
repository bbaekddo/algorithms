/*
package com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class TempWay implements Comparable<TempWay> {
    private final int x;
    private final int y;
    private final int repairTime;

    TempWay(int x, int y, int repairTime) {
        this.x = x;
        this.y = y;
        this.repairTime = repairTime;
    }

    // getter
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getRepairTime() {
        return this.repairTime;
    }

    // compare 대상
    @Override
    public int compareTo(TempWay tempWay) {
        return this.repairTime - tempWay.repairTime;
    }
}
public class Problem1249 {

    // 최단 거리 변수 생성
    static int shortestDistance;

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1249.txt")
        );

        */
/*
        // 온라인 제출용
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        *//*


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

        // 우선순위 큐 적용

    }
}*/
