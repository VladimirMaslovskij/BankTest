package BankPac;

import java.util.Scanner;

public class Info
{
    String name;
    String surname;
    Address address;

    Info(){}
    // Заполнение данных о юзере
    void setInfo()
    {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter surname: ");
        this.surname = sc.nextLine();
        address = new Address();
        address.setAddress(sc);
    }
    // Вывод данных о юзере на экран
    void getInfo()
    {
        System.out.print("Name: " + name);
        System.out.println(", surname: " + surname + ".");
        address.getAddress();
    }
    String getSurname()
    {
        return surname;
    }
}
