package BankPac;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank
{
    private static Bank instance;

    private  Bank() {}

    public static Bank getInstance()
    {
        if (instance == null) {
            instance = new Bank();
        }
            return instance;
    }

    HashMap<String, String> logMap = new HashMap<>();


    ArrayList<User> users = new ArrayList<>(); // DATA BASE(NO)




    public void addUser(CardType type)  // Adding one user
    {
            User user = new User();
            user.setUserInfo();  // Set information about user
            users.add(user);
            logMap.put(user.getName() + user.getUserSurname(), user.getPassword());
            user.setUserCard(type);  // adding card to user
            System.out.println("Client was registered");
    }

    public void printUsers() {  // output all users info
        for (User user : users) {
            user.getUserInfo();
            System.out.println("");
        }
    }

    // Find users by id, recommended use after "printUsers()" to know the id
    public User findUserFromId(long id) {
        User result = null;
        for (User user : users) {
            if(id == user.getId()) {
                user.getUserInfo();
                result = user;
            } else {
                System.out.println("User witch ID " + id + " not found");
            }
        }
        return result;
    }

    // Find users by surnames
    public ArrayList<User> findUserFromSurname(String surname) {
        ArrayList<User> users1 = new ArrayList<>();
        for (User user : users) {  // Fill the users1
            if (surname.equals(user.getUserSurname())) {
                users1.add(user);
            }
        }
        if (users1.isEmpty()) {
            System.out.println("User's witch surname " + surname + " not found");
        } else {
            for (User user : users1) {  // output users info, who surname is fit
                user.getUserInfo();
            }
        }
        return users1;
    }

    public User findUserFromNameSurname(String name, String surname)
    {
        User result = null;
        for (User user : users)
        {
            if (name.equals(user.getName()) && surname.equals(user.getUserSurname()))
            {
                user.getUserInfo();
                result = user;
            }
        }
        return result;
    }

    public void transactionToCard(long userCardNumber, float summ) {      // adding money to user by id
        for (User user : users) {
            if(userCardNumber == user.getUserCardNumber()) {
                user.addMoney(summ);
            }
        }
    }

    // transfer money between users with the indication id firstUser, id SecondUser, and sum of transfer
    public void transactionUserToUser(long firstUserCardNumber, long secondUserCardNumber, float summ) {
        boolean b = false; // checks that the money has been debited
        for (User user : users) {
            if(firstUserCardNumber == user.getUserCardNumber()) {
                b = user.deliteMoney(summ);  // debit sum money from firstUser card
            }
        }
        if (b) { // adding money to secondUser card if the money has been debited from firstUser card
            for (User user : users) {
                if (secondUserCardNumber == user.getUserCardNumber()) {
                    user.addMoney(summ);
                }
            }
        }
    }

    public void createAdmin()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the admin's name");
        String adminName = sc.nextLine();
        System.out.println("Enter the admin's password");
        String adminPassword = sc.nextLine();
        logMap.put(adminName, adminPassword);
    }


    public boolean checkLogin(String login, String pass)
    {
        boolean result = false;
        for (Map.Entry<String, String> pair : logMap.entrySet())
        {
            if (login.equals(pair.getKey()))
            {
                if (pass.equals(pair.getValue()))
                    result = true;
            }
        }
        return result;
    }

    public void saveList() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("BankUsers.ser");
        FileOutputStream fileOutputStreamMap = new FileOutputStream("BankLogin.ser");
        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
        ObjectOutputStream os1 = new ObjectOutputStream(fileOutputStreamMap);
        os.writeObject(users);
        os1.writeObject(logMap);
        os.close();
        os1.close();
    }

    public void openSave(ArrayList<User> arrayList, HashMap<String, String> hashMap) {
        users = arrayList;
        logMap = hashMap;
    }
}