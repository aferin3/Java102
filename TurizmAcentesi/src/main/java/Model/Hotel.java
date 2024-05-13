package Model;

public class Hotel {

    private int id;
    private String name;
    private String address;
    private String city;
    private String tel;
    private String email;
    private int star;

    public Hotel(int id, String name, String address, String city, String email, String tel, int star) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.tel = tel;
        this.email = email;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
