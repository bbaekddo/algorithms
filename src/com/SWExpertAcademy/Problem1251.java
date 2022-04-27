package com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정점 클래스 정의
class Vertex {
    private final int x;
    private final int y;
    private boolean check = false;

    // 생성자
    Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // setter
    public void setCheck(boolean check) {
        this.check = check;
    }

    // getter
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getCheck() {
        return this.check;
    }
}

public class Problem1251 {

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1251.txt")
        );

        /*
        // 온라인 제출용
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        */

        // testCase 입력
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            // 섬의 총 개수
            int N = Integer.parseInt(bufferedReader.readLine());
            Vertex[] vertices = new Vertex[N];

            // 정점 배열 생성
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                Vertex vertex = new Vertex(Integer.parseInt(stringTokenizer1.nextToken()), Integer.parseInt(stringTokenizer2.nextToken()));
                vertices[j] = vertex;
            }

            // 환경 부담 세율
            double E = Double.parseDouble(bufferedReader.readLine());

            // 거리 가중치 집합
            long[] D = new long[N];
            Arrays.fill(D, Long.MAX_VALUE);

            // 탐색 시작
            vertices[0].setCheck(true);
            D[0] = 0;
            int index = 0;
            int checkCount = 0;
            while (checkCount < N) {
                int tempIndex = index;
                // 가중치 합이 최소인 인덱스 탐색
                long min = Long.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (!vertices[j].getCheck()) {
                        long xSqrt = (long) (vertices[j].getX() - vertices[index].getX()) * (vertices[j].getX() - vertices[index].getX());
                        long ySqrt = (long) (vertices[j].getY() - vertices[index].getY()) * (vertices[j].getY() - vertices[index].getY());
                        long tempDistance = xSqrt + ySqrt;

                        if (tempDistance < D[j]) {
                            D[j] = tempDistance;
                        }
                    }

                    if (min > D[j]) {
                        min = D[j];
                        index = j;
                    }
                }

                // 현재 정점 완료 처리
                vertices[tempIndex].setCheck(true);
                checkCount++;
            }

            long totalDistance = 0L;
            for (int j = 0; j < N; j++) {
                totalDistance += D[j];
            }

            double totalFee = Math.round(E * totalDistance);

            // 결과 출력
            System.out.println("#" + (i + 1) + " " + totalFee);
        }
    }
}
