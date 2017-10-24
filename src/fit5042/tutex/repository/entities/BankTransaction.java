/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmid3
 */
@Entity
@XmlRootElement
@Table(name = "bank_transaction")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({@NamedQuery(name = BankTransaction.GET_ALL, query = "SELECT t FROM BankTransaction t")})
public class BankTransaction implements Serializable{
    
    public static final String GET_ALL = "BankTransaction.getAllUsers";
    
    private Integer bankTransactionId;
    private String bankTransactionName;
    private TransactionType type;
    private String Description;
    private Account userAccount;
    private float transactionAmount;
    private Calendar transactionDate;

    public BankTransaction() {
    }

    public BankTransaction(Integer bankTransactionId, String bankTransactionName, TransactionType type, String Description, Account userAccount, float transactionAmount, Calendar transactionDate) {
        this.bankTransactionId = bankTransactionId;
        this.bankTransactionName = bankTransactionName;
        this.type = type;
        this.Description = Description;
        this.userAccount = userAccount;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public BankTransaction(BankTransaction bankTransaction) {
        this.bankTransactionId = bankTransaction.getBankTransactionId();
        this.bankTransactionName = bankTransaction.getBankTransactionName();
        this.type = bankTransaction.getType();
        this.Description = bankTransaction.getDescription();
        this.userAccount = bankTransaction.getUserAccount();
        this.transactionAmount = bankTransaction.getTransactionAmount();
        this.transactionDate = bankTransaction.getTransactionDate();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_transaction_id")
    public Integer getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(Integer bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    @Column(name = "bank_transaction_name")
    public String getBankTransactionName() {
        return bankTransactionName;
    }

    public void setBankTransactionName(String bankTransactionName) {
        this.bankTransactionName = bankTransactionName;
    }

    @ManyToOne
    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @ManyToOne
    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    @Column(name = "transaction_amount")
    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Column(name = "transaction_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "BankTransaction{" + "bankTransactionId=" + bankTransactionId + ", bankTransactionName=" + bankTransactionName + ", type=" + type + ", Description=" + Description + ", userAccount=" + userAccount + ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.bankTransactionId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankTransaction other = (BankTransaction) obj;
        if (Float.floatToIntBits(this.transactionAmount) != Float.floatToIntBits(other.transactionAmount)) {
            return false;
        }
        if (!Objects.equals(this.bankTransactionName, other.bankTransactionName)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.bankTransactionId, other.bankTransactionId)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.userAccount, other.userAccount)) {
            return false;
        }
        if (!Objects.equals(this.transactionDate, other.transactionDate)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
