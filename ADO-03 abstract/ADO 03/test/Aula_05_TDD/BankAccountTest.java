/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_05_TDD;

import Aula_05_ADO_01_TDD.BankAccount;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anacris
 */
public class BankAccountTest {
    
    @Test
    public void constructorTest(){
        BankAccount conta = new BankAccount("Ana", 500.00);
        
        Assert.assertEquals("Ana", conta.getOwner());
        Assert.assertEquals(500.0, conta.getBalance(), 0.01);
        Assert.assertEquals(1001, conta.getAccountNumber());
        Assert.assertEquals(7, conta.getPassword().length());
        Assert.assertNotNull(conta.getPassword());
    }
    @Test
    public void depositTest(){
        BankAccount conta = new BankAccount("Ana", 500.00);
        conta.deposit(1000.00);
        Assert.assertEquals(1500.0, conta.getBalance(), 0.01);
    }
    
     @Test
    public void widrawTest(){
        BankAccount conta = new BankAccount("Ana", 500.00);
        conta.withdraw(200.0);
        Assert.assertEquals(300.0, conta.getBalance(), 0.01);
    }
    
    @Test
    public void makePasswordTest(){
        BankAccount conta = new BankAccount("Ana", 500.00);
        System.out.println(conta.getPassword());
        Assert.assertTrue(conta.getPassword() != null);
    }
    
}
