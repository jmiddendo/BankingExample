/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmid3
 */
@Entity
@Table(name = "BANK_USER")
@NamedQueries({@NamedQuery(name = BankUser.GET_ALL, query = "SELECT b FROM BankUser b")})
@XmlRootElement
public class BankUser implements Serializable{
    
    public static final String GET_ALL = "BankUser.getAllUsers";

    private Integer bankUserId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String type;
    private Address address;
    private String phoneNumber;
    private Set<Account> myAccounts;

    public BankUser() {
        this.myAccounts = new HashSet<>();
    }

    public BankUser(int bankUserId, String firstName, String lastName, String email, String password, String type, Address address, String phoneNumber) {
        this.bankUserId = bankUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.myAccounts = new HashSet<>();
    }
    
    public BankUser(int bankUserId, String firstName, String lastName, String email, String password, String type, Address address, String phoneNumber, Set<Account> myAccounts) {
        this.bankUserId = bankUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.myAccounts = myAccounts;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_user_id")
    public Integer getBankUserId() {
        return bankUserId;
    }

    public void setBankUserId(Integer bankUserId) {
        this.bankUserId = bankUserId;
    }

    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    public Set<Account> getMyAccounts() {
        return myAccounts;
    }

    public void setMyAccounts(Set<Account> myAccounts) {
        this.myAccounts = myAccounts;
    }

    @Override
    public String toString() {
        return "BankUser{" + "bankUserId=" + bankUserId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", type=" + type + ", address=" + address + ", phoneNumber=" + phoneNumber + ", myAccounts=" + myAccounts + '}';
    }
    
}
