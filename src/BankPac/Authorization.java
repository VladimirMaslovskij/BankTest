package BankPac;

import java.util.HashMap;
import java.util.Map;

public class Authorization
{
    public HashMap<String, String> map = new HashMap<>();

    public void setMap(HashMap<String, String> map)
    {
        this.map = map;
    }

    public boolean checkLogin(String login, String pass)
    {
        boolean result = false;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (login.equals(pair.getKey()))
            {
                if (pass.equals(pair.getValue()))
                    result = true;
            }
        }
        return result;
    }
    public boolean checkLoginAdmin(String login, String pass)
    {
        if (login.equalsIgnoreCase("admin") && pass.equals("Password"))
            return true;
        else return false;
    }
}
