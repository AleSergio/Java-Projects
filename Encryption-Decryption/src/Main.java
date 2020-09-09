package encryptdecrypt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, args);

        Logic logic = new Logic();
        logic.checkLine(list);
    }
}

class Logic {

    public void base(String mode, int key, String data, boolean out) {
        if (mode.equals("enc")) {
            encryption(data, key, out);
        } else if (mode.equals("dec")) {
            decryption(data, key, out);
        }
    }

    protected void checkLine(List<String> list) {
        String mode = "enc", data = "";
        int key = 0, count = 0;
        boolean out = false;

        for (int i = 0; i < list.size(); i++) {
            String dataGet = "";

            if (list.get(i).equals("-mode")) {
                mode = list.get(i + 1);
            } else if (list.get(i).equals("-key")) {
                key = Integer.parseInt(list.get(i + 1));
            } else if (list.get(i).equals("-data")) {
                dataGet = list.get(i + 1).replace("\"", "\\\"");
                data = dataGet;
                count++;
            } else if (list.get(i).equals("-out")) {
                out = true;
            } else if (list.get(i).equals("-in")) {
                String fileIn = list.get(i + 1);
                try {
                    File file = new File(fileIn);
                    Scanner sc = new Scanner(file);

                    while (sc.hasNextLine()) {
                        data = sc.nextLine();
                    }

                    sc.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
            } else if (count == 2) {
                data = dataGet;
            }
            base(mode, key, data, out);
        }
    }

    protected void encryption(String message, int key, boolean out) {
        StringBuilder encryptMessage = new StringBuilder();
        for (char arr : message.toCharArray()) {
            encryptMessage.append((char) ((int) arr + key));
        }
        writeFile(encryptMessage.toString(), out);
    }

    protected void decryption(String message, int key, boolean out) {
        StringBuilder decryptMessage = new StringBuilder();
        for (char arr : message.toCharArray()) {
            decryptMessage.append((char) ((int) arr - key));
        }
        writeFile(decryptMessage.toString(), out);
    }

    protected void writeFile(String crypt, boolean out) {
        if (out) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                writer.write(crypt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(crypt);
        }
    }
}

