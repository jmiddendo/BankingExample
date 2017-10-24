/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import fit5042.tutex.repository.entities.BankUser;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmid3
 */
@Entity
@XmlRootElement
@NamedQueries({@NamedQuery(name=Account.GET_ALL, query = "SELECT a FROM Account a")})
public class Account implements Serializable {
    
    public static final String GET_ALL = "Account.getAllAccounts";
    
    private int accountId;
    private String accountName;
    private String accountType;
    private BigDecimal accountBalance;
    private BankUser userId;
    private boolean isActive;
    
    private Set<BankTransaction> myTransactions;
    private Set<TransferBankTransaction> myTransferTransaction;
    
    public Account() {
        this.myTransactions = new HashSet<>();
        this.myTransferTransaction = new HashSet<>();
    }

    public Account(int accountId, String accountName, String accountType, BigDecimal accountBalance, BankUser userId, boolean isActive) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.userId = userId;
        this.isActive = isActive;
        this.myTransactions = new HashSet<>();
        this.myTransferTransaction = new HashSet<>();
    }

    public Account(int accountId, String accountName, String accountType, BigDecimal accountBalance, BankUser userId, boolean isActive, Set<BankTransaction> myTransaction, Set<TransferBankTransaction> myTransferTransaction) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.userId = userId;
        this.isActive = isActive;
        this.myTransactions = myTransaction;
        this.myTransferTransaction = myTransferTransaction;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Column(name="account_type")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Min(0)
    @Column(name = "account_balance")
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    @ManyToOne
    public BankUser getUserId() {
        return userId;
    }

    public void setUserId(BankUser userId) {
        this.userId = userId;
    }
    
    @Column(name = "is_active")
    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @OneToMany(mappedBy = "userAccount")
    public Set<BankTransaction> getMyTransactions() {
        return myTransactions;
    }

    @OneToMany(mappedBy = "relatedAccount")
    public Set<TransferBankTransaction> getMyTransferTransaction() {
        return myTransferTransaction;
    }

    public void setMyTransferTransaction(Set<TransferBankTransaction> myTransferTransaction) {
        this.myTransferTransaction = myTransferTransaction;
    }

    public void setMyTransactions(Set<BankTransaction> myTransactions) {
        this.myTransactions = myTransactions;
    }

    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
}
