package cz.uhk.fim.kulhama1.skolniprojectchaty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cottage_address")
public class Address{
    
    @Id
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_address;
    
    @Column
    String address;
    
    @Column
    String city;
    
    @Column
    int postal_code;
    
    public Address(){
        super();
        
    }
    public Address(int id_address, String address, String city, int postal_code){
        super();
        this.id_address = id_address;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
    }

    public int getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
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

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }
    
    
}
