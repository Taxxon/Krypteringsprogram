/**
 * Created by Emil Käck on 2017-08-30.
 * A program that test's arguments that it gets from the command interpreter.
 * Depending on how many arguments there is it reacts differently.
 */
public class CMDInput {
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Programmet vet inte vad det ska göra! Avbryter...");
        }else if(args.length == 1){
            System.out.println(args[0]);
        } else if (args.length == 2){
            try {
                int number1 = Integer.parseInt(args[0]);
                int number2 = Integer.parseInt(args[1]);
                int sum = number1 + number2;
                System.out.println("Summan = " + sum);
            }catch (NumberFormatException a){
                System.out.println("Programet förstår inte, var vänlig skriv nummer");
            }
        } else if (args.length == 3) {
            System.out.println(args[2] + " " + args[1] + " " + args[0]);
        } else if (args.length > 3) {
            System.out.println("Jag orkar inte, stänger ner.");
        }

        GUIDesign gui = new GUIDesign();
    }
}
