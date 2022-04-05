/*
package com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Node {
    private int key;
    private String value;
    private int leftNode = 0;
    private int rightNode = 0;

    // Setter
    void setKey(int key) {
        this.key = key;
    }
    void setValue(String value) {
        this.value = value;
    }
    void setLeftNode(int leftNode) {
        this.leftNode = leftNode;
    }
    void setRightNode(int rightNode) {
        this.rightNode = rightNode;
    }

    // Getter
    int getKey() {
        return this.key;
    }
    String getValue() {
        return this.value;
    }
    int getLeftNode() {
        return this.leftNode;
    }
    int getRightNode() {
        return this.rightNode;
    }

    // Boolean Check
    boolean isLeftNode() {
        return leftNode != 0;
    }
    boolean isRightNode() {
        return rightNode != 0;
    }
}

public class Problem1233 {

    // Node 객체리스트 전역변수 선언
    static ArrayList<Node> nodeList = new ArrayList<Node>();
    // 정답 전역변수 선언
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1233.txt")
        );

        for (int test = 1; test <= 10; test++) {
            ArrayList<String> inputArrayList = new ArrayList<>();
            String tempInput = "";
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 1; i <= n; i++) {
                inputArrayList.add(bufferedReader.readLine());
            }

            // input 대입
            for (String temp : inputArrayList) {
                String[] nodeInput = temp.split("\\s");

                Node node = new Node();
                node.setKey(Integer.parseInt(nodeInput[0]));
                node.setValue(nodeInput[1]);
                if (nodeInput.length >= 3) {
                    node.setLeftNode(Integer.parseInt(nodeInput[2]));
                }
                if (nodeInput.length >= 4) {
                    node.setRightNode(Integer.parseInt(nodeInput[3]));
                }
                nodeList.add(node);
            }

            // 사칙연산 유효성 검사
            nodeCheck(1);

            // 정답 출력
            System.out.println("#" + test + " " + answer);

            // inpput 배열리스트, 정답 초기화
            inputArrayList.clear();
            nodeList.clear();
            answer = 1;
        }
    }

    public static void nodeCheck(int key) {
        Node currentNode = nodeList.get(key - 1);

        // 두 개의 자식 노드가 있을 때 Value가 숫자인 경우 정답 0
        if (currentNode.isLeftNode() && currentNode.isRightNode()) {
            char c = currentNode.getValue().charAt(0);

            if (c != '+' && c != '-' && c != '*' && c != '/') {
                answer = 0;
            }
        // 한 개의 자식 노드만 있으면 정답 0
        } else if (currentNode.isLeftNode() && !currentNode.isRightNode()) {
            answer = 0;
        } else if (currentNode.isRightNode() && !currentNode.isLeftNode()) {
            answer = 0;
        // 리프 노드일 때 Value가 문자인 경우 정답 0
        } else {
            char c = currentNode.getValue().charAt(0);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                answer = 0;
            }
        }

        // Left Node가 있으면 재귀함수 호출
        if (currentNode.isLeftNode()) {
            nodeCheck(currentNode.getLeftNode());
        }

        // Right Node가 있으면 재귀함수 호출
        if (currentNode.isRightNode()) {
            nodeCheck(currentNode.getRightNode());
        }
    }
}
*/
