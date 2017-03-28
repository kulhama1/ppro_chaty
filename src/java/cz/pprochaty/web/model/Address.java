package cz.pprochaty.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cottage_address")
public class Address implements Serializable {
    @Id
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_address;
    
    @Column
    @NotEmpty
    private String address;
    
    @Column
    @NotEmpty
    private String city;
    
    @Column
    @NotEmpty
    private int postal_code;
    
    public Address(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof Address) ) return false;

        final Address address = (Address) o;

        if ( !address.getId_address().equals( this.getId_address()) ) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 25; 
        int result = 1; 
        result = prime * result;
        result += ((id_address == null) ? 0 : id_address.hashCode());
        result += ((address == null) ? 0 : address.hashCode());
        return result;
    }

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }
    
}
