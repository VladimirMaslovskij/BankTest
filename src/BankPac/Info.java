package BankPac;

import java.util.Scanner;

public class Info
{
    String name;
    String surname;
    Address address;

    Info(){}
    // fill user info
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
    // output user info
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
