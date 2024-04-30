import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter marks obtained for each subject
        int[] marksObtained = new int[5];
        System.out.println("Enter marks obtained for each subject:");
        for (int i = 0; i < marksObtained.length; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marksObtained[i] = scanner.nextInt();
        }

        int totalSubjects = marksObtained.length;

        // Calculate total marks, average percentage, and grade
        int totalMarks = calculateTotalMarks(marksObtained);
        double averagePercentage = calculateAveragePercentage(totalMarks, totalSubjects);
        char grade = calculateGrade(averagePercentage);

        // Display the results
        displayResults(totalMarks, averagePercentage, grade);

        // Close the scanner
        scanner.close();
    }

    // Calculate total marks obtained
    private static int calculateTotalMarks(int[] marksObtained) {
        int totalMarks = 0;
        for (int mark : marksObtained) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    // Calculate average percentage
    private static double calculateAveragePercentage(int totalMarks, int totalSubjects) {
        return (double) totalMarks / (100 * totalSubjects) * 100;
    }

    // Calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        // Using switch statement
        char grade;
        switch ((int) averagePercentage / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
                break;
        }
        return grade;
    }

    // Display results
    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total marks: " + totalMarks);
        System.out.println("Average percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
