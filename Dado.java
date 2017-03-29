/**
 * Created by caroles on 28/03/2017.
 */
public class Dado extends java.lang.Object {
    public Dado (int lados)  {
        this.lados = lados;
    }
    public Dado () {
        this.lados = 6;
    }
    int lados;
    public int ultimoLancamento;

    Random resultado = new Random();

    public int rolar () {
        ultimoLancamento = (Random.getIntRand(this.lados) + 1);
        return this.ultimoLancamento;
    }

    public int getLado () {
        return ultimoLancamento;
    }

    @Override
    public String toString () {
        switch (ultimoLancamento) {
            case 1:
                return "+-----+\n" +
                        "|     |\n" +
                        "|  *  |\n" +
                        "|     |\n" +
                        "+-----+\n\n";
                break;
            case 2:
                return "+-----+\n" +
                        "|*    |\n" +
                        "|     |\n" +
                        "|    *|\n" +
                        "+-----+\n\n";
                break;
            case 3:
                return "+-----+\n" +
                        "|*    |\n" +
                        "|  *  |\n" +
                        "|    *|\n" +
                        "+-----+\n\n";
                break;
            case 4:
                return "+-----+\n" +
                        "|*   *|\n" +
                        "|     |\n" +
                        "|*   *|\n" +
                        "+-----+\n\n";
                break;
            case 5:
                return "+-----+\n" +
                        "|*   *|\n" +
                        "|  *  |\n" +
                        "|*   *|\n" +
                        "+-----+\n\n";
                break;
            case 6:
                return "+-----+\n" +
                        "|*   *|\n" +
                        "|*   *|\n" +
                        "|*   *|\n" +
                        "+-----+\n\n";
                break;
        }
    }

}
