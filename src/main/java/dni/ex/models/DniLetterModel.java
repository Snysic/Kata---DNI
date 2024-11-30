package dni.ex.models;

public class DniLetterModel {
    private static final char[] LETTERS = {
        'T', 'R', 'W', 'A', 'G', 'M', 'Y', 
        'F', 'P', 'D', 'X', 'B', 'N', 'J', 
        'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 
        'K', 'E'
    };

    public static char calculateLetterDni(DniModel numberDni) {
       
        int module = numberDni.getNumberDNI() % 23;
        char dniLetter = LETTERS[module];

        return(dniLetter);         
    }

}
