import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.Scanner;

class EncoderDecoder extends TextDetails implements Files {

    private String hexEncode() {
        StringBuilder builder = new StringBuilder();
        String[] words = binaryCode("encode").split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = new BigInteger(words[i], 2).toString(16);
            builder.append(word.toUpperCase()).append(" ");
        }

        return builder.toString();
    }

    private String binaryCode(String mode) {

        String[] words = binaryString().split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            int sum = 0;

            if (mode.equals("encode")) {
                sum = Integer.parseInt(words[i], 2) + Integer.parseInt("00000010", 2);
            } else if (mode.equals("decode")) {
                sum = Integer.parseInt(words[i], 2) - Integer.parseInt("00000010", 2);
            }

            int result = Integer.parseInt(Integer.toBinaryString(sum));
            builder.append(String.format("%08d", result)).append(" ");
        }

        return builder.toString();
    }

    private String stringCode(String getStr, int radix) {
        StringBuilder builder = new StringBuilder();
        String[] words = getStr.split(" ");

        for (int i = 0; i < words.length; i++) {
            int a = Integer.parseInt(words[i], radix);
            builder.append((char) a);
        }

        return builder.toString();
    }

    protected void encodeFile() {

        try (FileOutputStream outputStream = new FileOutputStream(encode, false)) {
            outputStream.write(("Original Text: " + baseString(send) + "\n").getBytes());
            outputStream.write(("Encode text: " + stringCode(hexEncode(), 16) + "\n").getBytes());
            outputStream.write(("Hex Number: " + hexEncode() + "\n").getBytes());
            outputStream.write(("Binary Number: " + binaryCode("encode") + "\n").getBytes());

        } catch (Exception e) {
            System.out.println("");
        }
    }

    protected void decodeFile() {

        try (FileOutputStream outputStream = new FileOutputStream(decode, false)) {

            outputStream.write(("Encode text: " + baseString(send) + "\n").getBytes());
            outputStream.write(("Decode text: " + stringCode(binaryCode("decode"), 2) + "\n").getBytes());
            outputStream.write(("Hex Number: " + hexString() + "\n").getBytes());
            outputStream.write(("Binary Number: " + binaryCode("decode") + "\n").getBytes());


        } catch (Exception e) {
            System.out.println("");
        }
    }

    protected void chooseMode() {
        System.out.println("Write command: ");
        Scanner scanner = new Scanner(System.in);
        String mode = scanner.nextLine();

        if (mode.equals("encode")) {
            encodeFile();
        } else if (mode.equals("decode")) {
            decodeFile();
        }
    }
}
