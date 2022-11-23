package br.edu.uniaeso.quadrodehorarios.ia;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Mutacao {

    public void realizarMutacao(List<Individuo> pop) {
        int chance = 5;

        for (Individuo individuo : pop) {
            int num = ThreadLocalRandom.current().nextInt(100);
            if (num < chance) {
                int i = ThreadLocalRandom.current().nextInt(individuo.genes.length);
                individuo.genes[i] = individuo.genes[i] == 1 ? 0 : 1;
            }
        }
    }
}
