package BankPac;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Bank bank = Bank.getInstance();
    String userSurname;
    String userName;
    Scanner sc = new Scanner(System.in);

    public void adminMenu() {
        // Information message to output little menu of programm
        String infoString = "To add client press 1.\n" +
                "To print all clients press 2.\n" +
                "To find client by id press 3.\n" +
                "To find client by surname press 4.\n" +
                "To add money to client press 5.\n" +
                "To transaction between clients press 6.\n" +
                "To save the users database and exit press 7.";
        System.out.println(infoString);
        boolean bool = true; // while bool - true, programm is working
        try {
            while (bool) {
                int adminsEnter = sc.nextInt(); // user choise
                if (adminsEnter == 1) {
                    System.out.println("Enter the type of user card: 1.Bronze, 2.Silver, 3.Gold");
                    int choiseCardType = 0;
                    ClassCard type = null;
                    boolean cardClassSwitch = false;
                    while (type == null) {
                        choiseCardType = sc.nextInt();
                        if (choiseCardType == 1)
                            type = ClassCard.BRONZE;
                        else if (choiseCardType == 2)
                            type = ClassCard.SILVER;
                        else if (choiseCardType == 3)
                            type = ClassCard.GOLD;
                        else
                            System.out.println("Enter 1,2, or 3, no more");
                    }
                    bank.addUser("myPassword", type);
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
                    System.out.print("Enter summ for transaktion: ");
                    float summ = sc.nextFloat();
                    bank.transactionToCard(userCardNumber, summ);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 6) {
                    System.out.print("Enter first user's card number: ");
                    long firstUserCardNumber = sc.nextLong();
                    System.out.print("Enter second user's card number: ");
                    long secondUserCardNumber = sc.nextLong();
                    System.out.print("Enter summ for transaktion: ");
                    float summ = sc.nextInt();
                    bank.transactionUserToUser(firstUserCardNumber, secondUserCardNumber, summ);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 7) {
                    bank.saveList();    // Save object in file
                    bool = false;
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void setUserSurname(String surname)
    {
        this.userSurname = surname;
    }

    public void setUserName(String name)
    {
        this.userName = name;
    }

    public void userMenu() {
        String infoString = "To print you're information press 1.\n" +
                "To transfer money to some user press 2.\n" +
                "To exit press 3.";
        System.out.println(infoString);
        boolean bool = true; // while bool - true, programm is working
        try {
            while (bool) {
                int usersEnter = sc.nextInt(); // user choise
                if (usersEnter == 1) {
                    bank.findUserFromNameSurname(userName, userSurname);
                    System.out.println("");
                    System.out.println(infoString);
                }
                else if (usersEnter == 2) {
                    System.out.print("Enter first user's card number: ");
                    long firstUserCardNumber = sc.nextLong();
                    System.out.print("Enter second user's card number: ");
                    long secondUserCardNumber = sc.nextLong();
                    System.out.print("Enter summ for transaktion: ");
                    float summ = sc.nextInt();
                    bank.transactionUserToUser(firstUserCardNumber, secondUserCardNumber, summ);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (usersEnter == 3) {
                    bool = false;
                    break;
                }
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("You entered not the digit");
        }
    }
}
