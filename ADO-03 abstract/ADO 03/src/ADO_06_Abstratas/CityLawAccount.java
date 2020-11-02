/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO_06_Abstratas;

import Aula_12_Classe_Abstrata.*;
import java.util.Date;

/**
 *
 * @author anacris
 */
public class CityLawAccount extends LawAccount {
    private String cityName;

    public CityLawAccount(int accountNumber, String password, String owner, 
            double balance, String aim, Date start, Date end, double admFee,
            String cityName) {
        super(accountNumber, password, owner, balance,aim, start,end,admFee);
        this.cityName = cityName;
    }
    
    @Override
    public double getBalance(){
        return super.getBalance();
    }

    @Override
    public String toString() {
        return "\n"+ "CityLawAccount{" + super.toString() 
                   + "cityName=" + cityName + '}';
    }
    
}
