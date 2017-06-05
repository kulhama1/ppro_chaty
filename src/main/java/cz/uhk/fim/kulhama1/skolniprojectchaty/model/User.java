package cz.uhk.fim.kulhama1.skolniprojectchaty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cottage_user")
public class User{
    
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_user;
    
    @Column
    int id_address;
    
    @Column
    String login;
    
    @Column
    String name;
    
    @Column 
    String surname;
    
    @Column
    String email;
    
    @Column
    String password;
    
    @Column
    String salt;
    
    @Column
    String website;
    
    @Column
    int phone;
    
    @Column
    int rights;
    
    @Column
    String token;
    
    public User(){
        super();
        
    }
    public User(int id_user, int id_address, String login, String name, String surname,
            String email, String password, String salt, String website, int phone, int rights, String token){
        super();
        this.id_user = id_user;
        this.id_address = id_address;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.website = website;
        this.phone = phone;
        this.rights = rights;
        this.token = token;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setRights(int rights) {
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

    public String getEmail() {
        return email;
    }

    public int getId_address() {
        return id_address;
    }

    public int getId_user() {
        return id_user;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public int getRights() {
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
    
    
        
         
}
