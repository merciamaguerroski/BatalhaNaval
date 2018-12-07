
/**
 * Cria o jogo da batalha
 */
import java.util.*;
public class Jogo{
    // faz a jogada do usuario
    public void turnoJogador(int [][] tabComputador){
        Scanner input = new Scanner(System.in);
        int linha,coluna;
        System.out.println("Agora e voce: ");
        System.out.println("Selecione uma linha para atacar: ");
        linha = input.nextInt();
        while(linha > 10 || linha < 0) // Erro
         {
            System.out.println("Entre com uma linha valida: ");
            linha = input.nextInt();
         }
         System.out.println("Selecione uma coluna para atacar: ");
         coluna = input.nextInt();
         
        while(coluna > 10 || coluna < 0) // Erro
         {
            System.out.println("Entre com uma linha valida: ");
            coluna = input.nextInt();
         }
         
        if(tabComputador[linha-1][coluna-1] != 0){
            System.out.println("~~~~~~~ voce: ACERTOU ~~~~~~~");
            tabComputador[linha-1][coluna-1] = 0;
         }
         else{
            System.out.println("~~~~~~~ Voce: ERROU ~~~~~~~");
         }
         
    }
    
    // faz a jogada do computador
    public void turnoComputador(int[][] tabJogador){
         int linha,coluna;
         System.out.println("Se prepare para a jogada do computador: ");
         
         linha = (int)(Math.random()*7);
         coluna = (int)(Math.random()*5);
         
         if(tabJogador[linha][coluna] != 0){
            System.out.println("~~~~~~~ O cumputador: ACERTOU ~~~~~~~");
            tabJogador[linha][coluna] = 0;
         }
         else{
            System.out.println("~~~~~~~ O computador: ERROU ~~~~~~~");
         }
    }
     
    //verifica os acertos no tabuleiro
    public boolean acertosTabuleiro(int[][] tabuleiro){
         int acertos= 0;
         for(int l=0; l<tabuleiro.length; l++){
             for(int c=0; c<tabuleiro[l].length; c++){
                 acertos = acertos+tabuleiro[l][c];
             }
         }
         if(acertos == 0){
             return true;
         }
         return false;
    }
    
    //realiza a batalha naval
    public void batalhaNaval(int[][] tabJogador, int[][] tabComputador){
        System.out.println("A batalha vai começar!! ");
        while(true){
            turnoJogador(tabComputador);
            turnoComputador(tabJogador);
            if(acertosTabuleiro(tabJogador)){
                System.out.print("O computador ganhou.");
                break;
            }else if (acertosTabuleiro(tabComputador)){
                System.out.print("\n PARABENS! Voce ganhou.\n");
                break;
            }
        }
    }
}
