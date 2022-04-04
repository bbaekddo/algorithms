package com.SWExpertAcademy;

class node {
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
}

public class Problem1233 {
    public static void main(String[] args) {

    }
}
