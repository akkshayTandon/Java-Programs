//design a login page using awt(abstract window toolkit)
package exampractice;

import java.awt.*;

class Login extends Frame {

    void makeLayout(){
        
    Frame f = new Frame();

    Label l1 = new Label("Name:");
    Label l2 = new Label("Password:");

    TextField t1 = new TextField();
    TextField t2 = new TextField();

    Button b1 = new Button("submit");
    Button b2 = new Button("cancel");

    l1.setBounds(50,47,35,35);
    t1.setBounds(100,55,100,20);
    l2.setBounds(30,75,60,60);
    t2.setBounds(100,95,100,20);
    b1.setBounds(50,150,50,30);
    b2.setBounds(120,150,50,30);

    f.add(l1); f.add(l2);
    f.add(t1); f.add(t2);
    f.add(b1); f.add(b2);

    f.setSize(300, 300);
    f.setTitle("My Login Window");
    f.setLayout(null);
    f.setVisible(true);
    }
}

public class LoginDesign {
    public static void main(String[] args) {
        Login login = new Login();
        login.makeLayout();
    }
}
