/**
 * Created by caroles on 29/03/2017.
 */
public class Placar {
    int placar[];
    public Placar () {
        placar = new int[10];
        for (int i = 0; i < 10; i++) placar[i] = -1;
    }

    public void add (int posicao, int[] dados) throws java.lang.IllegalArgumentException {
        /*Posição pode assumir valores entre 1 e 10, sendo os valores de um a seis referentes a essas casas;
        * a 7, FullHand; 8, sequencia; 9, quadra; 10, quina (cof, cof, GENERAL)*/
        if (posicao > 0 && posicao < 11) {
            switch (posicao) {
                case 1:
                    if (placar[0] != -1) throw IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 1) result += 1;
                        }
                        placar[0] = result;
                    }
                    break;

                case 2:
                    if (placar[1] != -1) throw IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 2) result += 1;
                        }
                        placar[1] = result;
                    }
                    break;

                case 3:
                    if (placar[2] != -1) throw IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 3) result += 1;
                        }
                        placar[2] = result;
                    }
                    break;

                case 4:
                    if (placar[3] != -1) throw IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 4) result += 1;
                        }
                        placar[3] = result;
                    }
                    break;

                case 5:
                    if (placar[4] != -1) throw IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 5) result += 1;
                        }
                        placar[4] = result;
                    }
                    break;

                case 6:
                    if (placar[5] != -1) throw IllegalArgumentException("Essa posição está ocupada.");
                    else {
                        int result = 0;
                        for(int i = 0; i<5; i++){
                            if(dados[i] == 6) result += 1;
                        }
                        placar[5] = result;
                    }
                    break;

                case 7: /*FULL HAND: 3 de um numero, 2 de outro ou 5 numeros iguais*/
                    int flagFull = 0, flag3 = 0, flag2 = 0;
                    int fullHand[];
                    fullHand = new int[5];
                    for(int i=0; i<5; i++) fullHand[i] = 0;

                    for(int i=0; i<5; i++) fullHand[dados[i]]++;

                    for(int i=0; i<5; i++){
                        if(fullHand[i] == 3) flag3 = 1;
                        if(fullHand[i] == 2) flag2 = 1;
                        if(fullHand[i] == 5) flagFull = 1;
                    }

                    if(flag2 == 1 && flag3 == 1) placar[6] = 15;
                    else if(flagFull == 1) placar[6] = 15;
                    else placar[6] = 0;

                    break;

                case 8: /*SEQUENCIA: todos os dados devem ser de 1 a 5 ou de 2 a 6*/
                    int sequencia[];
                    sequencia = new int[5];
                    for(int i=0; i<5; i++) sequencia[i] = 0;

                    for(int i=0; i<5; i++) sequencia[dados[i]]++;

                    for(int i=0; i<5; i++){
                        if(sequencia[i] > 1) placar[7] = 0;
                    }
                    if(placar[7] != 0) placar[7] = 20;

                    break;

                case 9: /*QUADRA: quatro numeros iguais*/
                    int quadra[];
                    quadra = new int[5];
                    for(int i=0; i<5; i++) quadra[i] = 0;

                    for(int i=0; i<5; i++) quadra[dados[i]]++;

                    for(int i=0; i<5; i++){
                        if(quadra[i] >= 4) placar[8] = 30;
                    }
                    if(placar[8] != 30) placar[8] = 0;

                    break;

                case 10: /*GENERAL: todos os numeros iguais*/
                    int general[];
                    general = new int[5];
                    for(int i=0; i<5; i++) general[i] = 0;

                    for(int i=0; i<5; i++) general[dados[i]]++;

                    for(int i=0; i<5; i++){
                        if(general[i] == 5) placar[9] = 40;
                    }
                    if(placar[9] != 40) placar[9] = 0;

                    break;
            }
        } else {
            throw IllegalArgumentException("Essa posição do placar não existe\n");
        }
    }

    public int getScore(){
        int resultado = 0;
        for(int i = 0; i<10; i++) resultado += placar[i];
        return resultado;
    }

    public String toString () {
        return " "+placar[0]+"     |    "+placar[6]+"     |    "+placar[3]+"  \n" +
                " --------------------------\n" +
                " "+placar[1]+"    |   "+placar[7]+"     |    "+placar[4]+"  \n" +
                " --------------------------\n" +
                " "+placar[2]+"     |   "+placar[8]+"     |    "+placar[5]+"  \n" +
                "--------------------------\n" +
                "        |    "+placar[9]+"    |\n" +
                "        +----------+ "
    }

}
