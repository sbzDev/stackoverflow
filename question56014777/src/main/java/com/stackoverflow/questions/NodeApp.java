package com.stackoverflow.question56014777;
public class NodeApp {
    public static void main(String[] args) {
        Node<String> parentNode = new Node<String>("Parent");
        Node<String> childNode1 = new Node<String>("Child 1", parentNode);
        Node<String> childNode2 = new Node<String>("Child 2", parentNode);
        System.out.println(parentNode.getSize());
        System.out.println(parentNode.toString());
    }

}
