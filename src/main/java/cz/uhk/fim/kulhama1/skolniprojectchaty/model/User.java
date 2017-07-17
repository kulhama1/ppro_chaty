package cz.uhk.fim.kulhama1.skolniprojectchaty.model;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cottage_user")
public class User{
    
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_user;
    Integer id_address;
    
    @Column
    @NotNull
    String login;
    
    @Column
    @NotNull        
    String name;
    
    @Column 
    @NotNull        
    String surname;
    
    @Column
    @NotNull        
    String email;
    
    @Column
    @NotNull        
    String password;
    
    @Column
    @NotNull        
    String salt;
    
    @Column
    String website;
    
    @Column
    int phone;
    
    @Column
    @NotNull        
    int rights;
    
    @Column
    @NotNull        
    String token;
    
    @Transient
    private final char[] valid_hash_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+{}[]|:;<>?,./".toCharArray();
    @Transient
    private final int pass_length = 50;
    @Transient
    private final int iterations = 1258;
    @Transient
    private final int hash_length = 32;
    
    @Transient
    private final char[] valid_token_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    @Transient
    private final int token_length = 32;
    
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
    public String generateHashToken(boolean isHash) {
        if(isHash) return generateHash(valid_hash_chars, pass_length);
        else return generateHash(valid_token_chars, token_length);
    }
    
    public String generateHash(char[] valid_chars, int length) {
        SecureRandom srandom = new SecureRandom();
        Random random = new Random();
        char[] salt = new char[length];
               
        for(int i=0; i < length; ++i) {
            if ((i % 10) == 0) {
                random.setSeed(srandom.nextLong()); // 64 bits of random!
            }
            salt[i] = valid_chars[random.nextInt(valid_chars.length)];
        }
        
        return new String(salt);
    }
    
    public String hashPassword(String password, String hash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] pass = pbkdf2(password.toCharArray(), hash, iterations, hash_length);
        return toHex(pass);
    }
    
    public boolean comparePasswords(String passDb, String hash, String pass) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] b = pbkdf2(pass.toCharArray(), hash, iterations, hash_length);
        String inputPass = toHex(b);
        return passDb.equals(inputPass);
    }
    
    private static byte[] pbkdf2(char[] password, String salt_string, int iterations, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = salt_string.getBytes();
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return skf.generateSecret(spec).getEncoded();
    }
    
    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length) - hex.length();
        if(paddingLength > 0) 
            return String.format("%02" + paddingLength + "c", 0) + hex;
        else
            return hex;
    } 

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_user(Integer id_user) {
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

    public Integer getId_address() {
        return id_address;
    }

    public Integer getId_user() {
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
