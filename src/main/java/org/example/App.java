/* Gabriel Fernandez
 * COP3330 - Summer CV01
 * "Motivated" Practice Exercises
 * Exercise 19 - BMI Calculator
 */

package org.example;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class App
{

    // Main function
    public static void main( String[] args )
    {
        // Declare constants and initialize string prompts
        final double IDEAL_LOWER = 18.5;
        final double IDEAL_HIGHER = 25;
        String weightPrompt = "What is your weight? (lbs)";
        String heightPrompt = "What is your height? (inches)";

        // Loop user input until they enter a number, then store
        // that value
        double weight = getDouble(weightPrompt);
        double height = getDouble(heightPrompt);

        // Round to two decimal places
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.CEILING);

        // Calculate the BMI
        double bmi = (weight / (height * height)) * 703;

        // Print the result
        System.out.println("Your BMI is " + df.format(bmi) + ".");

        // If the user's BMI is under the lower bound, the user is underweight
        if (bmi < IDEAL_LOWER) {
            System.out.println("You are underweight. You should see your doctor.");
        }
        // If the user's BMI is between both bounds, the user is in the ideal range
        else if (bmi >= IDEAL_LOWER && bmi <= IDEAL_HIGHER) {
            System.out.println("You are within the ideal weight range.");
        }
        // If the user's BMI is neither under or between the ideal range, that means
        // they are above the higher bound, so they are overweight
        else {
            System.out.println("You are overweight. You should see your doctor.");
        }
    }

    // Yes this function is copy pasted from exercise 17, sue me
    // The function loops until the user enters a number
    public static double getDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);

        // Loop until the user inputs an integer
        while (!sc.hasNextDouble()) {
            System.out.println("Sorry, you must enter a number, please try again.");
            sc.nextLine();
        }

        // If we have exited the while loop, that means we had an integer
        // be inputted, so we can return that int
        return sc.nextDouble();
    }
}