/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO_Empregado;

import ADO_Empresa.Empregado;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class EmpresaTest {
    
    @Test
    public void EmpregadoTest(){
        
        Empregado Joao = new Empregado ("Joao da Silva","Desenvolvedor",2000.0);
        Assert.assertEquals("Joao da Silva",Joao.getNome());
        Assert.assertEquals("Desenvolvedor",Joao.getCargo());
        Assert.assertEquals(2000.0,Joao.getSalario(), 0.001);
        
    }
    
    @Test
    public void aumentoTest(){
        
        Empregado Joao = new Empregado ("Joao da Silva","Desenvolvedor",2000.0);
        Joao.aumentarSalario(10.0);
        Assert.assertEquals(2200.0,Joao.getSalario(), 0.001);
        
    }

    
}
