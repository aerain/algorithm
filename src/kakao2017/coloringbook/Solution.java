package kakao2017.coloringbook;

import java.util.*;

class Node {
    int i;
    int j;

    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int sizeOfArea = 0;
        int color = 0;
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0) {
                    numberOfArea++;
                    sizeOfArea = 0;
                    color = picture[i][j];
                    queue.offer(new Node(i, j));
                    while(!queue.isEmpty()) {
                        Node node = queue.poll();
                        if(picture[node.i][node.j] == 0) continue;
                        sizeOfArea++;
                        picture[node.i][node.j] = 0;

                        if(node.i < m - 1 && picture[node.i + 1][node.j] == color) queue.offer(new Node(node.i + 1, node.j));
                        if(node.i > 0 && picture[node.i - 1][node.j] == color) queue.offer(new Node(node.i - 1, node.j));
                        if(node.j > 0 && picture[node.i][node.j - 1] == color) queue.offer(new Node(node.i, node.j - 1));
                        if(node.j < n - 1 && picture[node.i][node.j + 1] == color) queue.offer(new Node(node.i, node.j + 1));
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfArea);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
//class Solution {
//    public int[] solution(int m, int n, int[][] picture) {
//        int numberOfArea = 0;
//        int maxSizeOfOneArea = 0;
//
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                if(picture[i][j] != 0) {
//                    numberOfArea++;
//                    int sizeOfArea = 0;
//                    int targetColor = picture[i][j];
//                    Queue<Node> Q = new LinkedList<>();
//                    Q.offer(new Node(i, j));
//
//                    while(!Q.isEmpty()) {
//                        Node node = Q.poll();
//                        if(picture[node.i][node.j] == 0) continue;
//                        int w = node.j;
//                        int e = node.j;
//                        while (w > 0 && picture[node.i][w - 1] == targetColor) w--;
//                        while (e < picture[node.i].length - 1 && picture[node.i][e + 1] == targetColor) e++;
//
//                        for(int a = w; a <= e; a++){
//                            picture[node.i][a] = 0;
//                            sizeOfArea++;
//                            if(node.i > 0 && picture[node.i - 1][a] == targetColor) Q.offer(new Node(node.i - 1, a));
//                            if(node.i < picture.length - 1 && picture[node.i + 1][a] == targetColor) Q.offer(new Node(node.i + 1, a));
//                        }
//                    }
//                    if(maxSizeOfOneArea < sizeOfArea) maxSizeOfOneArea = sizeOfArea;
//                }
//            }
//        }
//
//        int[] answer = new int[2];
//        answer[0] = numberOfArea;
//        answer[1] = maxSizeOfOneArea;
//
//        System.out.println(Arrays.toString(answer));
//        return answer;
//    }
//}
//
//class Node {
//    final int i;
//    final int j;
//    Node(int i, int j) {
//        this.i = i;
//        this.j = j;
//    }
//}
