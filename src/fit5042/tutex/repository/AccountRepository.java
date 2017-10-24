/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Account;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author jmid3
 */
@Remote
public interface AccountRepository {
    
    public void addAccount(Account acc) throws Exception;
    
    public void editAccount(Account acc) throws Exception;
    
    public List<Account> getAllAccounts() throws Exception;
    
    public int getNextAccountId() throws Exception;
    
    public void removeAccount(int id) throws Exception;
    
    public Account searchAccountById(int id) throws Exception;
    
    public Set<Account> searchAccountByStatus (boolean status) throws Exception;
    
    public Set<Account> serachAccountByType(String type) throws Exception;
    
    public Set<Account> searchAccountByUserId (int id) throws Exception;
    
}
