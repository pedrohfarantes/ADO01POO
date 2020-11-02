/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO_06_Abstratas;

import Aula_12_Classe_Abstrata.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author anacris
 */
public abstract class LawAccount extends BankAccount {
    private String aim;  //objetivo da conta
    private Date start;  //data da criação da conta
    private Date end;    //data de liberação da conta
    private double admFee; //taxa de administração (%)

    public LawAccount(int accountNumber,String password, String owner, 
        double balance, String aim, Date start, Date end, double admFee) {
        super(accountNumber, password, owner, balance);
        this.aim = aim;
        this.start = start;
        this.end = end;
        this.admFee = admFee;
    }
    //Polimorfismo de inclusão ou sobrescrita
    @Override
    public double getBalance(){
        // Devolve o saldo aplicado a taxa de adm
        return balance*(1 - admFee/100);
    }
    
    public String getAim() {
        return aim;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public double getAdmFee() {
        return admFee;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        return  "accountNumber=" + accountNumber + 
                ", password=" + password + ", owner=" + owner + 
                ", balance=" + balance  + ", aim=" + aim + ", start=" + 
                formato.format(start) + ", end=" + formato.format(end) + ", admFee=" + admFee + ", ";
    }
    
}
