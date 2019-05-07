package com.stackoverflow.question56014777;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private List<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent = null;
    private T data = null;

    public Node(T data) { //used to create parent
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.parent = parent;
        this.data = data;
        this.parent.children.add(this);
    }

    public Node<T> getParent(Node<T> child) {
        return child.parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public int getSize() {
        return children.size();
    }

    public String toString() {
        String a = "";
        for (int i = 0; i < children.size(); i++) {
            a = a + children.get(i).getData() + ",";
        }
        return a;
    }

    public T getData() {
        return data;
    }
}
