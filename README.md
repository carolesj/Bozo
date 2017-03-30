# Bozó
## Implementação do jogo Bozó (também conhecido como GENERAL) para a disciplina de POO, cursada no ICMC, no ano de 2017.

Esse jogo se baseia no lance de cinco dados simultaneamente. O jogador tenta completar 10 casas de um placar: 
#1, #2, #3, #4, #5, #6, Full House, Sequência, Quadra e General.

O **Full House** acontece quando o valor de três faces é igual entre si, e o valor das duas outras faces também. Vale 15 pontos;

A **Sequência** ocorre quando os números das faces viradas para cima são 1, 2, 3, 4 e 5 ou 2, 3, 4, 5, 6. Vale 20 pontos;

A **Quadra** acontece quando quatro das faces viradas para cima possuem o mesmo valor. Vale 30 pontos;

O **General**, por sua vez, ocorre quando todas as cinco faces mostram o mesmo valor. Vale 40 pontos;

As casas representadas por números significam um acúmulo de pontos desses valores e seu valor de pontuação é variado. Por exemplo,
ao final de uma rodada o perfil dos dados era o seguinte: 1, 1, 1, 4 3. Esse padrão não encaixa-se em nenhum dos anteriores, 
portanto, o jogador contemplado decidiu que usaria esse perfil para sua pontuação na casa **#1**. Soma-se então todos os valores
de 1 tirados nessa rodada, o que nos deixa com **#1 = 3**

O jogo acaba ao fim de dez rodadas, quando faz-se a soma do placar final.
