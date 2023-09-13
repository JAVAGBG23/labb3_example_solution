import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initierar scanner så vi kan använda den
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press 0 to EXIT or 1 to continue: ");

        // skapar en variabel för min scanner
        int input = scanner.nextInt();

        // OBS! jag hade slarvat och inte testa mitt program fullt ut :P
        // man kunde inte efter första frågan trycka 0 och avsluta
        // men nu kan man! så det här kodblocket är tillagt... det var nog så jag tänkte
        // med input variabeln eftersom den fanns men aldrig var använd. Ibland går det lite för fort...
        if(input == 0) {
            System.out.println("Goodbye!");
            System.exit(0);
        }

        // en while loop som har villkoret true, om jag inte ser till att bryta min loop så
        // kommer den köra för alltid
        while (true) {
            System.out.print("Please enter the total amount of the bill: ");

           try {
               // en ny variabel med annan datatyp för att spara ner värdet som usern matar in för notan
               // variabeln för notan måste vara i vår loop
               // vi ser sen till att rensa den med scanner.nextLine(); på rad 59 och 67
               double bill = scanner.nextDouble();

               if (bill >= 50 && bill <= 300) {
                   double tip = bill * 0.15;
                   System.out.println("Total bill value is " + bill + " and amount to tip is: " + tip);
                   System.out.println("Thank you for using Tip Calculator! Have a nice day!");
                   // break bryter loopen
                   break;
               } else if (bill > 300 && bill <= 1000) {
                   double tip = bill * 0.20;
                   System.out.println("Total bill value is " + bill + " and amount to tip is: " + tip);
                   System.out.println("Thank you for using Tip Calculator! Have a nice day!");
                   break;
               } else if (bill > 1000) {
                   double tip = bill * 0.25;
                   System.out.println("Total bill value is " + bill + " and amount to tip is: " + tip);
                   System.out.println("Thank you for using Tip Calculator! Have a nice day!");
                   break;
               } else if (bill == 0) {
                   // om man nu väljer att gå vidare på första frågan
                   // men sen väljer att avsluta och trycka 0 så funkar det också
                   System.out.println("Goodbye!");
                   // avslutar programmet helt och hållet till skillnad från break som
                   // endast avslutar loopen egentligen
                   System.exit(0);
               } else {
                   // om man anger ett negativt tal körs det här
                   System.out.println("Invalid input, please try again!");
                   scanner.nextLine();
               }
           } catch (InputMismatchException e) {
               // om man skriver in bokstäver körs det här
               System.out.println("Error: Value Must be an integer, please try again!");
               // en viktig liten detalj är den här raden
               // den rensar vår scanner variabel så att vi kan ta emot ett nytt värde på notan
               // utan att det ska förstöra vårt program
               scanner.nextLine();
           }
        }
    }
}