package PageObjectModel;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
//import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap();

        map.put("01", "January");
        map.put("02", "February");
        map.put("03", "March");
        map.put("04", "April");
        map.put("05", "May");
        map.put("06", "June");
        map.put("07", "July");
        map.put("08", "August");
        map.put("09", "September");
        map.put("10", "October");
        map.put("11", "November");
        map.put("12", "December");
        String date="2023-07-21";
        String[] tmp =date.split("-");
        String month=tmp[1];
       System.out.println(month);
        System.out.println("helloooo 2 "+ map.get("06"));
        System.out.println("helloooo  "+map.get(month));
    }
}
