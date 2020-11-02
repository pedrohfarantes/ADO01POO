/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO_06_Abstratas;

import Aula_12_Classe_Abstrata.*;

/**
 *
 * @author anacris
 */
public abstract class BankAccount {
    protected int accountNumber;
    protected String password;
    protected String owner;
    protected double balance;
    
    public BankAccount(int accountNumber, String password, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.owner = owner;
        this.balance = balance;
    }
    //Método abstrato, todas as classes filhas devem implementar este m
    public abstract double getBalance();
    
    //Método que realiza um depósito, de uma determinada quantia, em uma conta bancária
    public void deposit(double amount){
        if (amount <= 0) {
            System.out.println("Valor negativo para depósito");//mau estilo
            return; 
        }
        double newBalance = balance + amount;
        balance = newBalance;
    }
    
    //Método que realiza um saque, de uma determinada quantia, em uma conta bancária
    public void withdraw (double amount){
        if (amount >= this.balance) {
            return;
        }
        double newBalance = balance - amount;
        balance = newBalance;
    }
    
    //Método que transferi o valor especificado de uma conta para outra conta
    public void transfer (double amount, BankAccount target){
        /*
        double newBalance = this.balance - amount;
        this.balance = newBalance;
        double newBalanceTarget = target.balance + amount;
        target.balance = newBalanceTarget;
        */
        
        this.withdraw(amount);
        target.deposit(amount);
        
    }
    
    //Obtem o número da conta bancária

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }
    
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return  "accountNumber=" + accountNumber + 
                ", password=" + password + ", owner=" + owner + 
                ", balance=" + balance + ", ";
    }

       
    
}
