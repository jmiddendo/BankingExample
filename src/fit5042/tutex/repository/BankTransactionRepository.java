/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.BankTransaction;
import fit5042.tutex.repository.entities.BankUser;
import fit5042.tutex.repository.entities.TransactionType;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author jmid3
 */
@Remote
public interface BankTransactionRepository {
    
    /**
     * Add the transaction being passed as a parameter into the repository.
     * 
     * @param transaction The transaction that will be added.
     * @throws java.lang.Exception
     */
    public void addTransaction(BankTransaction transaction) throws Exception;
    
    /**
     * Search for a property based on its Id.
     * 
     * @param transaction_id The transaction that will be searched for
     * @return BankTransaction The property that was found.
     * @throws java.lang.Exception
     */
    public BankTransaction searchTransactionById(int transaction_id);
    
    /**
     * Return all transaction in the repository.
     * 
     * @return List A list of all the transactions in the repository. 
     * @throws java.lang.Exception 
     */
    public List<BankTransaction> getAllTransactions() throws Exception;
    
    /**
     * Return all the bank users that are in the repository.
     * 
     * @return List A list of all the bank users in the repository.
     * @throws java.lang.Exception
     */
    public List<BankUser> getAllBankUsers() throws Exception;
    
    /**
     * Return all the transaction types that are in the repository.
     * 
     * @return List A list of all the transactions in the repository.
     * @throws java.lang.Exception 
     */
    public List<TransactionType> getAllTransactionTypes() throws Exception;
    
    /**
     * Removes a property based on a passed propertyId parameter.
     * 
     * @param transaction_id The property that will be removed from the register.
     * @throws java.lang.Exception
     */
    public void removeTransaction(int transaction_id) throws Exception;
    
    /**
     * Edits a transaction based on a passed transaction parameter.
     * @param transaction The transaction with the new values.
     * @throws java.lang.Exception 
     */
    public void editTransaction(BankTransaction transaction) throws Exception;
    
    /**
     * Returns a list of transactions based on three passed query parameters.
     * 
     * @param searchId The id that will be searched for
     * @param searchName The name that will be searched for
     * @param searchType The type that will be searched for
     * @return List The list of transactions
     */
    public List<BankTransaction> getFilteredList(Integer searchId, String searchName, TransactionType searchType);
    
    /**
     * Returns the next highest id in the repository.
     * @return Integer the next highest id.
     */
    public int getNextId();
    
    /**
     * Search for all of the transactions for a passed bank user parameter.
     * 
     * @param customer The bank user that will be searched.
     * @return Set The set of all transactions by a specified user.
     * @throws java.lang.Exception
     */
    public Set<BankTransaction> searchTransactionByUser(BankUser customer) throws Exception;
    
    /**
     * Search for all of the transactions for a passed bank user parameter.
     * 
     * @param type The type that will be searched.
     * @return Set The set of all transactions by a specified user.
     * @throws java.lang.Exception
     */
    public Set<BankTransaction> searchTransactionByType(TransactionType type);
    
    /**
     * Search for a transaction for a passed title parameter.
     * 
     * @param title The title that will be searched.
     * @return BankTransaction The transaction that matches the title.
     * @throws java.lang.Exception
     */
    public Set<BankTransaction> searchTransactionByName(String title);
            
}
