import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Wall area = new Wall(); // Instantiating our object with the values we have tested for.
        area.setHeight(9);
        getData(); // Starts the program
        System.out.println(area.getArea());

    }

    public static void getData(){

        boolean runAgain = true;

        System.out.println("Hello! This program simply finds the area of a rectangle!");

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What's the width?");
            String stringWidth = scanner.nextLine();
            double width = checker(stringWidth);

            System.out.println("What's the height?");
            String stringHeight = scanner.nextLine();
            double height = checker(stringHeight);

            System.out.println("Width = " + width + " Height = " + height + " Area = " + area(width, height));

            System.out.println("Would you like to find the area of another rectangle?");
            System.out.println("Type 'Y' to continue or press any button to exit.");
            String stringContinue = scanner.nextLine();
            runAgain = runAgain(stringContinue);
        } while (runAgain);

        System.out.println("Thank you for using my program!");

    }
    public static double area(double width, double height) {
        Wall area = new Wall(width,height); // Instantiating our object with the values we have tested for.
        return area.getArea();
    }

    public static double checker(String testValue) {

        Scanner scanner = new Scanner(System.in);

        double validValue = 0;
        boolean isValid;
        do {                      // Do while loop that is handling all the testing. If
            isValid = true;       // a number is negative or contains any character other
            try {                 // than a number, then it will run again.
                validValue = Double.parseDouble(testValue);

                if (validValue < 0 ) {
                    isValid = false;
                    System.out.println("You can not find the area with a negative number!");
                    System.out.println("Please try again.");
                    testValue = scanner.nextLine();
                }
            } catch (NumberFormatException badUserData) {
                isValid = false;
                System.out.println("Only numbers please!");
                System.out.println("Please try again.");
                testValue = scanner.nextLine();
            }

        } while (!isValid);

        return validValue;
    }

    public static boolean runAgain(String stringContinue) {

        return stringContinue.toLowerCase().equals("y");

    }
}
