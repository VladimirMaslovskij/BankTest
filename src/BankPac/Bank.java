package BankPac;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank
{
    private static Bank INSTANCE;

    private  Bank() {}

    public static Bank getInstance()
    {
        if (INSTANCE == null) {
            INSTANCE = new Bank();
        }
            return INSTANCE;
    }

    HashMap<String, String> logMap = new HashMap<>();


    ArrayList<User> users = new ArrayList<>(); // DATA BASE(NO)




    public void addUser()  // Adding one user
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of user card: 1.Bronze, 2.Silver, 3.Gold");
        int choiseCardType = 0;
        CardType type = null;
        while (type == null)
        {
            choiseCardType = sc.nextInt();
            if (choiseCardType == 1)
                type = CardType.BRONZE;
            else if (choiseCardType == 2)
                type = CardType.SILVER;
            else if (choiseCardType == 3)
                type = CardType.GOLD;
            else
                System.out.println("Enter 1,2, or 3, no more");
        }
            User user = new User();
            user.setUserInfo();  // Set information about user
            users.add(user);
            logMap.put(user.getEmail(), user.getPassword());
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

    public User findUserFromLogin(String login)
    {
        User result = null;
        for (User user : users)
        {
            if (login.equals(user.getEmail()))
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

    public boolean checkAdminLogin(String login, String pass)
    {
        boolean result = false;
        if (login.equals("admin"))
            {
                if (pass.equals("password"))
                    result = true;
            }
        return result;
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