package BankPac;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveBankUsers
{
    public static void saveUsersList(ArrayList<User> arrayList, HashMap<String, String> hashMap) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Java\\SavedFiles\\BankUsers.ser");
        FileOutputStream fileOutputStreamMap = new FileOutputStream("E:\\Java\\SavedFiles\\BankLogin.ser");
        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
        ObjectOutputStream os1 = new ObjectOutputStream(fileOutputStreamMap);
        os.writeObject(arrayList);
        os1.writeObject(hashMap);
        os.close();
    }
}
