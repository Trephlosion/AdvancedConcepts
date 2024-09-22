import java.util.ArrayList;
import java.util.Date;

public class RoomNumber extends User
{

    private ArrayList<Date> unavailableDates;
    private int number;



    public int getNumber(){
        return number;
    }
    public void setNumber(int num){
        this.number = num;
    }

    public Date getUnavailableDates(int index){
        return unavailableDates.get(index);
    }
    public void setUnavailableDates(int index, Date newDates){
        this.unavailableDates.set(index, newDates);
    }

    public void RoomNumber()
    {
        super.User();
        number = 0;
        unavailableDates = new ArrayList<Date>();
    }



} //end class RoomNumber