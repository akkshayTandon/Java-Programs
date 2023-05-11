package exampractice;

import java.util.Scanner;

class Student{
    float[] marks = new float[5];
    float percentage; char grade;
    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of student in(out of 100) : ");
        System.out.print("\nSubject 1 : "); marks[0] = sc.nextFloat();
        System.out.print("\nSubject 2 : "); marks[1] = sc.nextFloat(); 
        System.out.print("\nSubject 3 : "); marks[2] = sc.nextFloat();
        System.out.print("\nSubject 4 : "); marks[3] = sc.nextFloat();
        System.out.print("\nSubject 5 : "); marks[4] = sc.nextFloat();
        sc.close();
    }
    float calculatePercentage(){
        percentage = ((marks[0] + marks[1] + marks[2] + marks[3] + marks[4])/500) * 100;
        return percentage;
    }
    void printGrade(float p){
        if(p >= 80) System.out.println("Grade Awarded : A");
        else if((p >= 30) && (p <= 79)) System.out.println("Grade Awarded : B");
        else System.out.println("Student is FAIL !");
    }
}

/**
 * grade
 */
public class Grade {

    public static void main(String[] args) {
        Student s = new Student();
        s.input();
        s.printGrade(s.calculatePercentage());
    }
}