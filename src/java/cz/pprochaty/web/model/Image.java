
package cz.pprochaty.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cottage_image")
public class Image implements Serializable{
    @Id
    @Column(name = "id_image")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_image;
    
    @Column
    @NotEmpty
    private String image_alt;
    
    @Column
    private String image_src;
    
    @Column
    private String description;
    
    @Column
    private String thumbnail_src;
    
    @Column
    private Integer id_gallery;
    
    public Image(){
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof Image) ) return false;

        final Image image = (Image) o;

        if ( !image.getId_image().equals(this.getId_image()) ) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 35; 
        int result = 1; 
        result = prime * result;
        result += ((id_image == null) ? 0 : id_image.hashCode());
        result += ((image_alt == null) ? 0 : image_alt.hashCode());
        return result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId_gallery() {
        return id_gallery;
    }

    public void setId_gallery(Integer id_gallery) {
        this.id_gallery = id_gallery;
    }

    public Integer getId_image() {
        return id_image;
    }

    public void setId_image(Integer id_image) {
        this.id_image = id_image;
    }

    public String getImage_alt() {
        return image_alt;
    }

    public void setImage_alt(String image_alt) {
        this.image_alt = image_alt;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public String getThumbnail_src() {
        return thumbnail_src;
    }

    public void setThumbnail_src(String thumbnail_src) {
        this.thumbnail_src = thumbnail_src;
    }
}
