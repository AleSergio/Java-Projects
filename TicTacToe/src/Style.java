class Style extends CheckSolution {

    public void chooseStyle() {

        boolean style = false;
        int counter;
        int choosenStyle = 0;
        String line;

        while (!style) {
            System.out.println("Input command:");

            line = scanner.nextLine();
            String[] text = line.split(" ");
            counter = text.length;

            if (counter == 3 && text[0].equals("start") && text[1].equals("easy") && text[2].equals("easy")) {
                choosenStyle = 1;
                style = true;

            } else if (counter == 3 && text[0].equals("start") && text[1].equals("user") && text[2].equals("easy") || counter == 3 && text[0].equals("start") && text[1].equals("easy") && text[2].equals("user")) {
                choosenStyle = 2;
                style = true;

            } else if (counter == 3 && text[0].equals("start") && text[1].equals("user") && text[2].equals("user")) {
                choosenStyle = 3;
                style = true;
            } else if (counter == 3 && text[0].equals("start") && text[1].equals("user") && text[2].equals("medium") || counter == 3 && text[0].equals("start") && text[1].equals("medium") && text[2].equals("user")) {
                choosenStyle = 4;
                style = true;

            } else if (counter == 3 && text[0].equals("start") && text[1].equals("medium") && text[2].equals("medium") || counter == 3 && text[0].equals("start") && text[1].equals("easy") && text[2].equals("medium") || counter == 3 && text[0].equals("start") && text[1].equals("medium") && text[2].equals("easy")) {
                choosenStyle = 5;
                style = true;

            }  else if (text[0].equals("exit")) {
                System.exit(1);
            } else {
                System.out.println("Bad parameters!");
            }
        }

        createField();

        ChosenStyle chStyle = new ChosenStyle();

        switch (choosenStyle) {
            case 1:
                chStyle.botBot();
                break;
            case 2:
                chStyle.userPlay(2);
                break;
            case 3:
                chStyle.userPlay(3);
                break;
            case 4:
                chStyle.userPlay(4);
                break;
            case 5:
                chStyle.mediumMedium();
                break;
        }
    }
}
