package testdome;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int a = 0;
        int b = (sortedArray.length + 1) / 2;
        int c = -1;
        System.out.println(a + ", " + b);
        while(a < b) {
            c = (a + b + 1) / 2;
            System.out.println(c);
            if(sortedArray[c] < lessThan) {
                a = c;
            } else if(sortedArray[c] > lessThan) {
                b = c - 1;
            } else {
                break;
            }
            System.out.println(a + ", " + b);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}
