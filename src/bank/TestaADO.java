package bank;

import java.io.IOException;

/**
 *
 * @author JPG
 */
public class TestaADO {
    
    public static void main(String[] args) throws IOException {
        Bank banco = new Bank("resources/entradaDesordenada.txt");
        banco.sort();
        banco.dump("resources/gravadorDeArquivosDoBanco.txt");
        
        
       
        
    }
    
}
