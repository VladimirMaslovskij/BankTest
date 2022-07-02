package BankPac;

import BankPac.Address;
import BankPac.Bank;
import BankPac.Card;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankController
{


    public static void main(String[] args) throws InputMismatchException
    {
        Bank bank = Bank.getInstance();
        Scanner sc = new Scanner(System.in);
        // Information message to output little menu of programm
        String infoString = "To add client press 1.\n" +
                        "To print all clients press 2.\n" +
                        "To find client by id press 3.\n" +
                        "To find client by surname press 4.\n" +
                        "To add money to client press 5.\n" +
                        "To transaction between cliens press 6.\n" +
                        "To exit press 7.";
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
                    System.out.print("Enter user's ID: ");
                    long userId = sc.nextLong();
                    System.out.print("Enter summ for transaktion: ");
                    float summ = sc.nextFloat();
                    bank.transactionToCard(userId, summ);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 6) {
                    System.out.print("Enter first user's ID: ");
                    long firstUserId = sc.nextLong();
                    System.out.print("Enter second user's ID: ");
                    long secondUserId = sc.nextLong();
                    System.out.print("Enter summ for transaktion: ");
                    float summ = sc.nextInt();
                    bank.transactionUserToUser(firstUserId, secondUserId, summ);
                    System.out.println("");
                    System.out.println(infoString);
                } else if (adminsEnter == 7) {
                    bool = false;
                    break;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("You entered not the digit");
        }

    }

}