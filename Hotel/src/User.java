//import java.util.ArrayList;

public class User
{

    private String id, username, email, city, country, img, phone;
    private boolean isAdmin;

    public String getid(){
        return id;
    }
    public void setid(String newID){
        this.id = newID;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String newUsername){
        this.username = newUsername;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String newCity){
        this.city = newCity;
    }

    public String getImg(){
        return img;
    }
    public void setImg(String newImg){
        this.img = newImg;
    }

    public String getCountry(){
        return country;
    }
    public void setCountry(String newCountry){
        this.country = newCountry;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String newPhone){
        this.phone = newPhone;
    }

    public boolean getAdmin(){
        return isAdmin;
    }
    public void setAdmin(boolean newAdmin){
        this.isAdmin = newAdmin;
    }

    public void User()
    {
        id = "0";
        username = "blank";
        email = "null@null";
        city = "null";
        country = "USA";
        phone = "0000000000";
        img = "blank.png";
        isAdmin = false;
    }


} //end class User