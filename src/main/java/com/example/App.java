package main.java.com.example;

public class App {

    // FIX: Removed 'throws Exception' because all exceptions 
    // are now handled inside the methods called below.
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        // Note: For a strictly SonarQube-compliant codebase, 
        // you might eventually replace this System.out with a Logger too.
        System.out.println(calc.calculate(10, 5, "add"));

        UserService service = new UserService();
        service.findUser("admin");

    }
}