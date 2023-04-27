package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    public static void main(String[] args) {
        // List<Integer> res = findSimpleNumbers(100);
        // for (Integer integer : res) {
        //     System.out.println(integer);
        // }
        // AtomicInteger counter = new AtomicInteger(0);
        // int fib  = fib(14,counter);
        // System.out.println("Fib number " + fib);
        // System.out.println("Counter " + counter.get());
        seminar1(998);
    }
    
    public static List<Integer> findAvaibleDivider(int number) {
        List<Integer>result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0){
                result.add(i);
            }
        }
        return result;
    }
    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0;
        List<Integer>result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0){
                    simple = false;
                    break;
                }
            }
            if (simple){
                result.add(i);
            }
        }
        System.out.println("Счётчик: "+ counter);
        return result;
    }
    public static int fib(int position, AtomicInteger counter) {
        counter.incrementAndGet();
        if (position == 1){
            return 0;
        }
        if (position == 2){
            return 1;
        }
        return fib(position -1,counter) + fib(position-2,counter);
    }
    public static void seminar1(int n) {
        int countDel = 0, i,j,k,m;
        for (i = 3; i <= n/2; i+=2) {
            countDel = 0;
            for (j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0)
                countDel++;
            }
            if (countDel == 0) {
                m = n-i;
                for (k = 2; k < Math.sqrt(m); k++) {
                    if (m % k == 0)
                    countDel++;
                }
                if (countDel == 0) {
                    System.out.printf("%d %d\n", i,m);
                    break;
                }
            }
        }
    }
}