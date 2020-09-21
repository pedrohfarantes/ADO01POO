package bank;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Gustavo
 */
public class TestaADO {
    public static void main(String[] args) throws IOException {
        Bank banco = new Bank("resources/entrada.txt");
        System.out.println(Arrays.toString(banco.getAccounts()));
        System.out.println(banco.getTotalBalance());
    }
}
