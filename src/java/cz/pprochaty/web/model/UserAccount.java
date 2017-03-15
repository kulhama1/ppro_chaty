
package cz.pprochaty.web.model;

import java.io.Serializable;

public class UserAccount implements Serializable{
    private User user;
    private Address address;
    private String password;
    private String password_check;
    
    public UserAccount(){
        
    }
    
    public UserAccount(User user, Address address){
        this.user = user;
        this.address = address;
    }
    public UserAccount(User user, Address address, String password, String password_check){
        this.user = user;
        this.address = address;
        this.password = password;
        this.password_check = password_check;
    }

    public Address getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword_check() {
        return password_check;
    }

    public User getUser() {
        return user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword_check(String password_check) {
        this.password_check = password_check;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
