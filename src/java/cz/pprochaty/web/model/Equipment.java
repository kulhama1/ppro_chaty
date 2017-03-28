
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
@Table(name = "cottage_equipment")
public class Equipment implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_equipment;
    
    @Column
    @NotEmpty
    private String name;
    
    @Column
    private String note;
    
    public Equipment(){
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof Equipment) ) return false;

        final Equipment equipment = (Equipment) o;

        if ( !equipment.getId_equipment().equals(this.getId_equipment()) ) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 35; 
        int result = 1; 
        result = prime * result;
        result += ((id_equipment == null) ? 0 : id_equipment.hashCode());
        result += ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public Integer getId_equipment() {
        return id_equipment;
    }

    public void setId_equipment(int id_equipment) {
        this.id_equipment = id_equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}