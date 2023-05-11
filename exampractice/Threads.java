package exampractice;

class Mythread1 extends Thread{
    public void run(){
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}

class Mythread2 extends Thread {
    public void run(){
        for (int i = 1; i <= 100; i++) {
            if((i % 2) == 0) System.out.println(i);
        }
    }
}

class Mythread3 extends Thread {
    public void run(){
        for (int i = 1; i <= 100; i++) {
            if((i % 2) != 0) System.out.println(i);
        }
    }
}

public class Threads{
    public static void main(String[] args) {
        Mythread1 t1 = new Mythread1();
        Mythread2 t2 = new Mythread2();
        Mythread3 t3 = new Mythread3();

        System.out.println("Natural numbers till 100 : ");
        t1.start();
        try{
            t1.join();
        }catch(Exception e) {System.out.println(e);}
        
        System.out.println("Even numbers till 100 : ");
        t2.start();
        try{
            t2.join();
        }catch(Exception e) {System.out.println(e);}

        System.out.println("Odd numbers till 100 : ");
        t3.start();
    }
}
