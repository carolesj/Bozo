/**
 * Created by caroles on 28/03/2017.
 */

/**Auxilia o gerenciamento de múltiplos dados
 * @author Caroline Jesuíno (9293925); Beatriz Monteiro(9778619)
 */


import java.lang.Integer;
import java.lang.String;

/**Contrutor que seta o número de dados, cria um vetor de dados e o aloca
 * @param n número de dados em jogo
 * */
public class RolaDados {
    public RolaDados (int n) {
        this.numeroDeDados = n;
        listaDeDados = new Dado[n];
        for (int i = 0; i < n; i++) {
            listaDeDados[i] = new Dado();
        }
    }
    Dado listaDeDados[];
    int numeroDeDados;

    /**Rola todos os dados usando uma classe que gera números aleatórios
     * @return vetor de inteiros com os valores das faces para cima dos dados*/
    public int[] rolar () {
        int resultado[];
        resultado = new int[numeroDeDados];
        for (int i = 0; i < numeroDeDados; i++) {
            resultado[i] = listaDeDados[i].rolar();
        }
        return resultado;
    }

    /**Rola alguns dados usando uma classe que gera números aleatórios
     * @param quais vetor de booleanos que indica quais dados devem ser rolados
     * @return vetor de inteiros com o valor das faces para cima
     * */
    public int [] rolar (boolean[] quais) {
        int resultado[];
        resultado = new int[numeroDeDados];
        for (int i = 0; i < numeroDeDados; i++) {
            if (quais[i]) {
                resultado[i] = listaDeDados[i].rolar();
            } else {
                resultado[i] = listaDeDados[i].getLado();
            }
        }
        return resultado;
    }

    /**Rola alguns dados usando uma classe que gera números aleatórios
     * @param s string que indica quais dados devem ser rolados
     * @return vetor de inteiros com o valor das faces para cima
     * */
    public int [] rolar (String s) {
        int resultado[], auxiliar[];
        resultado = new int[numeroDeDados];
        /*O vetor separados receberá cada substring da nossa string original,
         * as quais transformaremos em int*/
        String separados[];
        separados = s.split(" ");
        int tam = separados.length;
        auxiliar = new int[tam];
        for (int i = 0; i < tam; i++) {
            auxiliar[i] = Integer.parseInt(separados[i]) - 1;
        }

        /*Acessa as posições no vetor que guardam quais dados devem ser rolados. Rola
        * esses dados.*/
        for (int i = 0; i < tam; i++) {
            listaDeDados[auxiliar[i]].rolar();
        }
        /*Atribui todos os valores (rolados e não rolados) para o vetor de resultados*/
        for (int i = 0; i < numeroDeDados; i++) {
            resultado[i] = listaDeDados[i].getLado();
        }
        return resultado;
    }

    /**Sobrescreve o método toString() da java.lang.Object, alterando sua função para representar uma sequência de
     *dados horizontalmente em estilo ASCII art.
     * @return a string que contém a representação
     * */
    @Override
    public String toString () {

        String result = " 1        2        3        4        5\n+-----+  +-----+  +-----+  +-----+  +-----+\n";
        for(int i=0; i< 5; i++) {
            if (listaDeDados[i].getLado() == 1) result +="|     |  ";
            else if (listaDeDados[i].getLado() == 2 || listaDeDados[i].getLado() == 3) result+="|*    |  ";
            else result+="|*   *|  ";
            if (i == 4) result+="\n";
        }

        for(int i=0; i< 5; i++) {
            if (listaDeDados[i].getLado() == 1 || listaDeDados[i].getLado() == 3 || listaDeDados[i].getLado() == 5) result+="|  *  |  ";
            else if (listaDeDados[i].getLado() == 6) result+="|*   *|  ";
            else result+="|     |  ";
            if (i == 4) result+="\n";
        }

        for(int i=0; i< 5; i++) {
            if (listaDeDados[i].getLado() == 2 || listaDeDados[i].getLado() == 3) result+="|    *|  ";
            else if (listaDeDados[i].getLado() == 1) result+="|     |  ";
            else result+="|*   *|  ";
            if (i == 4) result+="\n";
        }

        result+="+-----+  +-----+  +-----+  +-----+  +-----+\n";
        return result;
    }
}
