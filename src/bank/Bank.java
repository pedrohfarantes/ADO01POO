package bank;

import fileHandler.FileHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author phfar
 */
public class Bank {

    // private BankAccount accounts[];  //contas bancárias
    private int last; 
    private ArrayList<BankAccount> accounts;//Último índice da conta inserida

    public Bank(){
        accounts = new ArrayList<BankAccount>(); //Banco de contas
    }
    
    public Bank(String fileName) throws FileNotFoundException, IOException {
        
        
        //Lê o arquivo
        File arquivoLeitura = new File(fileName);
        try (FileReader fileReader = new FileReader(arquivoLeitura)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String firstLineContent = null;
            
            //Leitura da primeira linha da entrada
            if ((line = bufferedReader.readLine()) != null) {
                firstLineContent = line;
            }
            int numContas = Integer.parseInt(firstLineContent);
           
            
            //Lê as contas do arquivo e insere no array
            while ((line = bufferedReader.readLine()) != null) {
                
                String content = line;
                String[] contentSplit = content.split("#");
                
                
                int numconta = Integer.parseInt(contentSplit[0]);
                
                String senha = (contentSplit[1]);
                
                String nome = (contentSplit[2]);
                
                double balance =(Double.parseDouble(contentSplit[3]));
                
                //banco.getAccounts().add(new BankAccount(numconta,senha,nome,balance));
                // banco.addAccount(new BankAccount(numconta,senha,nome,balance));
                BankAccount conta = new BankAccount();
                conta.setAccountNumber(numconta);
                conta.setPassword(senha);
                conta.setOwner(nome);
                conta.setBalance(balance);
                
                accounts.add(conta);

                
                
                
                
                
            }
            
            fileReader.close();
        }
    }
    public void sort() {
        for (int i = 0; i < accounts.size(); i++) {
            int menor = i;
            for (int j = i + 1; j < last; j++) {
                if (accounts.get(j).getAccountNumber() < accounts.get(menor).getAccountNumber()) {
                    menor = j;
                }
            }
            int accountI = accounts.get(i).getAccountNumber();
            int accountM = accounts.get(i).getAccountNumber();
            int aux = accountI;
            accountI = accountM;
            accountM = aux;
        }
    }
     public void dump(String path) throws IOException {
        //String path = "resources/gravadorDeArquivosDoBanco.txt";
        String txt = "";
        for (int i = 0; i < accounts.size(); i++) {
            txt += "Conta número: " + accounts.get(i).getAccountNumber()
                    + "\nSenha: " + accounts.get(i).getPassword()
                    + "\nProprietário " + accounts.get(i).getOwner()
                    + "\nSaldo " + accounts.get(i).getBalance();
        }
        if (FileHandler.writer(path, txt)) {
            System.out.println("Arquivo salvo com sucesso");
        } else {
            System.out.println("Erro ao salvar o arquivo");
        }

    }
        public BankAccount FindBinario(int elemento){
        
        int tamanho = accounts.size();
        ArrayList<BankAccount> c = accounts;
        int x = BuscaRecursiva(c, elemento, 0, c.size()-1);
        
        return c.get(x);
       
        
    }
       
    private int BuscaRecursiva(ArrayList<BankAccount> c, int elemento, int inicio, int fim) {
        int medio = (inicio + fim)/2;
        if(inicio > fim){
            return -1;
        }
        if(c.get(medio).getAccountNumber() == elemento){
            return medio;
        }
        if(c.get(medio).getAccountNumber() < elemento){
            return BuscaRecursiva(c, elemento, medio +1, fim);
        }
        else{
            return BuscaRecursiva(c, elemento, inicio, medio-1);
        }
    } 
     
    
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
    public BankAccount find(int accountNumber){
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
}