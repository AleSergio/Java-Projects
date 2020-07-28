class ChosenStyle extends AI {
    int y, z;
    int Ycord, Zcord;

    public void userPlay(int userChoice) {

        while (!checkWin()) {
            System.out.println("Enter coordinates: ");
            try {
                String cordStr = scanner.nextLine();
                String[] cordChar = cordStr.split(" ");
                y = Integer.parseInt(cordChar[0]);
                z = Integer.parseInt(cordChar[1]);

                Ycord = 3 - z;
                Zcord = y - 1;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (y > 3 || y < 1 || z > 3 || z < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (array[3 - z][y - 1] == 'O' || array[3 - z][y - 1] == 'X') {
                System.out.println("This cell is occupied! Choose another one!");
            } else if (userChoice == 2) {
                userEasy();
            } else if (userChoice == 3) {
                userUser();
            } else if (userChoice == 4) {
                userMedium();
            }
        }
    }

    public void botBot() {

        while (!checkWin()) {
            if (!checkDraw()) {
                mediumAI();
            }
        }
    }

    public void mediumMedium() {

        while (!checkWin()) {
            if (!checkDraw()) {
                mediumAI();
            }
        }
    }

    public void userEasy() {
        array[Ycord][Zcord] = 'X';
        createField();

        if (!checkDraw()) {
            easyAI();
        }
    }

    public void userMedium() {
        array[Ycord][Zcord] = 'X';
        createField();

        if (!checkDraw()) {
            mediumAI();
        }
    }

    public void userUser() {

        if (!checkDraw()) {
            array[Ycord][Zcord] = inputChar();
            createField();
        }
    }
}
