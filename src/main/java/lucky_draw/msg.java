package lucky_draw;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class msg {

    public static void main(String[] args) {
        /*SimpleDateFormat format  = new SimpleDateFormat("YYYY-MM-dd ");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        String weekStart = format.format(c.getTime())+" 00:00:00";
        System.out.println(weekStart);
        Calendar ca = Calendar.getInstance();
        ca.setFirstDayOfWeek(Calendar.MONDAY);
        ca.set(Calendar.DAY_OF_WEEK, ca.getFirstDayOfWeek() + 6); // Sunday
        String weekEnd = format.format(ca.getTime())+" 23:59:59";
        System.out.println(weekEnd);*/
        int[] A = {1,3,5,7,9,2,4,6,8,10};
        System.out.println(Minimum(A,8));

    }

    public static int Minimum(int[] A ,int n) {
        int min = A[0];
        int i;
        for(i = 1;i < n; i++){
            if(min > A[i])
                min = A[i];
        }
        return min;
    }

}
