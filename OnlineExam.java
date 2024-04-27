import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        if (isValidPassword(password))
        {
            this.password=password;
        }
        
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}


class Question {
    private String question;
    private String[] options;
    private int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public int getOptionsLength() {
        return options.length;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctOption;
    }
}

class Exam {
    private Question[] questions;
    private int totalQuestions;
    private int timeLimit;

    public Exam(Question[] questions, int timeLimit) {
        this.questions = questions;
        this.totalQuestions = questions.length;
        this.timeLimit = timeLimit;
    }

    public void startExam() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        long startTime = System.currentTimeMillis();
        
        System.out.println("Welcome to the exam! You have " + timeLimit + " minutes to complete it.");

        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            questions[i].displayQuestion();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= questions[i].getOptionsLength()) {
                if (questions[i].isCorrect(choice)) {
                    score++;
                }
            } else {
                System.out.println("Invalid choice! Skipping question...");
            }
        }

        long endTime = System.currentTimeMillis();
        long timeTakenSeconds = (endTime - startTime) / 1000;
        System.out.println("\nExam completed! You scored " + score + " out of " + totalQuestions);
        System.out.println("Time taken: " + timeTakenSeconds + " seconds");

        scanner.close();
    }
}

public class OnlineExam {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Exam System");
        System.out.print("Enter your username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter your password: ");
        String passwordInput = scanner.nextLine();
        User user=new User(usernameInput, passwordInput);
        // Authenticate user
        if(user.getUsername()!=null && user.getPassword()!=null)
        {
            System.out.println("Login successful! Starting the exam...");
        Question[] questions = {
    new Question("What is the output of the following Java code?\n\npublic class Main {\n    public static void main(String[] args) {\n        int x = 5;\n        System.out.println(x++);\n        System.out.println(x);\n    }\n}", new String[]{"6\t6", "5\t6", "5\t5", "6\t5"}, 2),
    
    new Question("Which keyword is used to define a class in Java?", new String[]{"class", "struct", "interface", "package"}, 1),
    
    new Question("What does the 'static' keyword mean in Java?", new String[]{"It makes a method or variable belong to the class, rather than an instance of the class", "It indicates that a method can be overridden in subclasses", "It makes a variable constant and cannot be changed", "It allows a method to be accessed by any other class"}, 1),
    
    new Question("What is the result of 9 % 4 in Java?", new String[]{"1", "2.25", "2.5", "2"}, 4),
    
    new Question("Which data structure uses LIFO (Last-In-First-Out) order?", new String[]{"Queue", "Stack", "Heap", "Linked List"}, 2),
    
    new Question("What is the difference between '==', '.equals()', and 'hashCode()' methods in Java?", new String[]{"'==' compares the memory address of objects, '.equals()' compares the contents, and 'hashCode()' returns a unique integer representation of the object", "'==' compares the contents of objects, '.equals()' compares the memory address, and 'hashCode()' returns a boolean value", "'==' compares the memory address of objects, '.equals()' compares the contents, and 'hashCode()' returns the memory address", "'==' compares the contents of objects, '.equals()' compares the memory address, and 'hashCode()' returns the hash value"}, 1),
    
    new Question("What is polymorphism in Java?", new String[]{"Polymorphism is the ability of a variable, function, or object to take on multiple forms", "Polymorphism is the process of hiding the implementation details and showing only functionality", "Polymorphism is the process of creating multiple instances of a class", "Polymorphism is the process of extending a class to create a subclass"}, 1),
    
    new Question("What is the 'try-with-resources' statement in Java?", new String[]{ "It catches exceptions that occur within a block of code", "It allows multiple exceptions to be caught within a single catch block","It ensures that each resource is properly closed at the end of the statement", "It allows for conditional execution of code"}, 3),
    
    new Question("What is the purpose of the 'transient' keyword in Java?", new String[]{"It indicates that a variable should not be serialized", "It indicates that a variable cannot be accessed by subclasses", "It indicates that a variable should be synchronized", "It indicates that a variable should be static"}, 1),
    
    new Question("What is a lambda expression in Java?", new String[]{ "It is a function that can be called from anywhere in the code","It is an anonymous function that can be passed around as if it were a variable", "It is a function that must be called with specific arguments", "It is a predefined function in the Java standard library"}, 2),
};

        Exam exam = new Exam(questions, 30); 
        exam.startExam();
    }
    else
{
    System.out.println("Invalid username or password! Try again...");
}
}
}
