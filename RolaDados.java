/**
 * Created by caroles on 28/03/2017.
 */

import java.lang.Integer;
import java.lang.String;

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
        int resultado[];
        resultado = new int[numeroDeDados];
        /*O vetor separados receberá cada substring da nossa string original,
         * as quais transformaremos em int*/
        String separados[];
        int tamVet = s.length() / 2;
        separados = new String[tamVet];
        separados = s.split(" ");
        for (int i = 0; i < separados.length(); i++) {
            resultado[i] = Integer.parseInt(separados[i]);
        }
        /*Acessa as posições no vetor que guardam quais dados devem ser rolados. Rola
        * esses dados.*/
        for (int i = 0; i < separados.length(); i++) {
            listaDeDados[resultado[i]] = Dado[resultado[i]].rolar();
        }
        return resultado;
    }

    @Override
    public String toString () {
        String dadosResultantes;
        for (int i = 0; i < 5; i++) {
            dadosResultantes += Dado.toString(listaDeDados[i]);
        }
        return dadosResultantes;
    }
}
