package Aula_05_TDD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Aula_05_ADO_01_TDD.Retangulo;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anacris
 */
public class RetanguloTest {
    @Test
    public void testeArea() {
          Retangulo r = new Retangulo(5,10,20,30);
          Assert.assertEquals (600, r.area());
    }

    @Test
    public void testeTransladar() {
          Retangulo r = new Retangulo(5,10,20,30);
          Assert.assertEquals (5, r.getX());
          r.transladar(10,10);
          Assert.assertEquals (15, r.getX());
          assertEquals (20, r.getY());
    }

    
}
