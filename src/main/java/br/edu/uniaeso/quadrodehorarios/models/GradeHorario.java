package br.edu.uniaeso.quadrodehorarios.models;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class GradeHorario {

    private Horario[][] horarios;

    public GradeHorario() {
        this.horarios = new Horario[7][6];
    }

    public Horario[][] getHorarios() {
        return this.horarios;
    }

    public void placeHorario(Horario horario){
        for(int x = 0; x < 4; x++) {
            for(int y = 0; y < 6; y++) {
                if(horarios[x][y] == null) {
                    horarios[x][y] = horario;
                }
            }
        }
    }

}
