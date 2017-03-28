/**
 * Created by caroles on 28/03/2017.
 */
public class RolaDados {
    public RolaDados (int n) {
        this.numeroDeDados = n;
        listaDeDados = new Dado[n];
    }
    Dado listaDeDados[];
    int numeroDeDados;

    public int[] rolar () {
        int resultado[];
        resultado = new int[numeroDeDados];
        for (int i = 0; i < numeroDeDados; i++) {
            resultado[i] = Dado.rolar(listaDeDados[i]);
        }
        return resultado;
    }

    public int [] rolar (boolean[] quais) {
        int resultado[];
        resultado = new int[numeroDeDados];
        for (int i = 0; i < numeroDeDados; i++) {
            if (quais[i]) {
                resultado[i] = Dado[i].rolar();
            } else {
                resultado[i] = Dado[i].getLados();
            }
        }
        return resultado;
    }

    public int [] rolar (String s) {

    }
}
