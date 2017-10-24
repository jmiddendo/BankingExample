/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.BankUser;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author jmid3
 */
@Remote
public interface BankUserRepository {
    
    /**
     * Adds a user to the database/
     * 
     * @param user The new user.
     * @throws Exception 
     */
    public void addBankUser(BankUser user) throws Exception;
                
    /**
     * Edits a user in the database.
     * 
     * @param user The new values for the user.
     * @throws Exception 
     */
    public void editBankUser (BankUser user) throws Exception;
    
    /**
     * Retrieves all the users in the database.
     * 
     * @return List All the users in the database.
     * @throws Exception 
     */
    public List<BankUser> getAllBankUsers() throws Exception;
    
    /**
     * Get the next available user id.
     * 
     * @return int The next available user id.
     * @throws Exception 
     */
    public int getNextUserId() throws Exception;
    
    /**
     * Removes a user from the database.
     * 
     * @param id The id of the user to be removed.
     * @throws Exception 
     */
    public void removeBankUser(int id) throws Exception;
    
    /**
     * Fetches a user based on id.
     * 
     * @param id The id that will be searched.
     * @return BankUser The user that matches the id.
     * @throws Exception 
     */
    public BankUser searchBankUserById(int id) throws Exception;
    
    /**
     * Fetches a set of users based on five different criteria.
     * 
     * @param user The user that has the five criteria.
     * @return Set The list of users.
     */
    public Set<BankUser> searchBankUserByCombination(BankUser user) throws Exception;
    
    /**
     * Searches all users based on an email.
     * 
     * @param email The email that will be searched.
     * @return Set The Set of users.
     * @throws Exception 
     */
    public Set<BankUser> searchUserByEmail(String email) throws Exception;
    
    /**
     * Searches all users based on state.
     * 
     * @param state The state that will be searched.
     * @return Set A set of users.
     * @throws Exception 
     */
    public Set<BankUser> searchUserByState(String state) throws Exception;
    
    /**
     * Searches all users based on suburb.
     * 
     * @param suburb The suburb that will be searched.
     * @return Set A set of users.
     * @throws Exception 
     */
    public Set<BankUser> searchUserBySuburb(String suburb) throws Exception;
    
    /**
     * Searches all users based on type
     * 
     * @param type The type that will be searched.
     * @return Set A set of users.
     * @throws Exception 
     */
    public Set<BankUser> searchUserByType(String type) throws Exception;
    
                  
}
