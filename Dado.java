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
    int ultimoLancamento;

    Random resultado = new Random();

    public int rolar () {
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
