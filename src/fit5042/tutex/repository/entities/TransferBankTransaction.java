/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name = TransferBankTransaction.GET_ALL, query="SELECT t FROM TransferBankTransaction t")})
public class TransferBankTransaction extends BankTransaction implements Serializable {
    
    public static final String GET_ALL = "TransferBankTransaction.getAllTransaction";
    
    private Account relatedAccount;

    public TransferBankTransaction() {
    }

    public TransferBankTransaction(Integer bankTransactionId, String bankTransactionName, TransactionType type, String Description, Account userAccount, Account relatedAccount, float transactionAmount, Calendar transactionDate) {
        super(bankTransactionId, bankTransactionName, type, Description, userAccount, transactionAmount, transactionDate);
        this.relatedAccount = relatedAccount;
    }
    
    public TransferBankTransaction(BankTransaction bankTransaction, Account newAccount) {
        super(bankTransaction);
        relatedAccount = newAccount;
    }
    
    public Account getRelatedAccount() {
        return relatedAccount;
    }

    public void setRelatedAccount(Account relatedAccount) {
        this.relatedAccount = relatedAccount;
    }    
    
}
