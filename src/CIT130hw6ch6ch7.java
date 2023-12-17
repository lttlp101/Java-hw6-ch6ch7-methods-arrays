
//
// ------------------------------------------
/*
    @brief This Program:
    This Java program include the following methods:
    1. A method that asks for the number of students in a class making sure that
       the entered number is more than 0. The method returns the number of students.
    2. A method that asks the user to enter the name and test score for each student
       and store the data in 2 arrays, one for name, one for test score. The parameters
       to the method can be the arrays of name and test scores.
    3. A method that calculates and returns the average of the test scores.
       The method will need the test score array.
    4. A method that calculates and returns the variance of the test scores.
       To calculate the variance, you need the average of the numbers,
       so call your method that returns the average in this method.
    5. A method that sorts the data by test score in increasing order.
       You can use any of the sort methods mentioned in the textbook or any method you find on the web.
       You just must make sure to swap the names at the same time you swap the test scores.
    6. In your main method, call your methods to:
         •Get the data,
         •Display the data in its original form,
         •Display the sorted data,
         •Display the average,
         •Display the variance
 */
//
// ------------------------------------------
//
//
//


import java.util.Scanner;

@SuppressWarnings("java:S106") // Disable the warning about System.out from SonarLint

public class CIT130hw6ch6ch7 {

    // Create the Instance of a Scanner Object for Inputs
    public static final Scanner inputs = new Scanner(System.in);

    public static void main(String[] args) {
        // Display Assignment Header
        System.out.println("\nAssignment 6    Methods and Arrays  \n");

        // Initiate Headers
        String header1 = "*** Here's what I have for your data ***";
        String header2 = "*** Here's your sorted data ***";

        // Assign the Return Value for numOfStudents by Calling the getNumberOfStudents Method
        int numOfStudents = getNumberOfStudents();

        // Create the Names and Test Scores Arrays with Length of the Number of Students
        String[] names = new String[numOfStudents];
        double[] testScores = new double[numOfStudents];

        // Call getNamesAndTestScores Method, Passing numOfStudents, names, testScores In
        getNamesAndTestScores(numOfStudents, names, testScores);

        // Assign the Return Value for averageTestScore,
        //     by Calling the calAverageTestScore Method, Passing testScores array In
        double averageTestScore = calAverageTestScore(testScores);

        // Assign the Return Value for varianceTestScore,
        //     by Calling the calVarianceTestScore Method,
        //     Passing numOfStudents, averageTestScore, testScores In
        double varianceTestScore = calVarianceTestScore(numOfStudents, averageTestScore, testScores);

        // Call displayInfo Methods for Displaying Original Outputs,
        //     Passing header1, names, testScores In
        displayInfo(header1, names, testScores);

        // Call sortNamesAndTestScores Method to Sort the Data by Test Scores,
        //     Passing testScores, names In
        sortNamesAndTestScores(testScores, names);

        // Call displaySortedInfo Methods for Displaying Sorted Outputs,
        //     Passing header2, names, testScores In
        displaySortedInfo(header2, names, testScores);

        // Call displayAverageVariance Methods for Displaying Average and Variance results,
        //     Passing averageTestScore, varianceTestScore In
        displayAverageVariance(averageTestScore, varianceTestScore);

    } // Main

    // Methods

    // 1)
    ///getNumberOfStudents - Ask for Number of Students, and Return the Number,
    ///                      The Number of Students Must Be Greater Than 0.
    ///@param - None
    ///@return: Return an integer number
    public static int getNumberOfStudents() {  // Method Header

        System.out.println("Enter the number of students (over 0): ");

        int num = inputs.nextInt();

        // Validate the Number Is Greater Than 0
        while(num <= 0) {
            System.out.println("Invalid input! Must be over 0! Try again. ");
            num = inputs.nextInt();
        }

        // Return the Value of num
        return num;

    }  //getNumberOfStudents


