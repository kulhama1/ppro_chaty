
package cz.pprochaty.web.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cottage_order")
public class Order implements Serializable {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_order;
    
    @Column
    @NotNull
    private Integer id_user;
    
    @Column
    @NotNull
    private Integer id_address;
    
    @Column
    private String note;
    
    @OneToMany
    private List<Cottage> cottages;
    
    public Order(){
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof Order) ) return false;

        final Order order = (Order) o;

        if ( !order.getId_order().equals(this.getId_order()) ) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 38; 
        int result = 2; 
        result = prime * result;
        result += ((id_order == null) ? 0 : id_order.hashCode());
        result += ((id_address == null) ? 0 : id_address.hashCode());
        return result;
    }

    public void setCottages(List<Cottage> cottages) {
        this.cottages = cottages;
    }

    public List<Cottage> getCottages() {
        return cottages;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public Integer getId_address() {
        return id_address;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}
