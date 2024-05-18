package Model;

import java.util.ArrayList;

public class Hotel {

    private int id;
    private String name;
    private String address;
    private String city;
    private String district;
    private String tel;
    private String email;
    private int star;
    private ArrayList<String> pensionTypes,services;
    private ArrayList<String> sessions;
    public Hotel(int id, String name, String address, String city, String district,
                 String email, String tel, int star, ArrayList<String> pensionTypes,ArrayList<String> services,
                 ArrayList<String> sessions) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.tel = tel;
        this.email = email;
        this.star = star;
        this.district = district;
        this.pensionTypes = pensionTypes;
        this.services = services;
        this.sessions = sessions;
    }

    public ArrayList<String> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<String> sessions) {
        this.sessions = sessions;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }

    public ArrayList<String> getPensionTypes() {
        return pensionTypes;
    }

    public void setPensionTypes (ArrayList<String> pensionTypes) {
        this.pensionTypes = pensionTypes;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
