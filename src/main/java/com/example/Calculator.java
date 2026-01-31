package main.java.com.example;

public class Calculator {
    
    public int calculate(int a, int b, String op) {
        if (op.equals("add")) {
            return a + b;
        } else if (op.equals("sub")) {
            return a - b;
        } else if (op.equals("mul")) {
            return a * b;
        } else if (op.equals("div")) {
            if (b == 0) return 0;
            return a / b;
        } else if (op.equals("mod")) {
            return a % b;
        } else if (op.equals("pow")) {
            return (int) Math.pow(a, b);
        } else {
            return 0;
        }
    }


}
