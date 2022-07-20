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

        // Open Serializable object from file
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

        System.out.println("To login to Bank press 1.\n" +
                           "To create a new user press 2.");
        int choiseDB = sc.nextInt();

        if (choiseDB == 1)
        {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter login");
                String email = scanner.nextLine();
                System.out.println("Enter password");
                String pass = scanner.nextLine();
                if (bank.checkAdminLogin(email, pass))
                {
                    menu.adminMenu();
                }
                else if (bank.checkLogin(email, pass))
                {
                    menu.setEmail(email);
                    menu.userMenu();
                }
                else
                {
                    System.out.println("Login or password the incorrect. \n" +
                            "Do you wanna create the new account? (Yes/No)");
                    Scanner scanner1 = new Scanner(System.in);
                    String choiceOfReg = scanner1.nextLine();
                    if (choiceOfReg.equalsIgnoreCase("yes"))
                    {
                        bank.addUser();
                        bank.saveList();
                    }

                }

        } else if (choiseDB == 2)
        {
            bank.addUser();
            menu.adminMenu();
            }
        }
    }
