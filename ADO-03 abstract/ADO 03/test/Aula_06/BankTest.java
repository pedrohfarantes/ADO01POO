/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_06;

import Aula_05_ADO_01_TDD.BankAccount;
import Aula_06_Dependência_Vetor.Bank;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class BankTest {

    
    @Test
    public void TestDefaultconstrutor(){
        Bank banco = new Bank();
        assertEquals(0,banco.getLast());
        assertNotNull(banco.getAccounts());
    }
    
    @Test
    public void TestAddAccount(){
        Bank banco = new Bank();
        BankAccount c1 = new BankAccount("Gustavo",1000.0);
        banco.addAccount(c1);
        assertEquals("Gustavo",banco.getAccounts()[0].getOwner());
        assertEquals(1000.0,banco.getAccounts()[0].getBalance(),0.001);
        assertEquals(1,banco.getLast());
        
    }
    
    @Test
    public void TestGetTotalBalance(){
        Bank banco = new Bank();
        BankAccount c1 = new BankAccount("Gustavo",1000.0);
        banco.addAccount(c1);
        banco.addAccount(new BankAccount("Victor",1500.0) );
        assertEquals("Gustavo",banco.getAccounts()[0].getOwner());
        assertEquals("Victor",banco.getAccounts()[1].getOwner());
        assertEquals(1000.0,banco.getAccounts()[0].getBalance(),0.001);
        assertEquals(1500.0,banco.getAccounts()[1].getBalance(),0.001);
        assertEquals(2,banco.getLast());
        assertEquals(2500.0,banco.getTotalBalance(),0.001);
        
    }
    
    
    
    
}
