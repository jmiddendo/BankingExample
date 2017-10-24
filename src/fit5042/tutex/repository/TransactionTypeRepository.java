/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.TransactionType;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jmid3
 */
@Remote
public interface TransactionTypeRepository {
    
    /**
     * Adds transaction type to the repository.
     * 
     * @param transactionType The transaction type to be added.
     * @throws java.lang.Exception
     */
    public void addTransactionType(TransactionType transactionType) throws Exception;
    
    /**
     * Edits a transaction type in the repository.
     * 
     * @param transactionType The transaction type to be edited.
     * @throws java.lang.Exception
     */
    public void editTransactionType(TransactionType transactionType) throws Exception;
    
    /**
     * Deletes a transaction type from the repository.
     * 
     * @param id The id of the transaction type that will be deleted.
     * @throws java.lang.Exception
     */
    public void deleteTransactionType(int id) throws Exception;
    
    /**
     * Retrieve transaction type based on id.
     * 
     * @param id The id being searched.
     * @return TransactionType The transaction type.
     * @throws java.lang.Exception
     */
    public TransactionType searchTransactionTypeById(int id) throws Exception;
    
    /**
     * Retrieve the next available id.
     * 
     * @return int The next id.
     * @throws Exception 
     */
    public int generateNextId() throws Exception;
    
    /**
     * Retrieves a list of all transactions.
     * 
     * @return List All the transaction types.
     * @throws java.lang.Exception
     */
    public List<TransactionType> getAllTransactionTypes() throws Exception;
    
    /**
     * Retrieves a list of all transaction based on name.
     * 
     * @param ttName The transaction type name.
     * @return List All the transaction types by name.
     * @throws java.lang.Exception
     */
    public List<TransactionType> searchTransactionByName(String ttName) throws Exception;
    
    /**
     * Retrieves a list of all transaction types like a description.
     * 
     * @param String The description snippet.
     * @return List All the transactions like a description.
     * @throws java.lang.Exception
     */
    public List<TransactionType> searchTransactionLikeDescription(String ttDescription) throws Exception;
    
}
