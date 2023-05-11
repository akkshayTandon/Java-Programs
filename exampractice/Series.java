package exampractice;

import java.util.Scanner;

public class Series {
    static int factorial(int n){
        if((n == 0) || (n == 1)) return 1;
        else return n*factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the limit till you want to find the value : ");
        int limit = sc.nextInt();
        float sum = 0;
        for(int i = 1; i <= limit; i++) {
            int f = factorial(i);
            sum += ((float)(i*i)/f);
        }
        System.out.println("The value is : " + sum); 
        sc.close();
    }
}
