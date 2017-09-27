import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by emka15 on 2017-09-27.
 */
public class fileCopy {
    public static void main(String[] args) {
        System.out.println("Skriv in filnamnet");
        Scanner myScanner = new Scanner(System.in);
        String fil = myScanner.next();
        System.out.println("Skriv 1 om du vill kopiera binärt." +
                "Skriv 2 om du vill kopiera som text");
        try {

            int choice = myScanner.nextInt();
            if (choice == 1) {
                binaryCopy(fil);
            } else if (choice == 2) {
            } else System.out.println("Du skrev fel nummer, Sopa");
        } catch (InputMismatchException e) {
            System.out.println("SKRIV ETT NUMMER!");
        }
    }

    public static void binaryCopy(String fil) {
        int x;
        try {
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(fil)));
            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("KopiaA" + fil)));
            try {
                do {
                    x = input.readInt();
                    output.writeInt(x);
                } while (true);
            } catch (EOFException e) {
            }
            output.flush();
            output.close();
        } catch (IOException e) {
            System.out.println("Kan inte hitta fil, stänger ner");
            return;
        }
    }

    public static void textCopy(String fil) {
        try {
            FileWriter fw = new FileWriter(fil);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter utFil = new PrintWriter(bw);

            FileReader fr = new FileReader(fil);
            BufferedReader inFil = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            System.out.println("Kan inte hitta fil, stänger ner");
            return;
        }
    }
}