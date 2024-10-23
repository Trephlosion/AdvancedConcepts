import java.util.ArrayList;

public class Hotel extends Room {

    private String name, type, address, distance;
    private ArrayList<String> photos;
    private int rating;
    private ArrayList<Room> rooms;
    private double cheapestPrice;
    private boolean featured;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getType() {
        return type;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String newDistance) {
        this.distance = newDistance;
    }

    public double getCheapestPrice() {
        return cheapestPrice;
    }

    public void setCheapestPrice(double newCheapestPrice) {
        this.cheapestPrice = newCheapestPrice;
    }

    public boolean getFeatured() {
        return featured;
    }

    public void setFeatured(boolean newFeatured) {
        this.featured = newFeatured;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int newRating) {
        if (newRating > 5) newRating = 5;
        if (newRating < 0) newRating = 0;
        this.rating = newRating;
    }

    public Room getRooms(int index) {
        return rooms.get(index);
    }

    public void setRooms(int index, Room newRooms) {
        this.rooms.set(index, newRooms);
    }

    public String getPhotos(int index) {
        return photos.get(index);
    }

    public void setPhotos(int index, String newPhotos) {
        this.photos.set(index, newPhotos);
    }

    public void Hotel() {
        super.Room();
        name = "Blank Blank";
        type = "null";
        address = "0000Null Ave.";
        distance = "0m";
        rating = 0;
        cheapestPrice = 0.00f;
        featured = false;
        rooms = new ArrayList<Room>();
        photos = new ArrayList<String>();
    }

} //end class Hotel