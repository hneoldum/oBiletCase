package PageObjectModel;

import java.util.HashMap;

public class ConstMonths {

    static HashMap<String ,String> aylar;
    public static String GetAy(String key)
    {
        aylar =new HashMap<String, String>();
        aylar.put("01","Ocak");
        aylar.put("02","Şubat");
        aylar.put("03","Mart");
        aylar.put("04","Nisan");
        aylar.put("05","Mayıs");
        aylar.put("06","Haziran");
        aylar.put("07","Temmuz");
        aylar.put("08","Ağustos");
        aylar.put("09","Eylül");
        aylar.put("10","Ekim");
        aylar.put("11","Kasım");
        aylar.put("12","Aralık");
        return  aylar.get(key);
    }



}