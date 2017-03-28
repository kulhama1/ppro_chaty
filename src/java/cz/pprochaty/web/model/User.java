
package cz.pprochaty.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cottage_user", uniqueConstraints = {
@UniqueConstraint(columnNames = "login"),
@UniqueConstraint(columnNames = "id_user"),
@UniqueConstraint(columnNames = "email")
})
public class User implements Serializable {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    private int id_address;
    
    @Column
    @NotEmpty
    private String login;
    
    @Column
    @NotEmpty
    private String name;
    
    @Column
    @NotEmpty
    private String surname;
    
    @Column
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    private String password;
    @NotEmpty
    private String salt;
    
    private String website;
    private String phone;
    
    @NotNull
    private Integer rights;
    private String token;
    
    public User(){
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( !(o instanceof User) ) return false;

        final User user = (User) o;

        if ( !user.getId_user().equals( this.getId_user()) ) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 40; 
        int result = 2; 
        result = prime * result;
        result += ((id_user == null) ? 0 : id_user.hashCode());
        result += ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public String getEmail() {
        return email;
    }

    public int getId_address() {
        return id_address;
    }

    public Integer getId_user() {
        return id_user;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getRights() {
        return rights;
    }

    public String getSalt() {
        return salt;
    }

    public String getSurname() {
        return surname;
    }

    public String getToken() {
        return token;
    }

    public String getWebsite() {
        return website;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRights(Integer rights) {
        this.rights = rights;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
}
