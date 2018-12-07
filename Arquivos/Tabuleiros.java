    
    /**
     * Essa classe cria os tabuleiros
     */
    import java.util.*;
    public class Tabuleiros{
        public int[][] tabComputador = new int[10][10];
        public int[][] tabJogador = new int[10][10];
    
    //faz o tabuleiro e popula com os navios do jogador-computador
    public void criaTabuleiroComputador(){ 
       criarBarcoComputador(tabComputador);
    }  
    //funçao jogador
    public void criaTabuleiroJogador(){
        criarBarcoUsuario(tabJogador);
    }
     
    //verifica se tem espaço para colocar espaço no tabuleiro para poder adicionar barco
    public boolean temEspaco(int[][] tabuleiro, int l, int c, int tamanho, double alinhamento){
        //fora da matriz
        if (alinhamento < 0.5){ //horizontal
            if (c > 10 - tamanho){return false;}
            for (int col = c; col<c+tamanho; col++){
                if (tabuleiro[l][col] != 0){
                    return false;
                }
            }
            return true;
        }else{ //vertical
            if (l > 10 - tamanho){return false;}
            for (int lin = l; lin<l+tamanho; lin++){
                if (tabuleiro[lin][c] != 0){
                    return false;
                }
            }
            return true;            
        }
        
    }
    
    //adiciona barco se ha espaço
    public void adicionarBarco(int[][] tabuleiro, int barco, int l, int c, int tamanho, double alinhamento){
        //fora da matriz
        if (alinhamento < 0.5){ //horizontal
            for (int col = c; col<c+tamanho; col++){
                    tabuleiro[l][col] = barco;
            }

        }else{ //vertical
            for (int lin = l; lin<l+tamanho; lin++){
                tabuleiro[lin][c] = barco;
            }

        }
        
    }
    
    //cria o barco de forma randomica do computador
    public void criarBarcoComputador(int[][] tabuleiro){
        int[] tamanhos ={1,1,2,2,2,3,4}; //define os barcos
        for (int barco=1; barco<=7; barco++){
            int tam = tamanhos[barco-1];
            double  alinhamento = Math.random() ;
            int col;
            int linha;
            do{
                col = (int)(Math.random()*5);
                linha = (int)(Math.random()*7);
            }while(temEspaco(tabuleiro,linha, col, tam, alinhamento) == false);
            adicionarBarco(tabuleiro, barco, linha, col, tam, alinhamento);
        }
    }
    
    //cria barcos do usuario
    public void criarBarcoUsuario(int[][] tabuleiro){
        Scanner t = new Scanner(System.in);
        int[] tamanhos ={1,1,2,2,2,3,4};
        String[] nomes = {"Barco pequeno 1", "Barco pequeno 2",
                        "Barco medio 1", "Barco medio 2", "Barco medio 3",
                        "Barco grande",
                        "Submarino"
        };
        
        for (int barco=1; barco<=7; barco++){
            int tam = tamanhos[barco-1];
            String nome = nomes[barco-1];
            char al;
            System.out.println("Este e seu tabuleiro agora: ");
            System.out.println();
            for (int l=0; l<tabJogador.length; l++){
                for(int c=0; c<tabJogador[l].length; c++){
                    System.out.print(tabJogador[l][c]+"\t|");
                }
                    System.out.println();
                }
            System.out.println("Digite o alinhamento do "+nome+":");
            al = t.nextLine().charAt(0);
            
            double  alinhamento = 0.3;//horizontal
            if (al == 'v' || al == 'V'){
                alinhamento = 0.6;
            }
            int col;
            int linha;
            do{       
                System.out.println("Digite a posicao de coluna do "+nome+":");
                col = Integer.parseInt(t.nextLine())-1;
                System.out.println("Digite a posicao de linha do "+nome+":");                
                linha= Integer.parseInt(t.nextLine())-1;
            }while(temEspaco(tabuleiro,linha, col, tam, alinhamento)==false);
            adicionarBarco(tabuleiro, barco, linha, col, tam, alinhamento);
        }
    }
}

