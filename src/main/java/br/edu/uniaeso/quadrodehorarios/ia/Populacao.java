package br.edu.uniaeso.quadrodehorarios.ia;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Populacao {

    int popInicial = 50;
    LinkedList<Individuo> pop = new LinkedList<>();

    public Populacao() {
        for (int x = 0; x < popInicial; x++) {
            pop.add(new Individuo());
        }
    }

    public Individuo[] selecao() {
        Collections.sort(pop);

        Individuo[] selecionados = new Individuo[2];

        double[] chances = new double[pop.size()];
        int totalFitness = 0;

        for (Individuo individuo : pop) {
            totalFitness += individuo.getFitness();
        }

        double acc = 0;

        for (int x = 0; x < pop.size(); x++) {
            Individuo individuo = pop.get(x);
            acc += (individuo.getFitness() * 100) / totalFitness;
            chances[x] = acc;
        }

        int indice = 0;
        while (selecionados[0] == null || selecionados[1] == null) {
            int num = ThreadLocalRandom.current().nextInt(100);
            
            for (int i = 0; i < chances.length; i++) {
                if (num <= chances[i]) {
                    selecionados[indice] = pop.get(i);
                    indice++;
                    break;
                }
            }
        }

        return selecionados;
    }
}
