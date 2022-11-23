package br.edu.uniaeso.quadrodehorarios.ia;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int geracoes = 50;

    public static void main(String[] args) {
        Populacao p = new Populacao();
        Cruzamento c = new Cruzamento();
        Mutacao m = new Mutacao();

        for (int x = 0; x < geracoes; x++) {
            Individuo[] i = p.selecao();
            i = c.cruzar(i[0], i[1]);
            p.pop.add(i[0]);
            p.pop.add(i[1]);
            m.realizarMutacao(p.pop);
        }

        Collections.sort(p.pop);
        Individuo melhor = p.pop.getLast();
        System.out.println(Arrays.toString(melhor.genes) + " fit: " + melhor.getFitness());
    }

}
