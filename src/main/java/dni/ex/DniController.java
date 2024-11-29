package dni.ex;

import dni.ex.DniModel;
import dni.ex.DniView;

public class DniController {
    public DniController(){
        startProgram();
    }

    public static void startProgram(){
        int dniNumber = DniView.askNumberDni();
        DniModel dni = new DniModel(dniNumber);
        char letter = DniLetterModel.calculateLetterDni(dni);
        showsLetterDni(letter, dniNumber);

    }

    public static void showsLetterDni(char letter, int dniNumber) {
        DniView.showsLetterDni(letter, dniNumber);
        
    }
    
}
