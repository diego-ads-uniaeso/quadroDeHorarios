package br.edu.uniaeso.quadrodehorarios.ia;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Individuo implements Comparable<Individuo>{

    int[] genes = new int[8];

    public Individuo() {
        for (int i = 0; i < genes.length; i++) {
            genes[i] = ThreadLocalRandom.current().nextInt(2);
        }
    }

    public int getFitness() {
        String s = Arrays.toString(genes).replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "");
        return Integer.parseInt(s, 2);
    }

    @Override
    public int compareTo(Individuo o) {
        if(this.getFitness() < o.getFitness()){
            return -1;
        } else if(this.getFitness() == o.getFitness()) {
            return 0;
        } else {
            return 1;
        }
    }

}
