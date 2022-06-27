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

    public void addUser(String password)  // Добавление пользователя в users
    {

        if(password.equals(bankPassword) && userCounter < MAX_USERS)
        {
            User user = new User();
            user.setUserInfo();  // Установка информации о пользователе
            users[userCounter] = user;
            userCounter++;
            user.setUserCard();  // Добавление карты юзеру, по анологии с setUserInfo
            System.out.println("Client was be registrated");
        }
        else
        {
            System.out.println("Wrong password");
        }
    }

    public void printUsers() {  // Вывод всех юзеров на экран
        for (int i = 0; i < userCounter; i++) {
            User user = users[i];
            user.getUserInfo();  // Метод класса User
            System.out.println("");
        }
    }

    // Поиск юзера по id, использовать после printUsers, чтобы узнать id и ввести его в поиск
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

    // Поиск юзера по фамилии (ArrayList удобнее, чтобы создать массив, не зная его длины, и добавлять
    // в случае совпадения фамилии
    public ArrayList<User> findUserFromSurname(String surname) {
        ArrayList<User> users1 = new ArrayList<>();
        for (int i = 0; i < userCounter; i++) {  // Заполняем массив users1
            User user = users[i];
            if (surname.equals(user.getUserSurname())) {
                users1.add(users[i]);
            }
        }
        if (users1.isEmpty()) {
            System.out.println("User's witch surname " + surname + " not found");
        } else {
            for (User user : users1) {  // Используя getUserInfo, выводим информацию обо всех юзерах в users1
                user.getUserInfo();
            }
        }
        return users1;
    }

    public void transactionToCard(long userId, float summ) {      // обычное пополнение карты одному пользователю по его id
        for (int i = 0; i < userCounter; i++) {
            User user = users[i];
            if(userId == user.getId()) {
                user.addMoney(summ);  // метод из класса User
            }
        }
    }

    // Перевод между юзерами, с вводом их id и суммы перевода. Перед использованием желательно вызвать printUsers
    // чтобы узнать их id
    public void transactionUserToUser(long firstUserId, long secondUserId, float summ) {
        boolean b = false; // Флажок, будет проверять, списались ли деньги у первого пользователя
        for (int i = 0; i < userCounter; i++) {
            User user = users[i];
            if(firstUserId == user.getId()) {
                b = user.deliteMoney(summ);  // Списание суммы с карты первого пользователя
            }
        }
        if (b) { // Если деньги у первого смогли списаться, то добавляем их второму
            for (int i = 0; i < userCounter; i++) {
                User user = users[i];
                if (secondUserId == user.getId()) {
                    user.addMoney(summ);  // Добавление суммы на карту второго юзера
                }
            }
        }
    }
}