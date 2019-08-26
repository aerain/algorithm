package programmers.kakao2018a.dolls;


//import java.io.*;
//import java.util.*;
//
//public class Solution {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()); // 인형의 갯수 N
//        int k = Integer.parseInt(st.nextToken()); // 연속되어야 하는 최소한의 갯수 K
//        int[] arr = new int[n]; // 인형을 선호하는 사람의 수를 저장할 배열
//        double variance = 0, tmp = 0, average = 0, stdDeviation = 0; // 분산,평균,표준편차
//        double min = 10000000; // 최소값을 저장할 변수
//
//        st = new StringTokenizer(br.readLine()); // 두번째 줄 입력
//        for (int i = 0; i < n; i++) { // 배열에 저장
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        for (int i = 0; i <= n - k; i++) {
//            int count = k; // k개 이상이기때문에 k개부터 하나씩 늘려가면서 표준편차가 최소일 때를 찾아야 함
//            while (i + count <= n) { // 배열의 끝까지 연속할 경우를 확인해야하므로 i+count가 n보다 작거나 같을때까지만 반복
//                tmp = average = variance = stdDeviation = 0; //
//                for (int j = 0; j < count; j++) { // 평균구하기
//                    tmp += arr[i + j]; // 연속하는 데이터를 tmp에 더해줌
//                }
//                average = tmp / count; // 평균 구하기
//                tmp = 0;
//                for (int j = 0; j < count; j++) { // 분산구하기
//                    tmp += (arr[i + j] - average) * (arr[i + j] - average); // 분산을 구하기 위해 (a1 - m)2 을 반복해서 더해줌
//                }
//                variance = tmp / count; // 분산 구하기
//                stdDeviation = Math.sqrt(variance); // 표준 편차 구하는 함수
//                min = Math.min(min, stdDeviation); // 구한 표준편차가 최소라면 값 갱신
//                count++;
//            }
//        }
//        System.out.println(String.format("%.12f", min)); // 소수점12자리까지 출
//
//    }
//
//}


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] dolls = new int[N];
        for(int i = 0; i < N; i++) dolls[i] = Integer.parseInt(st.nextToken());
        System.out.println(String.format("%.12f", solution(N, K, dolls)));
    }

    private static double solution(int n, int k, int[] dolls) {
        double answer = Double.MAX_VALUE;

        long sum = 0, powsum = 0;
        double std = 0;

        for(int i = k; i <= n; i++) {
            for(int j = i - 1; j < n; j++) {
                sum = 0; powsum = 0;
                for(int m = j - (i - 1) ; m <= j; m++) {
                    sum += dolls[m];
                    powsum += (dolls[m] * dolls[m]);
                }

                std = ((double) powsum / i) - Math.pow((double) sum / i , 2);
                answer = Math.min(answer, Math.sqrt(std));
            }
        }
        return answer;
    }
}
