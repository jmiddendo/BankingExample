/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.BankTransaction;
import fit5042.tutex.repository.entities.BankUser;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jmid3
 */
@Remote
public interface WebServiceConsumptionRepository {
    
    /**
     * Consumes web service to search user by id.
     * 
     * @param id The id to be searched.
     * @return BankUser The Bank User
     */
    public String searchBankUserById(int id);
    
    /**
     * Consumes web service to search user by type
     * /
     * @param type The type that will be searched. 
     * @return BankUser The bank user.
     */
    public String searchBankUserByType(String type);
    
    /**
     * Consumes web service to search user by email.
     * 
     * @param email The email that will be searched
     * @return 
     */
    public String searchBankUserByEmail(String email);
    
    /**
     * Consumes web service to search user by type.
     * 
     * @param type The type that will be searched.
     * @return List The list of transactions.
     */
    public String searchTransactionByTransactionType(String type);

    
}
