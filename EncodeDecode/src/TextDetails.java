import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextDetails implements Files {

    protected String baseString(File send) {
        String base = "";

        try (Scanner scanner = new Scanner(send)) {
            while (scanner.hasNext()) {
                ;
                base = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            return "No file found";

        }
        return base;
    }

    protected String hexString() {
        byte[] bytes = baseString(send).getBytes();
        StringBuilder builder = new StringBuilder();

        for (byte hex : bytes) {
            builder.append(String.format("%02x", hex).toUpperCase()).append(" ");
        }

        return builder.toString().trim();
    }

    protected String binaryString() {
        char[] chars = baseString(send).toCharArray();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            int a = Integer.parseInt(Integer.toBinaryString(chars[i]));
            builder.append(String.format("%08d", a)).append(" ");
        }

        return builder.toString().trim();
    }
}
