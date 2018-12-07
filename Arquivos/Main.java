
/**
 *Classe principal da batalha naval.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;
public class Main{
 
    public static void main (String[] args){
        System.out.println("JOGO DE BATALHA NAVAL");
        System.out.println("----------------------------------");
        Tabuleiros tabs = new Tabuleiros();
        tabs.criaTabuleiroComputador();
        tabs.criaTabuleiroJogador();  
        
        Jogo batalha = new Jogo();
        batalha.batalhaNaval(tabs.tabJogador, tabs.tabComputador);
    }
}
