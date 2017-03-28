
package cz.pprochaty.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cottage_gallery")
public class Gallery implements Serializable{
    @Id
    @Column(name = "id_gallery")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_gallery;
    
    @Column
    private Integer id_thumbnail_gallery;
    
    @Column
    @NotEmpty
    private String name;
    
    @Column
    private String description;
    
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "id_gallery")
    private List<Image> images;
    
    public Gallery(){
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof Gallery) ) return false;

        final Gallery gallery = (Gallery) o;

        if ( !gallery.getId_gallery().equals(this.getId_gallery()) ) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 27; 
        int result = 1; 
        result = prime * result;
        result += ((id_gallery == null) ? 0 : id_gallery.hashCode());
        result += ((name == null) ? 0 : name.hashCode());
        return result;
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
    
    
}
