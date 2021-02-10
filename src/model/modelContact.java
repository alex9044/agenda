package model;
/**
 *
 * @author ALEX PC
 */
public class modelContact {
    String name, phone, adress;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public modelContact() {
        
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    
    
}
