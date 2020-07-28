import java.util.Scanner;

class Structure {

    final int length = 3;
    Scanner scanner = new Scanner(System.in);
    char[][] array = new char[length][length];
    char result = 'p';
    int x = 0, o = 0;

    public char[][] createArray() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                array[i][j] = '_';
            }
        }
        return array;
    }

    public void countChars() {
        int temp1 = 0, temp2 = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (array[i][j] == 'X') {
                    temp1++;
                } else if (array[i][j] == 'O') {
                    temp2++;
                }
            }
        }

        x = temp1;
        o = temp2;
        temp1 = 0;
        temp2 = 0;
    }

    public char inputChar() {
        countChars();

        if (x > o) {
            result = 'O';
        } else if (x == o) {
            result = 'X';
        }
        return result;
    }
}
