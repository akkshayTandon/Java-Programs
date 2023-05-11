package exampractice;

import java.util.Scanner;

class Employee{
    int eid; String ename; String edeptt; float esal; int eexp;
    void addEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter details of new employee : ");
        System.out.print("\nEmployee ID: "); this.eid = sc.nextInt(); 
        System.out.print("\nEmployee NAME: "); this.ename = sc.next();
        System.out.print("\nEmployee DEPARTMENT: "); this.edeptt = sc.next();
        System.out.print("\nEmployee SALARY: "); this.esal = sc.nextFloat();
        System.out.print("\nEmployee EXPERIENCE: "); this.eexp = sc.nextInt();
        sc.close();
    }
    void display(){
        System.out.print("\nDetails of Employee : ");
        System.out.print("\nEmployee ID: " + this.eid);
        System.out.print("\nEmployee NAME: "+ this.ename );
        System.out.print("\nEmployee DEPARTMENT: "+ this.edeptt );
        System.out.print("\nEmployee SALARY: "+ this.esal );
        System.out.print("\nEmployee EXPERIENCE: " + this.eexp );
    }
}

public class Empobjects {
    public static void main(String[] args) {
        Employee[] employee = new Employee[50];
        for(int i = 0 ; i < employee.length ; i++){
            employee[i] = new Employee();
        }
        // employee[0] = new Employee();
        // employee[0].addEmployee();
        // employee[0].display();
        // Employee e = new Employee();
        // e.addEmployee();
    }
}
