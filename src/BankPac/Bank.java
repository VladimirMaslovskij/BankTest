package BankPac;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank
{
    private static Bank instatce;

    private  Bank() {}

    public static Bank getInstance()
    {
        if (instatce == null) {
            instatce = new Bank();
        }
            return instatce;
    }


    final String bankPassword = "myPassword";
    ArrayList<User> users = new ArrayList<>(); // DATA BASE(NO)


    Scanner sc = new Scanner(System.in);

    public void addUser(String password, ClassCard type)  // Adding one user
    {

        if(password.equals(bankPassword))
        {
            User user = new User();
            user.setUserInfo();  // Set information about user
            users.add(user);
            user.setUserCard(type);  // adding card to user
            System.out.println("Client was be registrated");
        }
        else
        {
            System.out.println("Wrong password");
        }
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

    public void transactionToCard(long userId, float summ) {      // adding money to user by id
        for (User user : users) {
            if(userId == user.getId()) {
                user.addMoney(summ);
            }
        }
    }

    // transfer money between users with the indication id firstUser, id SecondUser, and sum of transfer
    public void transactionUserToUser(long firstUserId, long secondUserId, float summ) {
        boolean b = false; // checks that the money has been debited
        for (User user : users) {
            if(firstUserId == user.getId()) {
                b = user.deliteMoney(summ);  // debit sum money from firstUser card
            }
        }
        if (b) { // adding money to secondUser card if the money has been debited from firstUser card
            for (User user : users) {
                if (secondUserId == user.getId()) {
                    user.addMoney(summ);
                }
            }
        }
    }
}