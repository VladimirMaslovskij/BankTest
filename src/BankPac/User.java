package BankPac;

import Exceptions.BankException;

import java.io.Serializable;

public class User implements Serializable
{
    private Info info;
    private Card card;
    private long id = (long)(Math.random() * 999999999);
    User(){}

    // output user info
    public void getUserInfo() {
        System.out.println("Information about client " + id + ":");
        info.getInfo();
        card.getCardInfo();
    }

    public Card getCard() {
        return card;
    }
    // adding money to user card
    void addMoney(float summ) {
        card.addMoney(summ);
    }
    // debiting money of user
    boolean deliteMoney(float summ) {
        return card.deliteMoney(summ);
    }
    public long getId() {
        return id;
    }
    // set info about user
    void setUserInfo() throws BankException {
        info = new Info();
        info.setInfo();
    }

    String getUserSurname()
    {
        return info.getSurname();
    }
    void setUserCard(CardType type)
    {
        card = new Card();
        card.setCard(id, type);
    }
    public String getName() {
        return info.getName();
    }

    public String getPassword() {
        return info.getPassword();
    }

    public String getEmail()
    {
        return info.getEmail();
    }

    public long getUserCardNumber()
    {
        return card.getCardNumber();
    }

}