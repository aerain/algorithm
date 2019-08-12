package sorttest;

import java.util.Arrays;

public class Sort {
    public void quickSort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    private void qs(int[] arr, int left, int right) {
        int pivot, temp, low, high;
        if(left < right) {
            low = left;
            high = right;
            pivot = arr[(left + right) / 2];

            while(low < high) {
                while(arr[high] > pivot) high--;
                while(low < high && arr[low] < pivot) low++; // 일단 작은놈 나오면 무조건 때리고
                // 큰놈이 나오면?
                // 교체한다!
                temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                //분할에서 정렬 실시
            }

            qs(arr, left, high - 1);
            qs(arr, high + 1, right);
        }
    }

    public void mergeSort(int[] arr) {
        ms(arr, 0, arr.length);
    }

    private void ms(int[] arr, int i, int j) {
        if(j - i < 2) return;

        int mid = (i + j) / 2;
        int lStart = i, lEnd = mid, rStart = mid, rEnd = j;
        ms(arr, lStart, lEnd);
        ms(arr, rStart, rEnd);

        // 합병 시작
        int[] sortedArr = new int[j - i + 1];
        int index = 0;
        while(lStart < lEnd || rStart < rEnd) {
            if(lStart >= lEnd) sortedArr[index++] = arr[rStart++];
            else if(rStart >= rEnd) sortedArr[index++] = arr[lStart++];
            else {
               if(arr[lStart] < arr[rStart]) sortedArr[index++] = arr[lStart++];
               else sortedArr[index++] = arr[rStart++];
            }
        }
        for(int k = i; k < j; k++) {
            arr[k] = sortedArr[k - i];
        }
    }
}
