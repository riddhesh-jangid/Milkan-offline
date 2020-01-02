/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author root
 */
public class datearray {
    public int[] returndate()
    {
        Date din = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(din);
        int syear = cal.get(Calendar.YEAR);
        int smonth = cal.get(Calendar.MONTH);
        int sday = cal.get(Calendar.DAY_OF_MONTH);  
        int[] result = new int[3];
        result[0] = sday;
        result[1] = smonth;
        result[2] = syear;
        return result;
    }   
}
