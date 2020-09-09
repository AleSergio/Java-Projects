package converter;

public class Converter {

    public void converter(String number, int sourceBase, int newBase) {
        int baseInteger;
        double baseFraction = 0;
        String intNumber, fracNumber = "";
        StringBuilder result = new StringBuilder();

        if (number.contains(".")) {
            String[] split = number.split("\\.");
            intNumber = split[0];
            fracNumber = split[1];
        } else {
            intNumber = number;
        }

        if (sourceBase != 10 && sourceBase != 1) {
            baseInteger = Integer.parseInt(intNumber, sourceBase);
        } else if (sourceBase == 1) {
            baseInteger = intNumber.length();
        } else {
            baseInteger = Integer.parseInt(intNumber);
        }

        if (newBase == 1) {
            result.append("1".repeat(Math.max(0, baseInteger)));
        } else {
            result.append(Integer.toString(baseInteger, newBase));
        }
        result.append(".");

        if (fracNumber.length() > 0) {

            if (sourceBase == 10) {
                baseFraction = Double.parseDouble(number) - baseInteger;
            } else {
                for (int i = 0; i < fracNumber.length(); i++) {
                    baseFraction += Integer.parseInt(fracNumber.substring(i, i + 1), sourceBase) / Math.pow(sourceBase, i + 1);
                }
            }

            baseFraction = baseFraction * newBase;
            int intFraction = (int) baseFraction;
            result.append(Integer.toString(intFraction, newBase));
            baseFraction -= intFraction;

            for (int i = 1; i <= 4; i++) {
                baseFraction *= newBase;
                intFraction = (int) baseFraction;
                result.append(Integer.toString(intFraction, newBase));
                baseFraction -= intFraction;
            }
        }
        System.out.println(result.toString());
    }
}
