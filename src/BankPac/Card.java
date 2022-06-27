package BankPac;

public class Card
{
    private long cardNumber = (long)(Math.random() * 999999999);
    private short cvv = (short)(100+(Math.random() * 900));
    private long userId;
    private float money = (float) (100.0); // ��������, � ��������� ����� �������� �����-�� ��������� �����
    Card(){}

    // �������� �����, ������������ ��� �������� �����
    void setCard(long userId)
    {
        Card card = new Card();
        this.userId = userId;
    }
    // ��������� ����� �����, �������� ������������ �����, ������� ��������� ������� ����� - Float.MAX_VALUE
    void addMoney(float summ) {
        if (this.money + summ <= Float.MAX_VALUE) {
            this.money += summ;
        } else {
            System.out.println("Card's limit will be received. Transaction is not possible.");
        }
    }
    // ��������� ������ � ����� �����. �� ��������� ������� ������, ��� � ���� ����
    boolean deliteMoney(float summ) { // boolean, ����� ������� �������� � ������ b � ����� transactionUserToUser
        if (this.money - summ < 0) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            this.money -= summ;
            return true;
        }
    }
}