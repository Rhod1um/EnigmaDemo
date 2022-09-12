public class DemoStringBuilder {
    public static void main(String[] args) {
        String text = "hej";

        String newText = "";
        String newText2="";

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char tmp = text.charAt(i);
            newText += tmp;
            //lægger hver bogstav i en streng ind i en ny streng. Ineffektivt
            //laver nu string objekt for hver iteration, det tager meget RAM

            builder.append(tmp); //StringBuilder objektet builder ovenover får hver bogtav ind

            newText2 = builder.toString();

            System.out.println("streng: "+newText2);
        }

        //String builder gradvist bygger en streng op og laver først en rigtig streng til sidst
        //så den bruger ikke ekstra RAM
    }
}
