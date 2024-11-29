package dni.ex;

import java.util.Scanner;

public class DniView {

    private static Scanner scanner = new Scanner(System.in);

    public static int askNumberDni(){
        while (true) {
            try {
                System.out.println("------------ Calculate Letter DNI ------------");
                System.out.println("Enter the DNI number: ");
                int dniNumber = scanner.nextInt();

                if(dniNumber >= 0 && dniNumber < 99999999){
                    return dniNumber;    
                    
                }else{
                    System.err.println("The DNI number must be between 0 and 99999999 ");
                }  
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a valid DNI number.");
                scanner.nextLine();

            }
                      
        }
    }

    public static void showsLetterDni(char letterDni, int dni){
        System.out.println("--------------------------------");
        System.out.println("The DNI letter is: " + letterDni);
        System.out.println("The Full Identification number is: " + letterDni+dni);
    
    }
    
}
