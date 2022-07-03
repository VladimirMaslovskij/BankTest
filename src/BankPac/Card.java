package BankPac;

import java.io.Serializable;

public class Card implements Serializable
{
    private long cardNumber = (long)(Math.random() * 999999999);
    private short cvv = (short)(100+(Math.random() * 900));
    private long userId;
    private float money = (float) (100.0); // initial balance

    private ClassCard cardType;
    Card(){}

    // Creating the card
    void setCard(long userId, ClassCard type)
    {
        Card card = new Card();
        this.userId = userId;
        this.cardType = type;
    }

    void getCardInfo()
    {
        System.out.println("Info about user card:");
        System.out.println("number of card - " + this.cardNumber + " , type of card - " + this.cardType
                        + " , card balance - " + this.money);
    }
    // Add money, but not more than the limit
    void addMoney(float summ) {
        if (this.money + summ <= Float.MAX_VALUE) {
            this.money += summ;
        } else {
            System.out.println("Card's limit will be received. Transaction is not possible.");
        }
    }
    // Debits money from the user's card. Does not allow to write off more than he has
    boolean deliteMoney(float summ) { // return true or false to know result of operation
        if (this.money - summ < 0) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            this.money -= summ;
            return true;
        }
    }
}