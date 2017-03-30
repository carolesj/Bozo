import com.sun.org.apache.xpath.internal.functions.FuncStringLength;

import java.io.IOException;

/**
 * Created by caroles on 29/03/2017.
 */
/**Roda o jogo
 * */
public class Bozo {
    public static void main (String[] args) throws IOException{

        RolaDados dados;
        dados = new RolaDados(5);
        Placar placar;
        placar = new Placar();

        int numeroRodadas = 10;
        System.out.printf("Bem vindo ao BOZÓ!\n");
        System.out.printf("==================\n");

        while (numeroRodadas > 0) {
            System.out.printf("Digite ENTER para iniciar a rodada\n");
            String enter = EntradaTeclado.leString();

            int resultados[] = dados.rolar();
            int counterDado = 0;
            System.out.println(dados);
            System.out.printf("Escolha os dados a serem rolados novamente ou digite ENTER para finalizar a rodada\n");
            String ASeremRolados = EntradaTeclado.leString();
            if (!ASeremRolados.equals("")) {
                resultados = dados.rolar(ASeremRolados);
                System.out.println(dados);

                System.out.printf("Escolha os dados a serem rolados novamente ou digite ENTER para finalizar a rodada\n");
                ASeremRolados = EntradaTeclado.leString();

                if (!ASeremRolados.equals("")) {

                    resultados = dados.rolar(ASeremRolados);

                }
                System.out.println(dados);
            } else System.out.println(dados);

            System.out.println(placar);
            System.out.printf("Escolha uma posicao de 1 a 10 para ser ocupada\n");
            int pos = EntradaTeclado.leInt();

            try {
                placar.add(pos, resultados);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Escolha uma posicao VALIDA para ser ocupada");
                pos = EntradaTeclado.leInt();
                placar.add(pos, resultados);
            }
                System.out.println(placar);

            numeroRodadas--;
        }

        System.out.println("Você obteve " + placar.getScore() + " pontos!\n");

    }
}
