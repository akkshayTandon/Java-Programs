package exampractice;

import java.util.Scanner;

public class Initials {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer initials = new StringBuffer();
        System.out.println("Enter a stirng to print its initials :"); String string = sc.nextLine();
        string.trim();
        initials.append(string.charAt(0));
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ' ') initials.append(string.charAt(i+1));
        }
        System.out.println("The initials of the string " + string + " are " + initials);
        sc.close();
    }
}
