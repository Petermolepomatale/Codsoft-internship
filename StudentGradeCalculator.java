import javax.swing.JOptionPane;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Array containing marks obtained by the student
        int[] marksObtained ={89, 94, 65, 85, 90};
        int totalSubjects = 5;

        // Calculate total marks, average percentage, and grade
        int totalMarks = calculateTotalMarks(marksObtained);
        double averagePercentage = calculateAveragePercentage(totalMarks, totalSubjects);
        char grade = calculateGrade(averagePercentage);

        // Display the results
        displayResults(totalMarks, averagePercentage, grade);
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

    // Display results using JOptionPane
    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        String message = "Total marks: " + totalMarks + "\n"
                + "Average percentage: " + averagePercentage + "%" + "\n"
                + "Grade: " + grade;
        JOptionPane.showMessageDialog(null, message, "Student Grade Calculator", JOptionPane.INFORMATION_MESSAGE);
    }
}
