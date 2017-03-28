/**
 * Created by caroles on 28/03/2017.
 */
public class Dado {
    public Dado (int lados) extends java.lang.Object {
        this.lados = lados;
    }
    public Dado () {
        this.lados = 6;
    }
    int lados;
    int ultimoLancamento;

    public int rolar () {
        Random resultado = new Random();
        return Random.getIntRand(this.lados);
    }

    public int getLado () {
        ultimoLancamento = rolar();
        return ultimoLancamento;
    }

    @Override
    public String toString () {
        switch (ultimoLancamento) {
            case 1:
                return "+-----+" +
                        "|     |" +
                        "|  *  |" +
                        "|     |" +
                        "+-----+";
                break;
            case 2:
                return "+-----+" +
                        "|*    |" +
                        "|     |" +
                        "|    *|" +
                        "+-----+";
                break;
            case 3:
                return "+-----+" +
                        "|*    |" +
                        "|  *  |" +
                        "|    *|" +
                        "+-----+";
                break;
            case 4:
                return "+-----+" +
                        "|*   *|" +
                        "|     |" +
                        "|*   *|" +
                        "+-----+";
                break;
            case 5:
                return "+-----+" +
                        "|*   *|" +
                        "|  *  |" +
                        "|*   *|" +
                        "+-----+";
                break;
            case 6:
                return "+-----+" +
                        "|*   *|" +
                        "|*   *|" +
                        "|*   *|" +
                        "+-----+";
                break;
        }
    }

}
