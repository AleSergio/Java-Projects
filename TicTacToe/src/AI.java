import java.util.Random;

class AI extends Style {

    int randYcord, randZcord;

    public void easyAI() {

        Random random = new Random();

        randYcord = random.nextInt(3);
        randZcord = random.nextInt(3);

        while (array[randYcord][randZcord] != '_') {
            randYcord = random.nextInt(3);
            randZcord = random.nextInt(3);
        }

        System.out.println("Making move level \"easy\"");
        array[randYcord][randZcord] = inputChar();
        createField();

    }

    public void mediumAI() {

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            if (array[i][0] == array[i][1] && array[i][0] == 'X') {
                randYcord = i;
                randZcord = 2;
                break;

            } else if (array[i][2] == array[i][1] && array[i][2] == 'X') {
                randYcord = i;
                randZcord = 0;
                break;

            } else if (array[i][0] == array[i][2] && array[i][0] == 'X') {
                randYcord = i;
                randZcord = 1;
                break;

            } else if (array[0][i] == array[1][i] && array[0][i] == 'X') {
                randYcord = 2;
                randZcord = i;
                break;

            } else if (array[2][i] == array[1][i] && array[1][i] == 'X') {
                randYcord = 0;
                randZcord = i;
                break;

            } else if (array[0][i] == array[2][i] && array[0][i] == 'X') {
                randYcord = 1;
                randZcord = i;
                break;

            } else {
                randYcord = random.nextInt(3);
                randZcord = random.nextInt(3);
            }
        }

        if ((array[0][0] == array[2][2] || array[0][2] == array[2][0]) && array[0][2] == 'X') {
            randYcord = 1;
            randZcord = 1;
        } else if (array[1][1] == array[0][0] && array[0][0] == 'X') {
            randYcord = 2;
            randZcord = 2;
        } else if (array[1][1] == array[2][2] && array[1][1] == 'X') {
            randYcord = 0;
            randZcord = 0;
        } else if (array[1][1] == array[2][0] && array[1][1] == 'X') {
            randYcord = 0;
            randZcord = 2;
        } else if (array[1][1] == array[0][2] && array[1][1] == 'X') {
            randYcord = 2;
            randZcord = 0;
        }


        while (array[randYcord][randZcord] != '_') {
            randYcord = random.nextInt(3);
            randZcord = random.nextInt(3);
        }

        System.out.println("Making move level \"medium\"");
        array[randYcord][randZcord] = inputChar();
        createField();
    }
}
