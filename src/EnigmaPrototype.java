import java.util.Arrays;

public class EnigmaPrototype {
    public static void main(String[] args) {new EnigmaPrototype().go();}

    void go (){

        int shift=3;
        String secretMessage="abcdefg";
        String lowerCaseMessage = secretMessage.toLowerCase();
        char[] secretMessageArray = lowerCaseMessage.toCharArray();
        char[] alphabet = new char[29];
        alphabet[26]='æ';
        alphabet[27]='ø';
        alphabet[28]='å';
        for (int i=0; i<alphabet.length-3; i++){
            alphabet[i]=(char)((i)+'a');
            //System.out.print(alphabet[i]+" ");
        }
        for (char c : alphabet) {
            System.out.print(c + " ");
        }
        System.out.println();

        int[] num = new int[29];

        for (int i=0; i< num.length; i++){
            num[i]=i+1;
            System.out.print(num[i] + " ");
        }

        int[] numberSecretMessage = lettersToNumbers(alphabet,secretMessageArray,secretMessageArray.length);
        System.out.println(Arrays.toString(numberSecretMessage));
        /*
        for (int i=0; i<secretMessageArray.length-1; i++){
            int shiftedIndex = alphabet[i+shift]; //går gennem hver bogstav og tager index+shift
            char newIndexValue = alphabet[shiftedIndex]; //
            secretMessageArray[i] = secretMessageArray[shiftedIndex];
        }*/
    }

    int[] lettersToNumbers (char[] arralph, char[] arrmessage, int messageLength){
        int[] secretMessageNumbers = new int[messageLength];
        for (int i=0; i<arrmessage.length; i++){
            for (int j=0; j< arralph.length;j++){
                if (arrmessage[i]==arralph[j]){
                    secretMessageNumbers[j]=i;
                }
            }
        }
        return secretMessageNumbers;
    }

}
