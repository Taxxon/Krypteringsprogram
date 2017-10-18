package Krypteringsprogram;

import java.io.*;

/**
 * Created by Emil Käck on 2017-10-18.
 */
public class Encrypt {

    public static void readFile(File keyname, File filename) {

        DataInputStream data = null;
        InputStream input = null;

        DataInputStream data2 = null;
        InputStream input2 = null;

        String file = null;
        String key = null;

        try {
            input = new FileInputStream(filename);
            data = new DataInputStream(input);
            int count = data.available();
            byte[] txt = new  byte[count];
            data.read(txt);

            input2 = new FileInputStream(keyname);
            data2 = new DataInputStream(input2);
            int count2 = data2.available();
            byte[] txt2 = new  byte[count2];
            data2.read(txt2);

            for (byte b:txt){

                char c1 = (char)b;
                file = file + c1;
            }

            for (byte b:txt2){

                char c2 = (char)b;
                key = key + c2;
            }

        } catch (IOException e){
            System.out.println("Kan inte hitta fil, stänger ner");
        }
        System.out.print(crypt(file , key));
    }

    public static String crypt(String m, String k) {
        String result = "";
        
        while (k.length() < m.length())
            k+=k;

        for (int i = 0 ; i < m.length() ; i++) {
            result += (char)(m.charAt(i)^k.charAt(i));
        }
        return result;
    }
}
