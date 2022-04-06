/*
package com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

public class Problem1232 {

    // Node 객체리스트 전역변수 생성
    static ArrayList<Node> nodeList = new ArrayList<Node>();

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1232.txt")
        );

        for (int test = 1; test <= 10; test++) {
            ArrayList<String> inputArrayList = new ArrayList<>();
            int keyCount = Integer.parseInt(bufferedReader.readLine());
            for (int i = 1; i <= keyCount; i++) {
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

            // 온라인 제출용
            */
/*Scanner scanner = new Scanner(System.in);
            for (int test = 1; test <= 10; test++) {
                ArrayList<String> inputArrayList = new ArrayList<>();
                int keyCount = Integer.parseInt(scanner.nextLine());
                for (int i = 1; i <= keyCount; i++) {
                    inputArrayList.add(scanner.nextLine());
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
                }*//*


            // 사칙연산
            int answer = (int) nodeCheck(1);

            // 정답 출력
            System.out.println("#" + test + " " + answer);

            // inpput 배열리스트, 정답 초기화
            inputArrayList.clear();
            nodeList.clear();
        }
    }

    public static double nodeCheck(int key) {
        Node currentNode = nodeList.get(key - 1);
        String currentValue = currentNode.getValue();
        double leftValue = 0.0;
        double rightValue = 0.0;

        switch (currentValue) {
            case "+":
                leftValue = nodeCheck(currentNode.getLeftNode());
                rightValue = nodeCheck(currentNode.getRightNode());
                return (leftValue + rightValue);
            case "-":
                leftValue = nodeCheck(currentNode.getLeftNode());
                rightValue = nodeCheck(currentNode.getRightNode());
                return (leftValue - rightValue);
            case "*":
                leftValue = nodeCheck(currentNode.getLeftNode());
                rightValue = nodeCheck(currentNode.getRightNode());
                return (leftValue * rightValue);
            case "/":
                leftValue = nodeCheck(currentNode.getLeftNode());
                rightValue = nodeCheck(currentNode.getRightNode());
                return (leftValue / rightValue);
            default:
                return Double.parseDouble(currentValue);
        }
    }
}
*/
