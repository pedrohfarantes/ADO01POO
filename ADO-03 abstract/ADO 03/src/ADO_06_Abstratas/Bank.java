/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADO_06_Abstratas;

import Aula_12_Classe_Abstrata.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Gustavo Braga
 */
public class Bank {
    private ArrayList<BankAccount> accounts;  //contas bancária

    public Bank() {
    }
    
    
    
    public Bank(String filename) {
        accounts = new ArrayList<>(); //Banco de contas

        try {
            
            BufferedReader r = new BufferedReader(new FileReader(filename));
            String linha = r.readLine(); // quantidade de dados a serem lidos
            int q = Integer.parseInt(linha);
            String linhas[] = new String[q];
            
            for (int i = 0; i < q; i++) {
                
                linha = r.readLine();
                linhas = linha.split("#");//split
                
                String tipo = linhas[0];//tipo de banco
                int numeroAccount = Integer.parseInt(linhas[1]);//numero da conta 
                String senha = linhas[2];//senhas
                String owner = linhas[3];//dono
                double balance = Double.parseDouble(linhas[4]);//saldo
                
                
                switch (tipo) {

                    case "RA"://RA(RegularAccount)
                        System.out.println("Entrou no RA");
                        double especialbalance = Double.parseDouble(linhas[5]);//saldo
                        BankAccount c1 = new RegularAccount(numeroAccount, senha, owner, balance, especialbalance);
                        this.addAccount(c1);
                        break;
                    //concluido

                    case "SA"://SA(SavingsAccount)
                        System.out.println("Entrou no SA");
                        double taxajuros = Double.parseDouble(linhas[5]);//saldo
                        BankAccount c2 = new SavingsAccount(numeroAccount, senha, owner, balance, taxajuros);
                        this.addAccount(c2);
                        break;
                    //concluido

                    case "CLA":// CLA(CityLawAccount)
                        System.out.println("Entrou no CLA");
                        String aim = linhas[5];//objetivo
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//formato da data 
                        Date dataAbertura = formato.parse(linhas[6]);//data de abertura 
                        Date dataFechamento = formato.parse(linhas[7]);//data fechamento
                        int anos = Integer.parseInt(linhas[8]);//anos
                        String city = linhas[9];//city
                        
                        LawAccount c3 = new CityLawAccount(numeroAccount, senha, owner, balance,
                        aim,dataAbertura,dataFechamento,anos,city);
                        this.addAccount(c3);
                        break;
                        
                    case "SLA"://SLA(StateLawAccount)
                        
                        System.out.println("Entrou SLA");
                        aim = linhas[5];//objetivo
                        formato = new SimpleDateFormat("dd/MM/yyyy");//formato da data 
                        dataAbertura = formato.parse(linhas[6]);//data de abertura 
                        dataFechamento = formato.parse(linhas[7]);//data fechamento
                        anos = Integer.parseInt(linhas[8]);//anos
                        city = linhas[9];//city
                        
                        LawAccount c4 = new StateLawAccount(numeroAccount, senha, owner, balance,
                        aim,dataAbertura,dataFechamento,anos,city);
                        this.addAccount(c4);
                        break;
                        
                    case "FLA"://FLA(FederationLawAccount).
                        
                        System.out.println("Entrou FLA");
                        aim = linhas[5];//objetivo
                        formato = new SimpleDateFormat("dd/MM/yyyy");//formato da data 
                        dataAbertura = formato.parse(linhas[6]);//data de abertura 
                        dataFechamento = formato.parse(linhas[7]);//data fechamento
                        anos = Integer.parseInt(linhas[8]);//anos
                        city = linhas[9];
                        
                        LawAccount c5 = new FederationLawAccount(numeroAccount, senha, owner, balance,
                        aim,dataAbertura,dataFechamento,anos,city);
                        this.addAccount(c5);
                        break;

                    default:
                        System.out.println("Tipo inválido '" + tipo + "' consultar o "+filename);
                        break;
                }
            }
            r.close();
            System.out.println("De certo !!");
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        

    }
    public String TipoBySigla(BankAccount a) {

        String resposta = "";

        if (a instanceof SavingsAccount) {
            resposta = "Tipo  = SA";
            return resposta;
            
        }
        if (a instanceof RegularAccount) {
            resposta = "Tipo = RA";
            return resposta;
        }
        if (a instanceof CityLawAccount ) {
            resposta = "Tipo  = CLA";
            return resposta;
            
        }
        if (a instanceof StateLawAccount) {
            resposta = "Tipo = SLA";
            return resposta;
        }
        if (a instanceof FederationLawAccount) {
            resposta = "Tipo = FLA";
            return resposta;
        }

        return resposta = "Não achou o tipo";
    }
    
    //Inseri uma conta no banco
    public void addAccount(BankAccount c) {
           accounts.add(c);
    }
    
    public ArrayList<BankAccount> getAccounts() {
       return this.accounts;
    }

    //Calcula o saldo total de todas as contas inseridas no banco
    public double getTotalBalance() {
       double soma = 0.0;
       for (BankAccount a: accounts){
           soma = soma + a.getBalance();
       }
       return soma;
    }
    
    /* recebe o número de uma conta bancária e devolve o objeto 
    vinculado a ela. Caso tal objeto não exista, devolver null.
    */
    public BankAccount buscaLinear(int accountNumber){
        //Devolve a conta vinculada a este número
        for (BankAccount a: accounts)
            if (a.getAccountNumber() == accountNumber)
                return a; //Achei
        return null; //Não achei
    }  
    
    //Devolve a conta com maior saldo
    public BankAccount getMaximum(){
        
        BankAccount max = accounts.get(0);
        for (int i = 1; i < accounts.size(); i++){
            BankAccount a = accounts.get(i);
            if (a.getBalance() > max.getBalance())
                max = a;
        }
        return max;
    }
    /*
    O método count, que recebe um limite e devolve a quantidade de contas 
    bancárias cujo saldo seja maior ou igual a este limite
    */
    public int count(double limite){
        int cont=0;
        for (int i = 0; i < accounts.size(); i++)
            if (accounts.get(i).getBalance() >= limite)
                cont++;
        return cont;
    }
    
    //Método de ordenação seleção do mínimo
    public void sortByNumber(){
        int n = accounts.size();
        
        for(int i = 0; i < n-1; i++){ //N-1 vezes
            int min = i;
            for(int j = i+1; j < n; j++){
                if(accounts.get(j).getAccountNumber() <
                        accounts.get(min).getAccountNumber())
                    min = j;
            }
            if(min != i){
                //Troca das contas 
                BankAccount aux = accounts.get(min);
                accounts.set(min, accounts.get(i));
                accounts.set(i, aux);
            }     
        }
        
    }
    //Método de ordenação seleção do mínimo
    public void sortByBalance(){
        int n = accounts.size();
        
        for(int i = 0; i < n-1; i++){ //N-1 vezes
            int min = i;
            for(int j = i+1; j < n; j++){
                if(accounts.get(j).getBalance() <
                        accounts.get(min).getBalance())
                    min = j;
            }
            if(min != i){
                //Troca das contas 
                BankAccount aux = accounts.get(min);
                accounts.set(min, accounts.get(i));
                accounts.set(i, aux);
            }     
        }
        
    }
    public BankAccount buscaBinaria(int accountNumber){
        int ini = 0;
        int fim = accounts.size()-1;
        
        while (ini <= fim){
            int meio = (ini + fim)/2;
            if(accounts.get(meio).getAccountNumber() ==
                    accountNumber)
                return accounts.get(meio); //Achou
            if(accounts.get(meio).getAccountNumber() <
                    accountNumber)
                ini = meio + 1;
            else 
                fim = meio - 1;
        }
        return null; //Não achou 
    }
  
    public void removeAccount(int accountNumber){
    // Remove uma conta pelo seu número
    for (BankAccount a: accounts){
            if (a.getAccountNumber() == accountNumber){
                accounts.remove(a);
                return;
           } 
    }
    System.out.println(accountNumber + "Não existe essa conta");
    }
    
    public void removeAccount(BankAccount c){
        /* Remove uma conta dada a instância
        if (accounts.contains(c))
            accounts.remove(c);
         */
        for (BankAccount a: accounts){
            if (a == c){
                accounts.remove(a);
                return;
           } 
        }  
    }
    
    public ArrayList<BankAccount> BankAccounts() {
        ArrayList<BankAccount> temp = new ArrayList<>();
        for (BankAccount a: accounts){
            if (!(a instanceof SavingsAccount)){
                temp.add(a);  
            } 
        }
        return temp;
    }
    public ArrayList<RegularAccount> regularAccounts() {
        ArrayList<RegularAccount> temp = new ArrayList<>();

        for (BankAccount a : accounts) {
            if (a instanceof RegularAccount) {
                int n = temp.size();
                
                for (int i = 0; i < n - 1; i++) { //N-1 vezes
                    int min = i;
                    
                    for (int j = i + 1; j < n; j++) {
                        if (temp.get(j).getBalance()
                                < temp.get(min).getBalance()) {
                            min = j;
                        }
                    }
                    if (min != i) {
                        //Troca das contas 
                        RegularAccount aux = temp.get(min);
                        temp.set(min, temp.get(i));
                        temp.set(i, aux);
                    }
                }
            }
        }
        return temp;
    }
   
    public ArrayList<SavingsAccount> SavingsAccounts() {
        ArrayList<SavingsAccount> temp = new ArrayList<>();
        for (BankAccount a: accounts){
            if (a instanceof SavingsAccount){
                int n = temp.size();
                
                for (int i = 0; i < n - 1; i++) { //N-1 vezes
                    int min = i;
                    
                    for (int j = i + 1; j < n; j++) {
                        if (temp.get(j).getBalance()
                                > temp.get(min).getBalance()) {
                            min = j;
                        }
                    }
                    
                    if (min != i) {
                        //Troca das contas 
                        SavingsAccount aux = temp.get(min);
                        temp.set(min, temp.get(i));
                        temp.set(i, aux);
                    }
                }
            } 
        }
        return temp;
    }
    
    
    
}
