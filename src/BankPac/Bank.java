package BankPac;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank
{
    final short MAX_USERS = 3;
    final String bankPassword = "myPassword";
    User[] users = new User[MAX_USERS]; // DATA BASE(NO)
    short userCounter = 0;

    Scanner sc = new Scanner(System.in);

    public void addUser(String password)  // ���������� ������������ � users
    {

        if(password.equals(bankPassword) && userCounter < MAX_USERS)
        {
            User user = new User();
            user.setUserInfo();  // ��������� ���������� � ������������
            users[userCounter] = user;
            userCounter++;
            user.setUserCard();  // ���������� ����� �����, �� �������� � setUserInfo
            System.out.println("Client was be registrated");
        }
        else
        {
            System.out.println("Wrong password");
        }
    }

    public void printUsers() {  // ����� ���� ������ �� �����
        for (int i = 0; i < userCounter; i++) {
            User user = users[i];
            user.getUserInfo();  // ����� ������ User
            System.out.println("");
        }
    }

    // ����� ����� �� id, ������������ ����� printUsers, ����� ������ id � ������ ��� � �����
    public User findUserFromId(long id) {
        User result = null;
        for (int i = 0; i < userCounter; i++) {
            User user = users[i];
            if(id == user.getId()) {
                user.getUserInfo();
                result = user;
            } else {
                System.out.println("User witch ID " + id + " not found");
            }
        }
        return result;
    }

    // ����� ����� �� ������� (ArrayList �������, ����� ������� ������, �� ���� ��� �����, � ���������
    // � ������ ���������� �������
    public ArrayList<User> findUserFromSurname(String surname) {
        ArrayList<User> users1 = new ArrayList<>();
        for (int i = 0; i < userCounter; i++) {  // ��������� ������ users1
            User user = users[i];
            if (surname.equals(user.getUserSurname())) {
                users1.add(users[i]);
            }
        }
        if (users1.isEmpty()) {
            System.out.println("User's witch surname " + surname + " not found");
        } else {
            for (User user : users1) {  // ��������� getUserInfo, ������� ���������� ��� ���� ������ � users1
                user.getUserInfo();
            }
        }
        return users1;
    }

    public void transactionToCard(long userId, float summ) {      // ������� ���������� ����� ������ ������������ �� ��� id
        for (int i = 0; i < userCounter; i++) {
            User user = users[i];
            if(userId == user.getId()) {
                user.addMoney(summ);  // ����� �� ������ User
            }
        }
    }

    // ������� ����� �������, � ������ �� id � ����� ��������. ����� �������������� ���������� ������� printUsers
    // ����� ������ �� id
    public void transactionUserToUser(long firstUserId, long secondUserId, float summ) {
        boolean b = false; // ������, ����� ���������, ��������� �� ������ � ������� ������������
        for (int i = 0; i < userCounter; i++) {
            User user = users[i];
            if(firstUserId == user.getId()) {
                b = user.deliteMoney(summ);  // �������� ����� � ����� ������� ������������
            }
        }
        if (b) { // ���� ������ � ������� ������ ���������, �� ��������� �� �������
            for (int i = 0; i < userCounter; i++) {
                User user = users[i];
                if (secondUserId == user.getId()) {
                    user.addMoney(summ);  // ���������� ����� �� ����� ������� �����
                }
            }
        }
    }
}