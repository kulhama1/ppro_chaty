package cz.uhk.fim.kulhama1.skolniprojectchaty.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cottage_cottage")
public class Cottage{
    
    @Id
    @Column(name = "id_cottage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_cottage;
    
    @Column
    int id_gallery;
    
    @Column
    String description;
    
    @Column
    String city;
    
    @Column
    int number_of_place;
    
    @Column
    int price;
    
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name="id_group")
    private Group group;
    
    @Transient
    Integer form_id_cottage_group;
    
    public Cottage(){
        super();
        
    }
    public Cottage(int id_cottage, int id_gallery, int id_group, String description, String city, int number_of_place, int price, Group group){
        super();
        this.id_cottage = id_cottage;
        this.id_gallery = id_gallery;
        this.description = description;
        this.city = city;
        this.number_of_place = number_of_place;
        this.price = price;
        this.group = group;
    }

    public void setId_cottage(int id_cottage) {
        this.id_cottage = id_cottage;
    }

    public int getId_cottage() {
        return id_cottage;
    }

    public void setId_gallery(int id_gallery) {
        this.id_gallery = id_gallery;
    }

    public int getId_gallery() {
        return id_gallery;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setNumber_of_place(int number_of_place) {
        this.number_of_place = number_of_place;
    }

    public int getNumber_of_place() {
        return number_of_place;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public Integer getForm_id_cottage_group() {
        return form_id_cottage_group;
    }

    public void setForm_id_cottage_group(Integer form_id_cottage_group) {
        this.form_id_cottage_group = form_id_cottage_group;
    }
    

}
