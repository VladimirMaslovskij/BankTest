package BankPac;

import BankPac.Address;
import BankPac.Bank;
import BankPac.Card;

import java.util.Scanner;

public class BankController
{


    public static void main(String[] args)
    {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        // Информационное сообщение, предполагающее небольшое меню для вывода информации о возможностях
        String infoString = "To add client press 1.\n" +
                        "To print all clients press 2.\n" +
                        "To find client by id press 3.\n" +
                        "To find client by surname press 4.\n" +
                        "To add money to client press 5.\n" +
                        "To transaction between cliens press 6.\n" +
                        "To exit press 7.";
        System.out.println(infoString);
        boolean bool = true; // цикл, в котором пока пользователь не введет 7, будет приниматься действие
        while (bool) {
            int adminsEnter = sc.nextInt(); // То, что нажал оператор программы
            if (adminsEnter == 1) {
                bank.addUser("myPassword");
                System.out.println("");
                System.out.println(infoString); // После каждого исопльзования программы, меню выводится заново
            }
            else if (adminsEnter == 2) {
                bank.printUsers();
                System.out.println("");
                System.out.println(infoString);
            }
            else if (adminsEnter == 3) {
                System.out.print("Enter user's ID: ");
                long id = sc.nextLong();
                bank.findUserFromId(id);
                System.out.println("");
                System.out.println(infoString);
            }
            else if (adminsEnter == 4) {
                System.out.print("Enter user's surname: ");
                String surname = sc.nextLine();
                bank.findUserFromSurname(surname);
                System.out.println("");
                System.out.println(infoString);
            }
            else if (adminsEnter == 5) {
                System.out.print("Enter user's ID: ");
                long userId = sc.nextLong();
                System.out.print("Enter summ for transaktion: ");
                float summ = sc.nextFloat();
                bank.transactionToCard(userId, summ);
                System.out.println("");
                System.out.println(infoString);
            }
            else if (adminsEnter == 6) {
                System.out.print("Enter first user's ID: ");
                long firstUserId = sc.nextLong();
                System.out.print("Enter second user's ID: ");
                long secondUserId = sc.nextLong();
                System.out.print("Enter summ for transaktion: ");
                float summ = sc.nextFloat();
                bank.transactionUserToUser(firstUserId, secondUserId, summ);
                System.out.println("");
                System.out.println(infoString);
            }
            else if (adminsEnter == 7) {
                bool = false;
                break;
            }
        }

    }

}