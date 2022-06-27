package BankPac;

import java.util.Scanner;

public class Address {

    private String city;
    private String street;
    private int building;
    private int flat ;

    Address() {

    }
    // Info about user address
    void setAddress(Scanner sc) {
        System.out.print("Enter city: ");
        this.city = sc.nextLine();
        System.out.print("Enter street: ");
        this.street = sc.nextLine();
        System.out.print("Enter building: ");
        this.building = sc.nextInt();
        System.out.print("Enter flat: ");
        this.flat = sc.nextInt();
    }
    // output info
    void getAddress()
    {
        System.out.print("City: " + city);
        System.out.print(", street: " + street);
        System.out.print(", building: " + building);
        System.out.println(", flat: " + flat + ".");
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    public int getFlat() {
        return flat;
    }
}
