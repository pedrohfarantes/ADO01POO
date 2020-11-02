/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_07_coleções;

import Aula_05_ADO_01_TDD.BankAccount;
import Aula_07_Dependência_Coleções.Bank1;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Gustavo
 */
public class TestNewBank1 {
    
    @Test 
    public void testGetTotalBalance(){
        Bank1 banco = new Bank1();
       
        banco.addAccount(new BankAccount("Gustavo", 500.0));
        banco.addAccount(new BankAccount("Victor", 600.0));
        
        assertEquals("Gustavo", banco.getAccounts().get(0).getOwner());
        assertEquals("Victor", banco.getAccounts().get(1).getOwner());
        assertEquals(500.0, banco.getAccounts().get(0).getBalance(), 0.01);
        assertEquals(600.0, banco.getAccounts().get(1).getBalance(), 0.01);

        
        Assert.assertEquals(1100.0,banco.getTotalBalance(), 0.01);
       
    }
    
    @Test
    public void testFind(){
        Bank1 banco = new Bank1();
        
        banco.addAccount(new BankAccount("Ana", 500.00));
        banco.addAccount(new BankAccount("Marcos", 1600.00));
        
        
        assertEquals(1005, banco.getAccounts().get(0).getAccountNumber());
        assertEquals(1006, banco.getAccounts().get(1).getAccountNumber());
        
    }
    @Test 
    public void testgetMaximum(){
        Bank1 banco = new Bank1();
        
        banco.addAccount(new BankAccount("Ana", 500.00));
        banco.addAccount(new BankAccount("Marcos", 1600.00));
        banco.addAccount(new BankAccount("Marcelo", 350.00));
        
        assertEquals(1600.0, banco.getMaximum().getBalance(), 0.01);
        assertEquals("Marcos", banco.getMaximum().getOwner());
    }
    
    @Test
    public void testCount(){
        Bank1 banco = new Bank1();
        
        banco.addAccount(new BankAccount("Ana", 500.00));
        banco.addAccount(new BankAccount("Marcos", 600.00));
        banco.addAccount(new BankAccount("Marcelo", 350.00));
        banco.addAccount(new BankAccount("Bruna", 400.00));
        
        assertEquals(2, banco.count(450.0));
 
    }
    
    @Test
    public void testFindbinario(){
        Bank1 banco = new Bank1();
        
        banco.addAccount(new BankAccount("Ana", 500.00));
        banco.addAccount(new BankAccount("Marcos", 600.00));
        banco.addAccount(new BankAccount("Marcelo", 350.00));
        banco.addAccount(new BankAccount("Bruna", 400.00));
        
        
 
    }    
    
}
