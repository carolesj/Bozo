/**
 * Created by caroles on 28/03/2017.
 */

/**Representante de um dado de n lados.
 * @author Caroline Jesuíno (9293925); Beatriz Monteiro(9778619)
 */


public class Dado extends java.lang.Object {
    /**Construtor que recebe o número de lado dos dados
     * @param lados número de faces dos dados
     * */
    public Dado(int lados) {
        this.lados = lados;
    }

    /**Construtor default que seta o número de faces como 6*/
    public Dado() {
        this.lados = 6;
    }

    int lados;
    public int ultimoLancamento;

    private static Random resultado = new Random();

    /**Rola o dado, usando um rand até o valor mais alto (número de faces).
     * @return o valor do dado lançado*/
    public int rolar() {
        ultimoLancamento = (resultado.getIntRand(this.lados) + 1);
        return this.ultimoLancamento;
    }

    /**Retorna o valor da face virada para cima da última jogada
     * @return o valor do dado lançado na última rodada*/
    public int getLado() {
        return ultimoLancamento;
    }

    /**Sobrescreve o método toString() da java.lang.Object, alterando sua função para representar um dado
     * em estilo ASCII art.*/
    @Override
    public String toString() {
        switch (ultimoLancamento) {
            case 1:
                return "+-----+" +
                        "|     |" +
                        "|  *  |" +
                        "|     |" +
                        "+-----+";
            case 2:
                return "+-----+" +
                        "|*    |" +
                        "|     |" +
                        "|    *|" +
                        "+-----+";
            case 3:
                return "+-----+" +
                        "|*    |" +
                        "|  *  |" +
                        "|    *|" +
                        "+-----+";
            case 4:
                return "+-----+" +
                        "|*   *|" +
                        "|     |" +
                        "|*   *|" +
                        "+-----+";
            case 5:
                return "+-----+" +
                        "|*   *|" +
                        "|  *  |" +
                        "|*   *|" +
                        "+-----+";
            case 6:
                return "+-----+" +
                        "|*   *|" +
                        "|*   *|" +
                        "|*   *|" +
                        "+-----+";
        }
        return null;
    }
}
