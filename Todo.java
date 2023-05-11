import java.util.Scanner;

/**
 * Todo - a simple To Do Program
 */
public class Todo {
    // nested Class List to make a task list
    public class List {
        Scanner sc = new Scanner(System.in);
        String task; int index = 0;
        List[] list = new List[5];
        //non-parametrized constructor
        List(){}
        //parametrized constructor
        List(String task){
            this.task = task;
        }
        //add method to add tasks to list
        void add(){
             System.out.print("Enter a task to add : "); String t = sc.nextLine();
             list[index] = new List(t);
             index = index + 1;
        }
        //show method to show task list
        void Show(){
            System.out.println("Your List");
            System.out.println("----------");
            for (int i = 0; i <= index-1; i++) {
                System.out.println(" " + (i+1) + "." + list[i].task);
            }
        }
        //function to mark a task as done
        void markAsDone(){
            System.out.print("\nEnter task number to mark it as done : "); int taskNumber = sc.nextInt();
            for (int i = 0; i <= (index-1); i++) {
                if( i == (taskNumber-1) ) list[i].task = list[i].task + "(done)";
            }
        }
    }
    //main method , program starts here
    public static void main(String[] args) {
        Todo T = new Todo();
        Scanner sc = new Scanner(System.in);
        char choice; 
        List l = T.new List();
        //do-while loop to show menu to user
        do{
            System.out.println("\n TO DO");
            System.out.println("---------");
            System.out.println("1.Add task to list");
            System.out.println("2.Show task list");
            System.out.println("3.Mark a task as done");
            System.out.println("4.Exit");
            System.out.print("\n\tEnter your choice : "); choice = sc.next().charAt(0);
            switch(choice){
                case '1':
                    l.add();
                    break;
                case '2':
                    l.Show();
                    break;
                case '3':
                    l.markAsDone();
                    break;
                case '4':
                    System.exit(0);
                    break;
                }
        }while(choice != '4');
        sc.close();
    }
}