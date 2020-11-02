/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_07_Coleções;

import Aula_05_ADO_01_TDD.BankAccount;
import Aula_07_Dependência_Coleções.Bank;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anacris
 */
public class BankTest {
    
    @Test
    public void testDefaultConstrutor(){
        Bank banco = new Bank();
        assertEquals(0, banco.getLast());
        assertNotNull(banco.getAccounts());
    }
    
    @Test 
    public void testAddAccount(){
        Bank banco = new Bank();
        BankAccount c1 = new BankAccount("Ana", 500.00);
        banco.addAccount(c1);
        Assert.assertEquals("Ana", banco.getAccounts()[0].getOwner());
        Assert.assertEquals(1, banco.getLast());
        Assert.assertEquals(500.0, banco.getAccounts()[0].getBalance(), 0.01);
    }
    
    @Test 
    public void testGetTotalBalance(){
        Bank banco = new Bank();
       
        banco.addAccount(new BankAccount("Ana", 500.00));
        banco.addAccount(new BankAccount("Marcos", 600.00));
        
        Assert.assertEquals("Ana", banco.getAccounts()[0].getOwner());
        Assert.assertEquals("Marcos", banco.getAccounts()[1].getOwner());
        Assert.assertEquals(500.0, banco.getAccounts()[0].getBalance(), 0.01);
        Assert.assertEquals(600.0, banco.getAccounts()[1].getBalance(), 0.01);
        Assert.assertEquals(2, banco.getLast());
        
        Assert.assertEquals(1100.0,banco.getTotalBalance(), 0.01);
       
    }
    @Test 
    public void testFind(){
        Bank banco = new Bank();
        
        banco.addAccount(new BankAccount("Ana", 500.00));
        banco.addAccount(new BankAccount("Marcos", 600.00));
        
        System.out.println(banco.getAccounts()[0].getAccountNumber());
        System.out.println(banco.getAccounts()[1].getAccountNumber());
        assertEquals(1005, banco.getAccounts()[0].getAccountNumber());
        assertEquals(1006, banco.getAccounts()[1].getAccountNumber());
        
       
    }
    @Test 
    public void testgetMaximum(){
        Bank banco = new Bank();
        
        banco.addAccount(new BankAccount("Ana", 500.00));
        banco.addAccount(new BankAccount("Marcos", 600.00));
        banco.addAccount(new BankAccount("Marcelo", 350.00));
        
        assertEquals(600.0, banco.getMaximum().getBalance(), 0.01);
        assertEquals("Marcos", banco.getMaximum().getOwner());
    }
    
    @Test 
    public void testCount(){
        Bank banco = new Bank();
        
        banco.addAccount(new BankAccount("Ana", 500.00));
        banco.addAccount(new BankAccount("Marcos", 600.00));
        banco.addAccount(new BankAccount("Marcelo", 350.00));
        banco.addAccount(new BankAccount("Bruna", 400.00));
        
        assertEquals(2, banco.count(450.0));
 
    }
}
