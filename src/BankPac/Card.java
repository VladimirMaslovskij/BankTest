package BankPac;

public class Card
{
    private long cardNumber = (long)(Math.random() * 999999999);
    private short cvv = (short)(100+(Math.random() * 900));
    private long userId;
    private float money = (float) (100.0); // Допустим, в стоимость карты включена какая-то начальная сумма
    Card(){}

    // Создание карты, используется при создании юзера
    void setCard(long userId)
    {
        Card card = new Card();
        this.userId = userId;
    }
    // Добавляет юзеру денег, допустим максимальная сумма, которую позволяет хранить карта - Float.MAX_VALUE
    void addMoney(float summ) {
        if (this.money + summ <= Float.MAX_VALUE) {
            this.money += summ;
        } else {
            System.out.println("Card's limit will be received. Transaction is not possible.");
        }
    }
    // Списывает деньги с карты юзера. Не допускает списать больше, чем у него есть
    boolean deliteMoney(float summ) { // boolean, чтобы вернуть значение в флажек b в метод transactionUserToUser
        if (this.money - summ < 0) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            this.money -= summ;
            return true;
        }
    }
}