package Controller;

import BankPac.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankController
{


    public static void main(String[] args) throws InputMismatchException, IOException, ClassNotFoundException {
        Bank bank = Bank.getInstance();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        System.out.println("To open database press 1.\n" +
                            "To create a new database press 2.");
        int choiseDB = sc.nextInt();
        // Open Serializable object from file
        if (choiseDB == 1)
        {
            FileInputStream fileInputStream = new FileInputStream("BankUsers.ser");
            FileInputStream fileInputStreamMap = new FileInputStream("BankLogin.ser");
            ObjectInputStream os = new ObjectInputStream(fileInputStream);
            ObjectInputStream os1 = new ObjectInputStream(fileInputStreamMap);
            Object one = os.readObject();
            Object two = os1.readObject();
            ArrayList<User> result = (ArrayList<User>) one;
            HashMap<String, String> resultMap = (HashMap<String, String>) two;
            os.close();
            os1.close();
            bank.openSave(result, resultMap); // set list witch users in Bank from list from Serializable file

            System.out.println("For login like Administrator press 1.\n" +
                    "For login like a user press 2.");
            int choiseLogin = sc.nextInt();
            if (choiseLogin == 1)
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter login");
                String login = scanner.nextLine();
                System.out.println("Enter password");
                String pass = scanner.nextLine();
                if (bank.checkLogin(login, pass))
                {
                    menu.adminMenu();
                }
                else System.out.println("Login or password the incorrect");
            } else if (choiseLogin == 2)
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter name");
                String loginName = scanner.nextLine();
                System.out.println("Enter Surname");
                String loginSurname = scanner.nextLine();
                String login = loginName+loginSurname;
                System.out.println("Enter password");
                String pass = scanner.nextLine();
                if (bank.checkLogin(login, pass))
                {
                    menu.setUserSurname(loginSurname);
                    menu.setUserName(loginName);
                    menu.userMenu();
                }
                else
                {
                    System.out.println("Login or password the incorrect. \n" +
                            "Do you wanna create the new account? (Yes/No)");
                    Scanner scanner1 = new Scanner(System.in);
                    String choiseOfRegistr = scanner1.nextLine();
                    if (choiseOfRegistr.equalsIgnoreCase("yes"))
                    {
                        System.out.println("Enter the type of user card: 1.Bronze, 2.Silver, 3.Gold");
                        int choiseCardType = 0;
                        CardType type = null;
                        while (type == null) {
                            choiseCardType = scanner1.nextInt();
                            if (choiseCardType == 1)
                                type = CardType.BRONZE;
                            else if (choiseCardType == 2)
                                type = CardType.SILVER;
                            else if (choiseCardType == 3)
                                type = CardType.GOLD;
                            else
                                System.out.println("Enter 1, 2, or 3, no more");
                        }
                        bank.addUser(type);
                        bank.saveList();
                    }
                }
            }
        } else
        {
            bank.createAdmin();
            menu.adminMenu();
            }
        }
    }
