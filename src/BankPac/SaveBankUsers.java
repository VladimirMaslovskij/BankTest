package BankPac;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveBankUsers
{
    public static void saveUsersList(ArrayList<User> arrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Java\\SavedFiles\\BankUsers.ser");
        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
        os.writeObject(arrayList);
        os.close();
    }
}
