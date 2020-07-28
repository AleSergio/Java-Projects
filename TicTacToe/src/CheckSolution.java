class CheckSolution extends Field {

    public boolean checkWin() {

        boolean win = false;

        for (int i = 0; i < length; i++) {
            if ((array[i][0] == 'X' || array[i][0] == 'O') && array[i][0] == array[i][1] && array[i][0] == array[i][2]) {
                result = array[i][0];
                win = true;
            }
        }

        for (int i = 0; i < length; i++) {
            if ((array[0][i] == 'X' || array[0][i] == 'O') && array[0][i] == array[1][i] && array[0][i] == array[2][i]) {
                result = array[0][i];
                win = true;
            }
        }


        if ((array[1][1] == 'X' || array[1][1] == 'O') && array[0][0] == array[1][1] && array[0][0] == array[2][2] || (array[1][1] == 'X' || array[1][1] == 'O') && array[0][2] == array[1][1] && array[0][2] == array[2][0]) {
            result = array[1][1];
            win = true;
        }

        if (win) {
            System.out.println(result + " " + "wins");
        } else if (checkDraw()) {
            System.out.println("Draw");
            win = true;
        }

        return win;
    }

    public boolean checkDraw() {

        countChars();
        boolean checkDraw = false;
        int sum = x + o;

        if (sum == 9) {
            checkDraw = true;
        }

        return checkDraw;
    }
}
