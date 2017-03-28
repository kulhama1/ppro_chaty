package cz.pprochaty.web.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cottage_cottage")
public class Cottage implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cottage;
    
    private Integer id_user;
    
    @NotEmpty
    private String name;
    @NotEmpty
    private String city;
    @NotEmpty
    private int number_of_place;
    private int cena;
    
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name="id_gallery")
    private Gallery gallery;
    
    @OneToMany
    @JoinColumn(name = "id_equipment")
    private List<Equipment> equipments;
    
    
    public Cottage(){
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof Cottage) ) return false;

        final Cottage cottage = (Cottage) o;

        if ( !cottage.getId_cottage().equals( this.getId_cottage()) ) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 42; 
        int result = 2; 
        result = prime * result;
        result += ((id_cottage == null) ? 0 : id_cottage.hashCode());
        result += ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public int getCena() {
        return cena;
    }

    public String getCity() {
        return city;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public Integer getId_cottage() {
        return id_cottage;
    }

    public Integer getId_user() {
        return id_user;
    }

    public String getName() {
        return name;
    }

    public int getNumber_of_place() {
        return number_of_place;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public void setId_cottage(Integer id_cottage) {
        this.id_cottage = id_cottage;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber_of_place(int number_of_place) {
        this.number_of_place = number_of_place;
    }
    
}
