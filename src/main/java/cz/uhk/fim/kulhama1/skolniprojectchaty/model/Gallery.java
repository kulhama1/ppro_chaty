package cz.uhk.fim.kulhama1.skolniprojectchaty.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "cottage_gallery")
public class Gallery{
    
    @Id
    @Column(name = "id_gallery")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_gallery;
    
    @Column
    @NotEmpty
    String name;
    
    @Column
    String description;
    
    @Column
    Integer id_thumbnail_gallery;
    
    @JsonIgnore
    @OneToMany(fetch =FetchType.EAGER)
    @JoinColumn(name="id_gallery")
    private List<Image> images;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="gallery", orphanRemoval = true)
    private List<Cottage> cottages;
    
    
    public Gallery(){
        super();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setId_gallery(Integer id_gallery) {
        this.id_gallery = id_gallery;
    }

    public Integer getId_gallery() {
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

    public List<Cottage> getCottages() {
        return cottages;
    }

    public void setCottages(List<Cottage> cottages) {
        this.cottages = cottages;
    }  
}

