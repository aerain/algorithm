package codewars.java;

public class Prime {
    public static boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num == 2 || num == 3) return true;
        boolean[] isNotPrimeArr = new boolean[num];
        for(int i = 2; i * i < num; i++) {
            if(!isNotPrimeArr[i]) {
                if(num % i == 0) return false;
                else {
                    for(int j = i * i; j < num; j += i) {
                        isNotPrimeArr[j] = true;
                    }
                }
            }

        }
        return true;
    }
}
