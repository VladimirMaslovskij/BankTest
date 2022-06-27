package BankPac;

public class User
{
    private Info info;
    private Card card;
    private long id = (long)(Math.random() * 999999999);
    User(){}

    // Вывод информации о пользователе посредством вызова getInfo класса Info
    public void getUserInfo() {
        System.out.println("Information about client " + id + ":");
        info.getInfo();
    }

    public Card getCard() {
        return card;
    }
    // Добавить юзеру немножко денюжки
    void addMoney(float summ) {
        card.addMoney(summ);
    }
    // Забрать у него бабки
    boolean deliteMoney(float summ) {
        return card.deliteMoney(summ);
    }
    public long getId() {
        return id;
    }
    // Установка информации о юзере
    void setUserInfo()
    {
        info = new Info();
        info.setInfo();
    }

    String getUserSurname()
    {
        return info.getSurname();
    }
    void setUserCard()
    {
        card = new Card();
        card.setCard(id);
    }

}