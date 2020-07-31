import java.util.Scanner;

class Coffee {

    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    Scanner scanner = new Scanner(System.in);

    private void machineResources() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money\n");
    }

    protected void selectActivity() {
        boolean work = true;

        while(work) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String activity = scanner.nextLine();

            if (activity.equals("buy")) {
                buyActivity();
            } else if (activity.equals("fill")) {
                fillActivity();
            } else if (activity.equals("take")) {
                takeActivity();
            } else if (activity.equals("remaining")){
                machineResources();
            } else if (activity.equals("exit")){
                work = false;
            }
        }
    }

    private void buyActivity() {

        int spendWater = 0, spendBeans = 0, spendMilk = 0, fillMoney = 0;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                spendWater = 250;
                spendBeans = 16;
                fillMoney = 4;
                break;
            case "2":
                spendWater = 350;
                spendMilk = 75;
                spendBeans = 20;
                fillMoney = 7;
                break;
            case "3":
                spendWater = 200;
                spendMilk = 100;
                spendBeans = 12;
                fillMoney = 6;
                break;
        }

        if (spendBeans > beans){
            System.out.println("Sorry, not enough beans!");
        } else if (spendWater > water) {
            System.out.println("Sorry, not enough water!");
        } else if (spendMilk > milk){
            System.out.println("Sorry, not enough milk!");
        } else if (choice.equals("back")) {

        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= spendWater;
            beans -= spendBeans;
            milk -= spendMilk;
            money += fillMoney;
            cups--;
        }
    }

    private void fillActivity() {

        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();

    }

    private void takeActivity() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}
