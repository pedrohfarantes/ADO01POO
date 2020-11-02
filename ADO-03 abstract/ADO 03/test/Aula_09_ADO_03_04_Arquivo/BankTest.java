/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_09_ADO_03_04;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anacris
 */
public class BankTest {
    @Test
    public void testNOTDefaultConstrutor(){
        Bank b = new Bank("entrada.txt");
        assertNotNull(b.getAccounts());
        
        assertEquals(1011,b.getAccounts().get(0).getAccountNumber());
        assertEquals("Roberto Rodrigues",b.getAccounts().get(0).getOwner());
        assertEquals(630.0,b.getAccounts().get(1).getBalance(),0.01);
        assertEquals("3456",b.getAccounts().get(2).getPassword());
    
    } 
    @Test
    public void testSortByNumber(){
        Bank b = new Bank("entrada.txt");
        assertNotNull(b.getAccounts());
        System.out.println(b.getAccounts());
        
        //Ordenado pelo método SelectionSort
        b.sortByNumber();
        
        assertNotNull(b.getAccounts());
        System.out.println(b.getAccounts());
        assertEquals(1011,b.getAccounts().get(0).getAccountNumber());
        assertEquals(1033,b.getAccounts().get(1).getAccountNumber());
        assertEquals(1037,b.getAccounts().get(2).getAccountNumber());
        assertEquals(2045,b.getAccounts().get(3).getAccountNumber());
        assertEquals(2062,b.getAccounts().get(4).getAccountNumber());
    }
    @Test
    public void testBuscaBinaria(){
        Bank b = new Bank("entrada.txt");
        assertNotNull(b.getAccounts());
        System.out.println(b.getAccounts());
        
        //Ordenado pelo método SelectionSort
        b.sortByNumber();
        //Busca binária
        System.out.println(b.buscaBinaria(2045).getOwner());
        System.out.println(b.buscaBinaria(2222)); //Não achou
        
    }
    @Test
    public void testDump(){
        Bank b = new Bank("entrada.txt");
        assertNotNull(b.getAccounts());
        b.dump("saida.txt");
        assertNotNull(b.getAccounts());
    }
    
    

}
