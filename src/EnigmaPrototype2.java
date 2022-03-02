import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

public class EnigmaPrototype2 {
    public static void main(String[] args) {new EnigmaPrototype2().go();}
    void go(){
        introduction();
        introMainMenu();
        mainMenu();
    }
    void introduction (){
        System.out.println("Welcome to this cryptography program\n");
    }
    void introMainMenu(){
        System.out.println("- Main menu -\nWhat type of encryption do you want?");
        System.out.print("Type: \n1 for Caesar\n2 for Vinegere\n3 for letter to number\n0 to exit: ");
    }

    void mainMenu(){
        String userInputMainMenu;
        Scanner sc = new Scanner(System.in);
        userInputMainMenu = sc.nextLine();
        switch (userInputMainMenu) {
            case "1" -> caesarOctopusFunction();
            case "2" -> vinegere();
            //case "3" -> takeInputLetterToNumber();
            case "0" -> exitFunction();
            default -> {
                System.out.print("Type 1, 2, 3 or 0: ");
                mainMenu();
            }
        }
    }

    void caesarOctopusFunction(){
        introCaesarEncryptionMenu();
        caesarEncryptionMenu();
    }

    void introCaesarEncryptionMenu(){
        System.out.print("\nCaesar encryption menu");
        System.out.print("\nType 'e' to encrypt and 'd' to decrypt and 0 to exit: ");
    }

    void caesarEncryptionMenu(){
        Scanner sc = new Scanner(System.in);
        String userInputcaesarEncryptionMenu = sc.nextLine();
        switch (userInputcaesarEncryptionMenu){
            case "e" -> caesarEncryptionTakeInformation();
            //case "d" -> funktion;
            case "0" -> exitFunction();
            default -> {
                System.out.println("Type 'e', 'd', or 0: ");
            }
        }
    }
    void caesarEncryptionTakeInformation(){
        String secretMessageInput = "awert åøt";
        String secretMessage = secretMessageInput.toLowerCase();
        String alphabet = " abcdefghijklmnopqrstuvwxyzæøå";
        int shift=3;

        int[] numberSecretMessage = letterToNumber(secretMessage,alphabet);
        //System.out.println("Letter to number: " + Arrays.toString(numberSecretMessage)+" "); //printer nummer-streng
        char[] encryptedsecretMessage = numberToLetter(numberSecretMessage,secretMessage,alphabet,shift);
        //System.out.println("Encrypted message: " + Arrays.toString(encryptedsecretMessage));
        printArrays(encryptedsecretMessage);
    }

    void printArrays(char[] array){
        for (char c : array) {
            System.out.print(c + " ");
        }
    }
    void printArrays(int[] array){ //method overflow
        for (int i : array){
            System.out.print(array[i]+" ");
        }
    }

    int[] letterToNumber(String secretMessage,String alphabet){
        int[] numberSecretMessage = new int[secretMessage.length()];
        for (int i=0; i<secretMessage.length();i++){
            char whatIsEachCharInSecretMessageAtEveryIndex = secretMessage.charAt(i); //bogstav char af hver index i secretMessage
            int indexPositionOfCharInSecretMessageInAlphabet = alphabet.indexOf(whatIsEachCharInSecretMessageAtEveryIndex); //ser på hvor de bogstav er i alfabetet
            numberSecretMessage[i]=indexPositionOfCharInSecretMessageInAlphabet; //laver nummer-streng af hvad bogstaverne i secret message svarer til
            //System.out.print(numberSecretMessage[i]+" ");
        }
        return numberSecretMessage;
    }

    char[] numberToLetter(int[] numberSecretMessage, String secretMessage, String alphabet, int shift){
        char[] secretMessageAfterShift = new char[secretMessage.length()];
        for (int i=0; i<secretMessage.length(); i++){
            int numberSecretMessagePlusShift = numberSecretMessage[i]+shift;
            if (numberSecretMessagePlusShift == shift){ //dvs hvis et tegn i secretMessage er melelmrum
                //vil tegnet plus shift være et eller andet. Så skal shift trækkes fra det så det bliver mellemrum igen
                numberSecretMessagePlusShift-=shift;
            }
            if (numberSecretMessagePlusShift >= alphabet.length()){
                numberSecretMessagePlusShift = numberSecretMessagePlusShift-30+1; //+1 pga blankspace i starten
            }
            secretMessageAfterShift[i] = alphabet.charAt(numberSecretMessagePlusShift);
        }
        //System.out.println(Arrays.toString(secretMessageAfterShift)+" ");
        return secretMessageAfterShift;
    }
    void vinegere(){
        System.out.println("Empty");
    }

    void exitFunction(){
        getRuntime().halt(0);
    }



}