    // 2)
    ///getNamesAndTestScores - Ask to Enter the Name and Test Score for each student
    ///                         and Store the Data in 2 Arrays,
    ///                         One for Name, One for Test Score.
    ///@param - num [int] the number of students
    ///@param - names[] [String[]] string type array of names
    ///@param - testScores[] [double[]] double type array of test scores
    ///@return: None
    public static void getNamesAndTestScores(int num, String[] names, double[] testScores) {  // Method Header

        for (int i = 0; i < num; i++) {
            // Get the Name
            System.out.println("Enter a name of a student: ");
            String name = inputs.next();
            // Capitalize the First Letter
            names[i] = name.substring(0, 1).toUpperCase() + name.substring(1);

            // Get the Test Score
            System.out.println("Enter the score for the student: ");
            testScores[i] = inputs.nextDouble();

        }
    }  //getNamesAndTestScores


    // 3)
    ///calAverageTestScore - Calculates and Returns the Average of the Test Scores.
    ///@param - testScores[] [double[]] The double type array of test Scores
    ///@return: The double type of average of test Score
    public static double calAverageTestScore(double[] testScores) {  // Method Header

        double totalScore = 0.0;

        // Get the Total Score
        for (double testScore : testScores) {
            totalScore += testScore;
        }

        // Return the Average of Total Score
        return totalScore / testScores.length;

    }  //calAverageTestScore


    // 4)
    ///calVarianceTestScore - Calculates and Returns the Average of the Test Scores.
    ///@param - num [int] the number of students
    ///@param - avg [double] the average of the test scores
    ///@param - testScores[] [double[]] The double type array of test Scores
    ///@return: The double type of variance of test Score
    public static double calVarianceTestScore(int num, double avg, double[] testScores) {  // Method Header

        double sumOfDifferent = 0.0;

        // Calculate the Total of the Difference
        for (int i = 0; i < num; i++) {
            sumOfDifferent += Math.pow(testScores[i] - avg, 2);
        }

        // Return the Variance Value
        return sumOfDifferent / (num - 1);

    }  //calVarianceTestScore


    // 5)
    ///sortNamesAndTestScores - Sort the data by test score in increasing order.
    ///@param - names[] [String[]] string type array of names
    ///@param - testScores[] [double[]] double type array of test scores
    ///@return: None
    public static void sortNamesAndTestScores(double[] testScores, String[] names) {  // Method Header

        String tempNames;
        double tempTestScores;

        // Bubble Sort Method
        for (int i = 1; i < testScores.length; i++) {
            for (int j = 0; j < testScores.length - i; j++) {

                if (testScores[j] > testScores[j+1]) {  // Ascending order
                    // Swapping the Test Scores
                    tempTestScores = testScores[j];
                    testScores[j] = testScores[j+1];
                    testScores[j+1] = tempTestScores;

                    // Swapping the Names
                    tempNames = names[j];
                    names[j] = names[j+1];
                    names[j+1] = tempNames;
                }

            }
        }
    }  //sortNamesAndTestScores


    // Extra Methods

    // 6)
    ///displayInfo - Display the Data in Its Original Form.
    ///@param - header [String] header for the display
    ///@param - names[] [String[]] string type array of names
    ///@param - testScores[] [double[]] double type array of test scores
    ///@return: None
    public static void displayInfo(String header, String[] names, double[] testScores) {  // Method Header

        System.out.printf("%n%n%s%n", header);
        // Print Out Each of the data
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-8s\t%-8.2f%n", names[i], testScores[i]);
        }
        System.out.println("\n");


    }  // displayInfo


    // 7)
    ///displaySortedInfo - Display the Sorted Data.
    ///@param - header [String] header for the display
    ///@param - names[] [String[]] string type array of names
    ///@param - testScores[] [double[]] double type array of test scores
    ///@return: None
    public static void displaySortedInfo(String header, String[] names, double[] testScores) {  // Method Header

        System.out.printf("%n%s%n", header);
        // Print Out Each of the data
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-8s\t%-8.2f%n", names[i], testScores[i]);
        }

    }  // displaySortedInfo


    // 8)
    ///displayAverageVariance - Display the Average and Variance.
    ///@param - average [double] average of the test score
    ///@param - variance [double] variance of the test score
    ///@return: None
    public static void displayAverageVariance(double average, double variance) {  // Method Header
        System.out.printf("%nAverage = %.2f %n", average);
        System.out.printf("Variance = %.2f %n%n", variance);
    }  //displayAverageVariance


}