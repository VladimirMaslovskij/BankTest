package BankPac;

import java.io.Serializable;
import java.util.Scanner;

public class Info implements Serializable
{
    String name;
    String surname;
    Address address;

    String password;

    Info(){}
    // fill user info
    void setInfo()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter surname: ");
        this.surname = sc.nextLine();
        System.out.println("Enter you're password");
        this.password = sc.nextLine();
        address = new Address();
        address.setAddress(sc);
    }
    // output user info
    void getInfo()
    {
        System.out.print("Name: " + name);
        System.out.print(", surname: " + surname);
        System.out.println(", password: " + password + ".");
        address.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    String getSurname()
    {
        return surname;
    }
}
