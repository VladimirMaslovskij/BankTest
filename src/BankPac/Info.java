package BankPac;

import Exceptions.BankException;

import java.io.Serializable;
import java.util.Scanner;

public class Info implements Serializable {
    String name;
    String surname;
    Address address;

    String password;

    String email;

    Info() {
    }

    // fill user info
    void setInfo() throws BankException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email (login)");
        this.email = sc.nextLine();
        if (!this.email.contains("@"))
            throw new BankException("No @ in email");
        System.out.println("Enter you're password");
        this.password = sc.nextLine();
        if (this.password.length() < 6)
            throw new BankException("Too little password, try 6 chars min");
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter surname: ");
        this.surname = sc.nextLine();
        address = new Address();
        address.setAddress(sc);
    }

    // output user info
    void getInfo() {
        System.out.println("Login (email): " + email);
        System.out.print("Name: " + name);
        System.out.print(", surname: " + surname);
        System.out.println(", password: " + password + ".");
        address.getAddress();
    }

    public String getName()
    {
        return name;
    }

    public String getPassword() {
        return password;
    }


    String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}

