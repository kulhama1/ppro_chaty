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
    private Integer id_address;
    
    @Column
    String address;
    
    @Column
    String city;
    
    @Column
    String postal_code;
    
    public Address(){
        super();
        
    }
    public Address(Integer id_address, String address, String city, String postal_code){
        super();
        this.id_address = id_address;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
    }

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(Integer id_address) {
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

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
    
    
}
