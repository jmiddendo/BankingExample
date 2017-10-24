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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmid3
 */
@Entity
@Table(name = "transaction_type")
@XmlRootElement
@NamedQueries({@NamedQuery(name = TransactionType.GET_ALL, query = "SELECT t FROM TransactionType t")})
public class TransactionType implements Serializable {
    
    public static final String GET_ALL = "TransactionType.getAllTypes";
    
    private int transactionTypeId;
    private String transactionTypeName;
    private String transactionTypeDescription;
    private Set<BankTransaction> transactionByType;

    public TransactionType() {
        transactionByType = new HashSet<>();
    }

    public TransactionType(int transactionTypeId, String transactionTypeName, String transactionTypeDescription) {
        this.transactionTypeId = transactionTypeId;
        this.transactionTypeName = transactionTypeName;
        this.transactionTypeDescription = transactionTypeDescription;
        transactionByType = new HashSet<>();
    }

    public TransactionType(int transactionTypeId, String transactionTypeName, String transactionTypeDescription, Set<BankTransaction> transactionByType) {
        this.transactionTypeId = transactionTypeId;
        this.transactionTypeName = transactionTypeName;
        this.transactionTypeDescription = transactionTypeDescription;
        this.transactionByType = transactionByType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_type_id")
    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Column(name = "transaction_type_name",nullable = false)
    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    @Column(name = "transaction_type_description", nullable = false)
    public String getTransactionTypeDescription() {
        return transactionTypeDescription;
    }

    public void setTransactionTypeDescription(String transactionTypeDescription) {
        this.transactionTypeDescription = transactionTypeDescription;
    }

    @OneToMany(mappedBy = "type")
    public Set<BankTransaction> getTransactionByType() {
        return transactionByType;
    }

    public void setTransactionByType(Set<BankTransaction> transactionByType) {
        this.transactionByType = transactionByType;
    }

    @Override
    public String toString() {
        return "TransactionType{" + "transactionTypeId=" + transactionTypeId + ", transactionTypeName=" + transactionTypeName + ", transactionTypeDescription=" + transactionTypeDescription + ", transactionByType=" + transactionByType + '}';
    }
    
}
