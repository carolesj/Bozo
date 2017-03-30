/**
 * Created by caroles on 29/03/2017.
 */

/** Organiza o placar do jogo
 * */
public class Placar {
    int placar[];
    /**Construtor que seta um vetor de dez posições para ser o placar e o aloca com valores inválidos de
     * pontuação (-1)
     * */
    public Placar () {
        placar = new int[10];
        for (int i = 0; i < 10; i++) placar[i] = -1;
    }

    /**Verifica onde deve inserir cada pontuação e se a jogada é válida
     * @param posicao onde deve ser inserida a pontuação
     * @param dados o vetor que contém os dados da jogada a ser inserida
     * */
    public void add (int posicao, int[] dados) throws java.lang.IllegalArgumentException {
        /*Posição pode assumir valores entre 1 e 10, sendo os valores de um a seis referentes a essas casas;
        * a 7, FullHand; 8, sequencia; 9, quadra; 10, quina (cof, cof, GENERAL)*/
        if (posicao > 0 && posicao < 11) {
            switch (posicao) {
                /*De 1 a 6 o switch vê quantos dados mostram a face escolhida para cima e coloca a soma dos
                * valores na 'posicao'*/
                case 1:
                    if (placar[0] != -1) throw new IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 1) result += 1;
                        }
                        placar[0] = result;
                    }
                    break;

                case 2:
                    if (placar[1] != -1) throw new IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 2) result += 2;
                        }
                        placar[1] = result;
                    }
                    break;

                case 3:
                    if (placar[2] != -1) throw new IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 3) result += 3;
                        }
                        placar[2] = result;
                    }
                    break;

                case 4:
                    if (placar[3] != -1) throw new IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 4) result += 4;
                        }
                        placar[3] = result;
                    }
                    break;

                case 5:
                    if (placar[4] != -1) throw new IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 5) result += 5;
                        }
                        placar[4] = result;
                    }
                    break;

                case 6:
                    if (placar[5] != -1) throw new IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 6) result += 6;
                        }
                        placar[5] = result;
                    }
                    break;

                /*Verifica a validade de um full hand, usando flags para quando há 3 números iguais,
                * 2 números iguais e 5 números iguais*/
                case 7: /*FULL HAND: 3 de um numero, 2 de outro ou 5 numeros iguais*/
                    int flagFull = 0, flag3 = 0, flag2 = 0;
                    int fullHand[];
                    fullHand = new int[6];
                    for(int i=0; i<5; i++) fullHand[dados[i] - 1]++;

                    for(int i=0; i<6; i++){
                        if(fullHand[i] == 3) flag3 = 1;
                        if(fullHand[i] == 2) flag2 = 1;
                        if(fullHand[i] == 5) flagFull = 1;
                    }

                    if(flag2 == 1 && flag3 == 1) placar[6] = 15;
                    else if(flagFull == 1) placar[6] = 15;
                    else placar[6] = 0;

                    break;
                /*Verifica a validade de uma sequência, alocando um vetor de 6 posições, cada qual com um
                * contador de frequência na jogada. Se o contador for maior que 1 em alguma das casas, significa
                * que alguma outra aparece mais de uma vez. Isso descaracteriza uma sequência.*/
                case 8: /*SEQUENCIA: todos os dados devem ser de 1 a 5 ou de 2 a 6*/
                    int sequencia[];
                    sequencia = new int[6];
                    for(int i=0; i<5; i++) sequencia[dados[i] - 1]++;

                    for(int i=0; i<6; i++){
                        if(sequencia[i] > 1) placar[7] = 0;
                    }
                    if(placar[7] != 0) placar[7] = 20;

                    break;

                /*Verifica a validade de uma quadra, vendo se algum dos índices de frequência dos dados
                * é maior ou igual a 4*/
                case 9: /*QUADRA: quatro numeros iguais*/
                    int quadra[];
                    quadra = new int[6];
                    for(int i=0; i<5; i++) quadra[dados[i] - 1]++;

                    for(int i=0; i<6; i++){
                        if(quadra[i] >= 4) placar[8] = 30;
                    }
                    if(placar[8] != 30) placar[8] = 0;

                    break;

                /*Verifica a validade de um general, vendo se algum dos índices de frequência dos dados
                * é igual a 5*/
                case 10: /*GENERAL: todos os numeros iguais*/
                    int general[];
                    general = new int[6];
                    for(int i=0; i<5; i++) general[dados[i] - 1]++;

                    for(int i=0; i<6; i++){
                        if(general[i] == 5) placar[9] = 40;
                    }
                    if(placar[9] != 40) placar[9] = 0;

                    break;
            }
        } else {
            throw new IllegalArgumentException("Essa posição do placar não existe\n");
        }
    }

    /**Soma todos os valores contidos no vetor de placar
     * @return o valor da soma do vetor de placar*/
    public int getScore(){
        int resultado = 0;
        for(int i = 0; i<10; i++) resultado += placar[i];
        return resultado;
    }

    /**Representa a tabela de pontos do jogo
     * @return a string com a representação da tabela*/
    public String toString () {
        return  " "+(placar[0] == -1 ? "(1)" : placar[0])+"     " +
                "|   "+(placar[6] == -1 ? "(7)" : placar[6])+"     " +
                "|    "+(placar[3] == -1 ? "(4)" : placar[3])+"  \n" +
                " --------------------------\n" +
                " "+(placar[1] == -1 ? "(2)" : placar[1])+"     " +
                "|    "+(placar[7] == -1 ? "(8)" : placar[7])+"    " +
                "|    "+(placar[4] == -1 ? "(5)" : placar[4])+"  \n" +
                " --------------------------\n" +
                " "+(placar[2] == -1 ? "(3)" : placar[2])+"     " +
                "|   "+(placar[8] == -1 ? "(9)" : placar[8])+"     " +
                "|    "+(placar[5] == -1 ? "(6)" : placar[5])+"  \n" +
                "--------------------------\n" +
                "        |    "+(placar[9] == -1 ? "(10)" : placar[9])+"    |\n" +
                "        +----------+ ";
    }

}
