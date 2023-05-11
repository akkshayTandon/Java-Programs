package calculator;

import java.util.Scanner;


/**
 * App :
 *      program starts here
 *      Assumption : 1. can only calculate for single digits 
 *                   2. operators supported -> -,+,%,/,*,^(power/exponent)
 */
public class Calculator {
    public static void main(String[] args) throws Exception {
        Logic l = new Logic();
        l.infixToPostfix();
    }
}

/**
 * Stack : class stack for implementing stack data structure
 */
class Stack {
    int top = -1;
    char[] stack = new char[100];

    //returns top of stack
    int getTop() {
        return top;
    }
    
    //function to push on top of stack
    void push(char element) {
        top += 1;
        stack[top] = element;
    }

    //function to pop from top of stack
    char pop() {
        char poppped = stack[top];
        top -= 1;
        return poppped;
    }

    //function to get top element of stack
    char peek() {
        return stack[top];
    }

    //checks if stack is empty or not
    boolean isEmpty() {
        return (top == -1);
    }

    //function to traverse stack
    void traverse() {
        if(!(top == -1)) {
            for (char c : stack) {
                System.out.print(c);
            }
        } else System.out.println("Stack Empty");
    }
}


/**
 * Logic : class Logic for implementing the logic of calculator
 */
class Logic {

    //function which return operator precedence
    int operatorPrecedence(char ch) {
        switch (ch) {
            case '-' : return 1; 
            case '+' : return 1;
            case '%' : return 2;
            case '/' : return 2;
            case '*' : return 2;
            case '^' : return 3;                
        }
        return 0;
    }

    //funciton to check if character is alphanumeric or not
    boolean isOperand(char ch) {
        return ( (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') );
    }

    //funciton to check if character is an operator or not
    boolean isOperator(char ch) {
        return ( ( ch == '-' ) || ( ch == '+' ) || ( ch == '%' ) || ( ch == '/' ) || ( ch == '*' ) || ( ch == '^' ) );
    }

    //the main logic starts here, fucntion to convert infix(input) expression to postfix expression which further is evaluated using stack
    void infixToPostfix() {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        Stack postFixStack = new Stack();
        String infix;

        System.out.println("Enter the expression to be evaluated : "); infix = sc.nextLine();
        infix = "(" + infix + ")";
        
        for(int i = 0; i < infix.length(); i++) {

            if(infix.charAt(i) == '(') s.push(infix.charAt(i));

            else if(isOperand(infix.charAt(i))) postFixStack.push(infix.charAt(i));

            else if(isOperator(infix.charAt(i))) {

                if(!isOperator(s.peek())) s.push(infix.charAt(i));

                else if(isOperator(s.peek())) {
                    if(operatorPrecedence(infix.charAt(i)) > operatorPrecedence(s.peek())) {
                            s.push(infix.charAt(i));
                    } else {
                    while(operatorPrecedence(s.peek()) >= operatorPrecedence(infix.charAt(i))) {
                    if(operatorPrecedence(infix.charAt(i)) <= operatorPrecedence(s.peek())) {
                        char c = s.pop();
                        postFixStack.push(c);
                    }
                }
                s.push(infix.charAt(i));
            }
            }
        }

            else if(infix.charAt(i) == ')') {
                while(s.peek()!='(') {
                if(isOperator(s.peek())) postFixStack.push(s.pop());
            }
            if(s.peek() == '(') s.pop();
            } 
        }
        // postFixStack.traverse();
        evaluatePostfixExpression(postFixStack.stack);
        sc.close();
    }

    //fucntion to evaluate the postfix expression obtained from infixToPostfix function above and give the result
    void evaluatePostfixExpression(char[] postfix) {
        Stack eval = new Stack();
        int calc = 0;
        for (char c : postfix) {
            if(isOperand(c)) eval.push(c);
            else if(isOperator(c)) {
                int firstValue = eval.pop() - '0';
                int secondValue = eval.pop() - '0';
                switch (c) {
                    case '-' :  
                            calc = secondValue - firstValue;
                            eval.push((char)(calc + '0'));
                            break;
                    case '+' : 
                            calc = secondValue + firstValue;
                            eval.push((char)(calc + '0'));
                            break;
                    case '%' : 
                            calc = secondValue % firstValue;
                            eval.push((char)(calc + '0'));
                            break;
                    case '/' : 
                            calc = secondValue / firstValue;
                            eval.push((char)(calc + '0'));
                            break;
                    case '*' : 
                            calc = secondValue * firstValue;
                            eval.push((char)(calc + '0'));
                            break;
                    case '^' :           
                            calc = (int) Math.pow(secondValue,firstValue);
                            eval.push((char)(calc + '0'));
                            break;
                    default:
                        System.out.println("INVALID OPERATOR");
                }
            }
        }
        System.out.println("\n\tThe calculated value of above expression is : " + calc);
    }
}

