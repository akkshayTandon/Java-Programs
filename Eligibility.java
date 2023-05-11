import java.util.Scanner;
/**
 * Eligibility : program starts here , to check the eligibilty of student for various courses
 */
public class Eligibility {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]  studentMarks = new int[5];
        String studentName;

        System.out.print("\nEnter the name of student : "); studentName = sc.nextLine();
        System.out.println("Enter the marks of student in subject 1 out of 100 : "); studentMarks[0] = sc.nextInt();
        System.out.println("Enter the marks of student in subject 2 out of 100 : "); studentMarks[1] = sc.nextInt();
        System.out.println("Enter the marks of student in subject 3 out of 100 : "); studentMarks[2] = sc.nextInt();
        System.out.println("Enter the marks of student in subject 4 out of 100 : "); studentMarks[3] = sc.nextInt();
        System.out.println("Enter the marks of student in subject 5 out of 100 : "); studentMarks[4] = sc.nextInt();

        Student s = new Student(studentMarks, studentName);
        s.selectCourse();

        sc.close();
    }
}

/**
 * Student : student class to create a student , calculate his percentage and show which course he is eligible for
 */
class Student {
    String name;
    int[] marks = new int[5];
    int total = 0;
    
    //constructor method for initializing a student
    Student(int[] marks, String name) {
        this.name = name;
        for (int i = 0; i < this.marks.length; i++) 
            this.marks[i] = marks[i];
    }

    //method to calculate percentage of a student
    double calculatePercentage() {
      for (int i = 0; i < this.marks.length; i++) 
        this.total += this.marks[i];
        return (this.total*100)/500;
    }

    //method to show which course a student is eligible for
    void selectCourse() {
        double percentage = calculatePercentage();
        if ( percentage >= 60 && percentage <= 65 ) System.out.println("You eligible for a B.A.(Bachelor Of Arts)");
        else if ( percentage > 65 && percentage <= 70 ) System.out.println("You eligible for a B.Com(Bachelor of COmmerce)");
        else if ( percentage > 70 && percentage <= 75 ) System.out.println("You eligible for a BBA(Bachelor of Business Administration)");
        else if ( percentage > 75 && percentage <= 80 ) System.out.println("You eligible for a LLB(Legum Baccalaureus/Bachelor of Laws)");
        else if ( percentage > 80 && percentage <= 85 ) System.out.println("You eligible for a  B.sc(Bachelor of Science)");
        else if ( percentage > 85 && percentage <= 90 ) System.out.println("You eligible for a  BCA(Bachelor of Computer Applications)");
        else if ( percentage > 90) System.out.println("You may go for a B.Tech(Bachelor of Technology)");
        else System.out.println("You may go for a Diploma");
    }
}

