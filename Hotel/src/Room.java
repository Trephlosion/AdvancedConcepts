import java.util.ArrayList;

public class Room extends RoomNumber
{

    private String title;
    private int maxPeople;
    private ArrayList<RoomNumber> roomNumbers;
    private double price;




    public String getTitle(){
        return title;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public int getMaxPeople(){
        return maxPeople;
    }
    public void setMaxPeople(int newMaxPeople){
        this.maxPeople = newMaxPeople;
    }

    public RoomNumber getRoomNumbers(int index){
        return roomNumbers.get(index);
    }
    public void setRoomNumbers(int index, RoomNumber newRoomNumbers){
        this.roomNumbers.set(index, newRoomNumbers);
    }


    public void Room()
    {
        super.RoomNumber();
        title = "null";
        roomNumbers = new ArrayList<RoomNumber>();
        price = 0.00f;
        maxPeople = 1;

    }



} //end class Room{

