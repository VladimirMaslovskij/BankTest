package BankPac;

import BankPac.Address;
import BankPac.Bank;
import BankPac.Card;

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
                            "To create a new database press any key.");
        int choiseDB = sc.nextInt();
        // Open Serializable object from file
        if (choiseDB == 1)
        {
            FileInputStream fileInputStream = new FileInputStream("E:\\Java\\SavedFiles\\BankUsers.ser");
            FileInputStream fileInputStreamMap = new FileInputStream("E:\\Java\\SavedFiles\\BankLogin.ser");
            ObjectInputStream os = new ObjectInputStream(fileInputStream);
            ObjectInputStream os1 = new ObjectInputStream(fileInputStreamMap);
            Object one = os.readObject();
            Object two = os1.readObject();
            ArrayList<User> result = (ArrayList<User>) one;
            HashMap<String, String> resultMap = (HashMap<String, String>) two;
            os.close();
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
                else System.out.println("Login or password the incorrect");
            }
        } else
        {
            bank.createAdmin();
            menu.adminMenu();
            }
        }
    }
