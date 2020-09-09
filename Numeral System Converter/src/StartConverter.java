package converter;

import java.util.Scanner;

import static java.lang.System.exit;

public class StartConverter {

    public void putDetails() {
        Scanner scanner = new Scanner(System.in);
        String sourceBase = "";
        String number = "";
        String newBase = "";

        if (scanner.hasNext()) {
            sourceBase = scanner.nextLine();
            if (checkBase(sourceBase)) {
                error();
            }
        } else {
            error();
        }

        if (scanner.hasNextLine()) {
            number = scanner.nextLine();
            if (checkNumber(number)) {
                error();
            }
        } else {
            error();
        }

        if (scanner.hasNextLine()) {
            newBase = scanner.nextLine();
            if (checkBase(newBase)) {
                error();
            }
        } else {
            error();
        }

        Converter converter = new Converter();
        converter.converter(number, Integer.parseInt(sourceBase), Integer.parseInt(newBase));
    }

    protected boolean checkBase(String string) {
        if (string.matches("[0-9]+")) {
            int num = Integer.parseInt(string);
            return num <= 0 || num > Character.MAX_RADIX;
        }
        return true;
    }

    private static boolean checkNumber(String string) {
        return string == null || string.length() == 0;
    }

    private void error() {
        System.out.println("error");
        exit(0);
    }
}
