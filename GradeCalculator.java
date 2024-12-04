import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the marks (0-100): ");
        int marks = scanner.nextInt();
        
        String grade;
        
        if (marks >= 0 && marks <= 100) {
            if (marks >= 80) {
                grade = "A+";
            } else if (marks >= 75) {
                grade = "A";
            } else if (marks >= 70) {
                grade = "A-";
            } else if (marks >= 65) {
                grade = "B+";
            } else if (marks >= 60) {
                grade = "B";
            } else if (marks >= 55) {
                grade = "B-";
            } else if (marks >= 50) {
                grade = "C+";
            } else if (marks >= 45) {
                grade = "C";
            } else if (marks >= 40) {
                grade = "D";
            } else {
                grade = "F";
            }
        } else {
            grade = "Invalid marks! Please enter marks between 0 and 100.";
        }
        
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
