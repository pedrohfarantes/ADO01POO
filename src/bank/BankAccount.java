/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author phfar
 */
public class BankAccount {
    private static int lastAccountNumber = 1000; //Último número utilizado de conta
    
    private String owner;
    private int accountNumber;
    private double balance;
    private String password;

    
    
    //Criar uma conta bancária com saldo = 0 e nome do cliente
    public BankAccount(){
        
    }
    
    //Criar uma conta bancária com o nome do cliente e um dado saldo

    public BankAccount(int numconta, String senha ,String owner, double balance) {
        lastAccountNumber++;
        this.accountNumber = numconta;
        this.password = senha;
        this.accountNumber = lastAccountNumber;
        this.balance = balance;
        this.password = makePassword();
    }
   
    
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
    
    //Obtem o saldo da conta bancária
    public double getBalance() {
        return balance;
    }
    
    //Obtem o número da conta bancária

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }
    

    public static int getLastAccountNumber() {
        return lastAccountNumber;
    }
    
    public String getPassword() {
        return password;
    }
    
    public static String checkName(String owner) {
       if(owner.matches("[a-zA-Z]+")){
           return owner;
       }else {
           throw new Error("Nome inválido, deve conter somente caracteres");
       }

   }
   public static String makePassword() {
       StringBuilder str = new StringBuilder();
       
       for(int i=0; i < 3; i++) {
           str.append(randomLetter());
       }
       for(int i=0; i < 4; i++) {
           str.append(randomDigit());
       }
       return str.toString();

  } 
   public static String randomLetter(){
       String alphabet = "abcdefghijklmnopqrstuvxz";
       int num = (int)(Math.random()*alphabet.length());
       char c = alphabet.charAt(num);
       return String.valueOf(c);
   }
   public static String randomDigit(){
       int num = (int)(Math.random()*10);
       return String.valueOf(num);
   }

    @Override
    public String toString() {
        return "BankAccount{" + "owner=" + owner + ", accountNumber=" + accountNumber + ", balance=" + balance + ", password=" + password + '}';
    }   

    public static void setLastAccountNumber(int lastAccountNumber) {
        BankAccount.lastAccountNumber = lastAccountNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
