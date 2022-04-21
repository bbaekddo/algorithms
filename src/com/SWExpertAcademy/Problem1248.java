package com.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 이진 트리의 노드 클래스 생성
class Node {
    private int key;
    private int leftNode = 0;
    private int rightNode = 0;

    // getter
    public int getKey() {
        return this.key;
    }

    public int getLeftNode(){
        return this.leftNode;
    }

    public int getRightNode() {
        return this.rightNode;
    }

    // setter
    public void setKey(int key) {
        this.key = key;
    }

    public void setLeftNode(int leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(int rightNode) {
        this.rightNode = rightNode;
    }
}

// 부모 노드의 정점과 거리를 간선 거리를 가진 클래스 생성
class RootNode {
    private int key;
    private int distance;

    // getter
    public int getKey() {
        return this.key;
    }
    public int getDistance() {
        return this.distance;
    }

    // setter
    public void setKey(int key) {
        this.key = key;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
}

public class Problem1248 {

    // 목표 노드의 부모 정점 리스트
    static ArrayList<RootNode> rootNodeList1 = new ArrayList<>();
    static ArrayList<RootNode> rootNodeList2 = new ArrayList<>();
    static ArrayList<RootNode> commonRootNodeList = new ArrayList<>();
    static int totalSubTree;

    public static void main(String[] args) throws IOException {
        // test input 파일 읽어오기
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("/Users/dohyeonsmac/Desktop/Programming/Algorithms/testInput/problem1248.txt")
        );

        /*
        // 온라인 제출용
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        */

        // testCase 입력
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());

            // 정점 개수, 간선 개수, 목표 정점 1, 2 정의
            int totalNode = Integer.parseInt(stringTokenizer1.nextToken());
            int totalLine = Integer.parseInt(stringTokenizer1.nextToken());
            int targetNode1 = Integer.parseInt(stringTokenizer1.nextToken());
            int targetNode2 = Integer.parseInt(stringTokenizer1.nextToken());

            // Node 객체배열 생성
            Node[] nodes = new Node[totalNode];
            for (int j = 0; j < nodes.length; j++) {
                Node node = new Node();

                node.setKey(j + 1);
                nodes[j] = node;
            }

            // 각 정점 연결
            for (int j = 0; j < totalLine; j++) {
                int rootNode = Integer.parseInt(stringTokenizer2.nextToken());
                int childNode = Integer.parseInt(stringTokenizer2.nextToken());

                // 한 노드에 자식 노드가 없을 경우와 있을 경우
                if (nodes[rootNode - 1].getLeftNode() == 0 ) {
                    nodes[rootNode - 1].setLeftNode(childNode);
                } else {
                    nodes[rootNode - 1].setRightNode(childNode);
                }
            }

            // 공통 조상 찾기
            totalSubTree = 0;
            setRootNode1(nodes, targetNode1, 0);
            setRootNode2(nodes, targetNode2, 0);
            setCommonRootNode(rootNodeList1, rootNodeList2);

            // 최근접 공통 조상의 서브 트리 개수 구하기
            int minNodeDistance = 10000;
            int minNodeKey = 0;
            for (RootNode rootNode : commonRootNodeList) {
                if (rootNode.getDistance() < minNodeDistance) {
                    minNodeDistance = rootNode.getDistance();
                    minNodeKey = rootNode.getKey();
                }
            }
            getTotalSubTree(nodes, minNodeKey);

            // 결과 출력
            System.out.println("#" + (i + 1) + " " + minNodeKey + " " + totalSubTree);

            // static 변수 초기화
            rootNodeList1.clear();
            rootNodeList2.clear();
            commonRootNodeList.clear();
        }
    }

    public static void setRootNode1(Node[] nodes, int targetNode, int distance) {
        RootNode rootNode = new RootNode();
        // 현재 노드의 키가 1일 경우 종료
        if (nodes[targetNode - 1].getKey() == 1) {
            rootNode.setKey(1);
            rootNode.setDistance(distance);

            rootNodeList1.add(rootNode);
        // 목표 노드의 부모 노드를 배열리스트에 저장
        } else {
            int rootNodeKey = 0;

            try {
                for (Node node : nodes) {
                    if (node.getLeftNode() == targetNode || node.getRightNode() == targetNode) {
                        rootNodeKey = node.getKey();
                        break;
                    }
                }
            } catch (Exception error) {
                System.out.println("Find root node1 error occurred!");
            }

            rootNode.setKey(rootNodeKey);
            rootNode.setDistance(distance + 1);

            rootNodeList1.add(rootNode);
            setRootNode1(nodes, rootNodeKey, distance + 1);
        }
    }

    public static void setRootNode2(Node[] nodes, int targetNode, int distance) {
        RootNode rootNode = new RootNode();
        // 현재 노드의 키가 1일 경우 종료
        if (nodes[targetNode - 1].getKey() == 1) {
            rootNode.setKey(1);
            rootNode.setDistance(distance);

            rootNodeList2.add(rootNode);
            // 목표 노드의 부모 노드를 배열리스트에 저장
        } else {
            int rootNodeKey = 0;

            try {
                for (Node node : nodes) {
                    if (node.getLeftNode() == targetNode || node.getRightNode() == targetNode) {
                        rootNodeKey = node.getKey();
                        break;
                    }
                }
            } catch (Exception error) {
                System.out.println("Find root node2 error occurred!");
            }

            rootNode.setKey(rootNodeKey);
            rootNode.setDistance(distance + 1);

            rootNodeList2.add(rootNode);
            setRootNode2(nodes, rootNodeKey, distance + 1);
        }
    }

    public static void setCommonRootNode(ArrayList<RootNode> rootNode1, ArrayList<RootNode> rootNode2) {
        // 공통 부모 정점 배열에 저장
        for (RootNode node1 : rootNode1) {
            for (RootNode node2 : rootNode2) {
                // 공통 노드만 배열에 저장
                if (node1.getKey() == node2.getKey()) {
                    RootNode rootNode = new RootNode();
                    int rootNodeKey = node2.getKey();
                    int rootNodeDistance1 = node1.getDistance();
                    int rootNodeDistance2 = node2.getDistance();

                    rootNode.setKey(rootNodeKey);
                    rootNode.setDistance(rootNodeDistance1 * rootNodeDistance2);

                    commonRootNodeList.add(rootNode);
                }
            }
        }
    }

    public static void getTotalSubTree(Node[] nodes, int rootNode) {
        boolean countCheck = false;

        // 리프 노드일 경우
        if (nodes[rootNode - 1].getLeftNode() == 0 && nodes[rootNode - 1].getRightNode() == 0) {
            totalSubTree++;
        }

        // 자식 노드가 1개 있을 경우
        if (nodes[rootNode - 1].getLeftNode() != 0) {
            countCheck = true;
            totalSubTree++;
            getTotalSubTree(nodes, nodes[rootNode - 1].getLeftNode());
        }

        // 자식 노드가 2개 있을 경우 중복 카운트 확인
        if (nodes[rootNode - 1].getRightNode() != 0) {
            if (!countCheck) {
                totalSubTree++;
            }
            getTotalSubTree(nodes, nodes[rootNode - 1].getRightNode());
        }
    }

}