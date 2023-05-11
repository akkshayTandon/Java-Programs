


/* 1. Progrsm to show range of all data types in java. */
// public class Programs {
//     public static void main(String[] args) {
//     System.out.println("byte min = " + Byte.MIN_VALUE);
//     System.out.println("byte max = " + Byte.MAX_VALUE); 
//     System.out.println();
//     System.out.println("short min = " + Short.MIN_VALUE); 
//     System.out.println("short max = " + Short.MAX_VALUE); 
//     System.out.println();
//     System.out.println("int min = " + Integer.MIN_VALUE); 
//     System.out.println("int max = " + Integer.MAX_VALUE);
//     System.out.println();
//     System.out.println("long min = " + Long.MIN_VALUE);
//     System.out.println("long max = " + Long.MAX_VALUE); 
//     System.out.println();
//     System.out.println("float min = " + Float.MIN_VALUE); 
//     System.out.println("float max = " + Float.MAX_VALUE); 
//     System.out.println();
//     System.out.println("double min = " + Double.MIN_VALUE); 
//     System.out.println("double max = " + Double.MAX_VALUE); 
//     System.out.println();
//     }
// }

/* 2. Program to demonstrate the object of a class. */
// class Demonstrate{
//     void display() {
//         System.out.println("In the display method of the demonstrate class.");
//     }
// }
// public class Programs {
//     public static void main(String[] args) {
//         Demonstrate d = new Demonstrate();
//         d.display();
//     }
// }

/* 3. Program to demonstrate constructor. */
// class Constructor{
//     Constructor(){
//         System.out.println("Inside the constructor of Constructor class.");
//     }
//     void display() {
//         System.out.println("inside display method of class constructor");
//     }
// }
// public class Programs {
//     public static void main(String[] args) {
//         Constructor c = new Constructor();
//         c.display();
//     } 
// }

/* 4. Program to initialize variables to show 'this' keyword using parametrized constructor */
// class Constructor{
//     int a,b;
//         Constructor(int a , int b){
//             this.a = a; this.b = b;
//             System.out.println("variables initialized with the given values.");
//         }
//         void display() {
//             System.out.println("variables were initialized with : " + "a = "+ this.a + " b = " + this.b );
//         }
//     }
// public class Programs {
//         public static void main(String[] args) {
//             Constructor c = new Constructor(10,20);
//             c.display();
//         } 
//     }

/* 5. Program to show constructor overloading. */
// class Constructor{
//     int a,b;
//         Constructor(){
//             System.out.println("Inside the non-parametrized constructor of Constructor class.");
//         }
//         Constructor(int a , int b){
//             this.a = a; this.b = b;
//             System.out.println("Variables initialized with the parametrized constructor of Constructor class.");
//         }
//         void display(String s) {
//             System.out.println("Display method of class constructor called using constructor " + s );
//         }
//     }
//     public class Programs {
//         public static void main(String[] args) {
//             Constructor c1 = new Constructor();
//             Constructor c2 = new Constructor(10,20);
//             c1.display("c1");
//             c2.display("c2");
//         } 
//     }

/* 6. Program to demonstrate nested class. */
// class OuterClass {
//     int x = 10;
  
//     class InnerClass {
//       int y = 5;
//     }
// }
// public class Programs {
//     public static void main(String[] args) {
//       OuterClass myOuter = new OuterClass();
//       OuterClass.InnerClass myInner = myOuter.new InnerClass();
//       System.out.println(myInner.y + myOuter.x);
//     }
//   }

/* 7. Prorgam to pass object as parameter. */
// class Box {
//     double width, height, depth;
//     Box(Box ob) {
//         width = ob.width; height = ob.height; depth = ob.depth;
//     }
//     Box(double w, double h, double d) {
//         width = w; height = h; depth = d;
//     }
//     double volume() { return width * height * depth; }
// }
// public class Programs {
//     public static void main(String args[]) {
//         Box mybox = new Box(10, 20, 15);
//         Box myclone = new Box(mybox);
//         double vol;
//         vol = mybox.volume();
//         System.out.println("Volume of mybox is " + vol);
//         vol = myclone.volume();
//         System.out.println("Volume of myclone is " + vol);
//     }
// }

/* 8. Program to show single inheritance using super keyword.  */
// class A{
//     A(){
//         System.out.println("Inside constructor of class A called by 'super' keyword");
//     }
// }
// class B extends A{
//     B(){
//         super();
//         System.out.println("Outside constructor of class B");
//     }
// }
// public class Programs {
//     public static void main(String[] args) {
//         B b = new B();
//     }    
// }

/* 9. Program to show multilevel inheritance. */
// class A{
//     void printA() {
//         System.out.println("I am in class A.");
//     }
// }
// class B extends A{
//     void printB(){
//         System.out.println("I am in class B.");
//     }
// }
// class C extends B{
//     void pritnC() {
//         System.out.println("I am in class C.");
//     }
// }
// public class Programs{
//     public static void main(String[] args) {
//         C obj = new C();
//         obj.pritnC(); obj.printB(); obj.printA();
//     }
// }

/* 10. Program to show hierarchical inheritance. */
// class HierarchicalInheritance { 
// 	void DisplayA() { 
// 		System.out.println("This is a content of parent class"); 
// 	} 
// }  
// class A extends HierarchicalInheritance { 
// 	void DisplayB() { 
// 		System.out.println("This is a content of child class 1"); 
// 	} 
// } 
// class B extends HierarchicalInheritance { 
// 	void DisplayC() { 
// 		System.out.println("This is a content of child class 2"); 
// 	} 
// } 
// public class Programs { 
// 	public static void main(String args[]) { 
// 		System.out.println("Calling for child class C"); 
// 		B b = new B(); b.DisplayA(); b.DisplayC(); 
// 		System.out.println("Calling for child class B"); 
// 		A a = new A(); a.DisplayA(); a.DisplayB();
// 	} 
// } 

