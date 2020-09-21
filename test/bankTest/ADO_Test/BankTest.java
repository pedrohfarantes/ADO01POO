/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO_Test;

import bank.Bank;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class BankTest {
    
    @Test
    public void TestDefaultconstrutor() throws IOException{
        Bank banco = new Bank("entrada.txt");
        assertEquals("Maria do Carmo",banco.getAccounts()[0].getOwner());
        assertEquals("Jose da Silva",banco.getAccounts()[1].getOwner());
        assertEquals("Pedro Moreira",banco.getAccounts()[2].getOwner());
        assertEquals("Carlos Alberto",banco.getAccounts()[3].getOwner());
        assertEquals("Evandro Mesquita",banco.getAccounts()[4].getOwner());
        
       
    }
    @Test
    public void TestDefaultBalance() throws IOException{
        Bank banco = new Bank("entrada.txt");
        assertEquals(500.0,banco.getAccounts()[0].getBalance(),0.001);
        assertEquals(100.00,banco.getAccounts()[1].getBalance(),0.001);
        assertEquals(1500.0,banco.getAccounts()[2].getBalance(),0.001);
        assertEquals(2000.0,banco.getAccounts()[3].getBalance(),0.001);
        assertEquals(2500.0,banco.getAccounts()[4].getBalance(),0.001);
    }
    
    @Test
    public void TestDefaultTotalBalance() throws IOException{
        Bank banco = new Bank("entrada.txt");
        assertEquals(6600.0, banco.getTotalBalance(),0.001);
    }
    
}
