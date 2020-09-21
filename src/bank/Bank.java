package bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author phfar
 */
public class Bank {

    private BankAccount accounts[];  //contas bancárias
    private int last;                //Último índice da conta inserida

    public Bank() {
        accounts = new BankAccount[100]; //Banco no , no máximo, 100 contas
        last = 0;
    }
    
    public Bank(String fileName) throws FileNotFoundException, IOException {
        accounts = new BankAccount[100];
        
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
            System.out.println(numContas+"\n");
            
            //Lê as contas do arquivo e insere no array
            while ((line = bufferedReader.readLine()) != null) {
                
                String content = line;
                String[] contentSplit = content.split("#");
                
                //Cria a conta e seta os valores
                BankAccount conta = new BankAccount(contentSplit[2]);
                conta.setAccountNumber(Integer.parseInt(contentSplit[0]));
                conta.setPassword(contentSplit[1]);
                conta.setBalance(Double.parseDouble(contentSplit[3]));
                
                addAccount(conta);
            }
            
            fileReader.close();
        }
    }
    
    public BankAccount[] getAccounts() {
        return this.accounts;
    }

    public int getLast() {
        return this.last;
    }

    //Inseri uma conta no banco
    public final void addAccount(BankAccount c) {
        if (this.last < 99) {
            accounts[last] = c;
            last++;
        }
    }

    //Calcula o saldo total de todas as contas inseridas no banco
    public double getTotalBalance() {
        double soma = 0.0;
        for (int i = 0; i < last; i++) {
            soma = soma + accounts[i].getBalance();
        }
        return soma;
    }
}