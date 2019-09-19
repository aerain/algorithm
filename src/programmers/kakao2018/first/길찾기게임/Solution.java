package programmers.kakao2018.first.길찾기게임;

import java.util.*;

public class Solution {
    public int[][] solution(int[][] nodeinfo) {
        PriorityQueue<Node> nodes = new PriorityQueue<Node>(nodeinfo.length, ((o1, o2) -> {
            int ret = -Integer.compare(o1.y, o2.y);
            if(ret == 0) return Integer.compare(o1.x, o2.x);
            return ret;
        })) {{ for(int i = 0; i < nodeinfo.length; i++) { offer(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));}}};

        Tree tree = new Tree(nodes.poll());
        while(!nodes.isEmpty()) tree.insert(nodes.poll());
        System.out.println(Arrays.toString(tree.toArrayPreFix()));


        int[][] answer = new int[0][0];
        return answer;
    }
}

class Tree {
    Node head;
    int size;

    Tree(Node head) {
        this.head = head;
        size = 1;
    }
    public void insert(Node node) {
        Node parent = head;
        while(true) {
            if(node.x < parent.x) {
                if (parent.l != null) {
                    parent = parent.l;
                } else {
                    node.parent = parent;
                    parent.l = node;
                    break;
                }
            } else {
                if(parent.r != null) {
                    parent = parent.r;
                } else {
                    node.parent = parent;
                    parent.r = node;
                    break;
                }
            }
        }

        size++;
    }

    public int[] toArrayPreFix() {
        System.out.println(size);
        int[] ret = new int[size];
        int index = 0;
        Node itr = head;
        try {
            while(index < size) {
                ret[index++] = itr.value;
                if(itr.l != null) itr = itr.l;
                else if(itr.r != null) itr = itr.r;
                else {
                    while(index < size && itr.parent != null && itr.parent.r == null&& itr.equals(itr.parent.l)) {
                        itr = itr.parent;
                        System.out.println(itr);
                    }
                    itr = itr.r;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(itr);
        }

        return ret;
    }
//    public int[] toArrayPostFix() {
//        Stack
//        int[] ret = new int[size];
//        int index = 0;
//        Node itr = findEndNode(head);
//
//        // 끝찾기..
//        while(true) {
//
//        }
//
//
//        return ret;
//    }

//    public Node findEndNode(Node node) {
//        while(node.l != null) {
//            node = node.l;
//        }
//        return node;
//    }
}

class Node {
    int x, y, value;
    Node l, r, parent;
    Node(int x, int y, int value) {
        this.x = x; this.y = y; this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node) {
            return this.value == ((Node) obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.value;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + value + ")";
    }
}