package sorttest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("퀵 정렬");
        int[] arr = new int[] {9, 4, 3, 1, 6, 8, 7, 5, 2};
        System.out.println(Arrays.toString(arr));
        Sort sort = new Sort();
        sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("------");
        System.out.println("병합 정렬");
        arr = new int[] {9, 4, 3, 1, 6, 8, 7, 5, 2};
        System.out.println(Arrays.toString(arr));
        sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
