import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean userOperationControl = true;
        String textRequest1 = "Add meg az első számot: ";
        String textRequest2 = "Add meg a második számot: ";
        String textOperation = "Add meg a műveletet (+,-,*,/): ";

        while(userOperationControl) {
            double number1 = getUserNumberInput1(scanner, textRequest1);
            double number2 = getUserNumberInput2(scanner, textRequest2);
            String operation = getUserOperationInput(scanner, textOperation);

            double res = operationResult(number1, number2, operation);
            System.out.println("Az kért művelet eredménye: " + res);

            boolean userChoiceControl = true;
            while(userChoiceControl) {
                System.out.println("Szeretnél még művelet végezni? (Igen = 1 vagy Nem = 0)");
                int userChoice = scanner.nextInt();
                if (userChoice == 0) {
                    userOperationControl = false;
                    System.out.println("Viszlát!");
                    userChoiceControl = false;
                } else if (userChoice == 1) {
                    userOperationControl = true;
                    userChoiceControl = false;
                } else {
                    System.out.println("Csak 1-essel és 0-ával válaszolhatsz!");
                    userChoiceControl = true;
                }
            }

        }


    }

    private static double getUserNumberInput1(Scanner scanner, String text) {
        System.out.println(text);
        return scanner.nextDouble();
    }

    private static double getUserNumberInput2(Scanner scanner, String text) {
        System.out.println(text);
        return scanner.nextDouble();
    }

    private static String getUserOperationInput(Scanner scanner, String text) {
        boolean operationControl = true;
        String operation = "";

        while (operationControl) {
            System.out.println(text);
            operation = scanner.next();
            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                operationControl = false;
            } else {
                System.out.println("Nem a megadott műveletek közül választottál! Próbáld meg újra! ");
            }
        }

        return operation;
    }

    private static double operationResult(double number1, double number2, String operation){
        double result = 0;

        if (operation.equals("+")) {
            result = number1 + number2;
        } else if (operation.equals("-")) {
            result = number1 - number2;
        } else if (operation.equals("*")) {
            result = number1 * number2;
        } else if (operation.equals("/")) {
            result = number1 / number2;
        }
        return result;
    }

}
