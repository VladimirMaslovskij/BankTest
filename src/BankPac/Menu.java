package BankPac;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Bank bank = Bank.getInstance();
    String userEmail;

    public void adminMenu() {
        // Information message to output little menu of programm
        String infoString = "1. - To add client.\n" +
                "2. - To print all clients.\n" +
                "3. - To find client by id.\n" +
                "4. - To find client by surname.\n" +
                "5. - To add money to client.\n" +
                "6. - To transfer money between clients.\n" +
                "7. - To save the changes.\n" +
                "10. - To exit.";
        System.out.println(infoString);
        boolean isWorking = true; // while isWorking - true, programm is working
        try {
            while (isWorking) {
                Scanner sc = new Scanner(System.in);
                int adminsEnter = sc.nextInt(); // user choise
                if (adminsEnter == 1) {
                    bank.addUser();
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 2) {
                    bank.printUsers();
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 3) {
                    System.out.print("Enter user's ID: ");
                    long id = sc.nextLong();
                    bank.findUserFromId(id);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 4) {
                    System.out.print("Enter user's surname: ");
                    String surname = sc.nextLine();
                    bank.findUserFromSurname(surname);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 5) {
                    System.out.print("Enter user's card number: ");
                    long userCardNumber = sc.nextLong();
                    System.out.print("Enter sum of transfer: ");
                    float summ = sc.nextFloat();
                    bank.transactionToCard(userCardNumber, summ);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 6) {
                    System.out.print("Enter first user's card number: ");
                    long firstUserCardNumber = sc.nextLong();
                    System.out.print("Enter second user's card number: ");
                    long secondUserCardNumber = sc.nextLong();
                    System.out.print("Enter sum of transfer: ");
                    float sum = sc.nextInt();
                    bank.transactionUserToUser(firstUserCardNumber, secondUserCardNumber, sum);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 7) {
                    bank.saveList();
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 10) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }



    public void setEmail(String email)
    {
        this.userEmail = email;
    }

    public void userMenu() {
        String infoString = "To print you're information press 1.\n" +
                "To transfer money to some user press 2.\n" +
                "To exit press 3.";
        System.out.println(infoString);
        boolean isExit = true; // while bool - true, program is working
        try {
            while (isExit) {
                Scanner sc = new Scanner(System.in);
                int usersEnter = sc.nextInt(); // user chose
                if (usersEnter == 1) {
                    bank.findUserFromLogin(userEmail);
                    System.out.println("");
                    System.out.println(infoString);
                }
                else if (usersEnter == 2) {
                    System.out.print("Enter first user's card number: ");
                    long firstUserCardNumber = sc.nextLong();
                    System.out.print("Enter second user's card number: ");
                    long secondUserCardNumber = sc.nextLong();
                    System.out.print("Enter sum of transfer: ");
                    float summ = sc.nextInt();
                    bank.transactionUserToUser(firstUserCardNumber, secondUserCardNumber, summ);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (usersEnter == 3) {
                    bank.saveList();
                    break;
                }
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("You entered not the digit");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
