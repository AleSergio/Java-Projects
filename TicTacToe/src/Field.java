class Field extends Structure {

    char[][] array = createArray();

    public void createField() {

        System.out.println("---------");
        for (int i = 0; i < length; i++) {
            System.out.print("| ");
            for (int j = 0; j < length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
