package cz.uhk.fim.kulhama1.skolniprojectchaty.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cottage_group")
public class Group{
    
    @Id
    @Column(name = "id_group")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_group;
    
    @Column
    @NotEmpty
    String name;
    
    @Column
    String description;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="group", orphanRemoval = true)
    private List<Cottage> cottages;
    
    public Group(){
        super();
        
    }
    public Group(int id_group, String name, String description){
        super();
        this.id_group = id_group;
        this.name = name;
        this.description = description;     
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCottages(List<Cottage> cottages) {
        this.cottages = cottages;
    }

    public List<Cottage> getCottages() {
        return cottages;
    }

    
    
}