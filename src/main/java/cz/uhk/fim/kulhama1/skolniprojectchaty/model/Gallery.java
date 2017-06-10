package cz.uhk.fim.kulhama1.skolniprojectchaty.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cottage_gallery")
public class Gallery{
    
    @Id
    @Column(name = "id_gallery")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_gallery;
    
    @Column
    int id_thumbnail_gallery;
    
    @Column
    String name;
    
    @Column
    String description;
    
    @JsonIgnore
    @OneToMany(cascade=CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name="id_gallery")
    private List<Image> images;
    
    public Gallery(){
        super();
    }
    public Gallery(int id_gallery, int id_thumbnail_gallery, String name, String description){
        super();
        this.id_gallery = id_gallery;
        this.id_thumbnail_gallery = id_thumbnail_gallery;
        this.name = name;
        this.description = description;     
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setId_gallery(int id_gallery) {
        this.id_gallery = id_gallery;
    }

    public int getId_gallery() {
        return id_gallery;
    }

    public void setId_thumbnail_gallery(Integer id_thumbnail_gallery) {
        this.id_thumbnail_gallery = id_thumbnail_gallery;
    }

    public Integer getId_thumbnail_gallery() {
        return id_thumbnail_gallery;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

