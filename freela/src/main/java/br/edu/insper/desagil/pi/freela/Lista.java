package br.edu.insper.desagil.pi.freela;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    private List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void adiciona(Tarefa tarefa){
        boolean temtarefa = false;
        if (!tarefas.isEmpty()){
            for (Tarefa tar : tarefas){
                if (tar.getId() == tarefa.getId()){
                    temtarefa = true;
                }
            }
            if (!temtarefa){
                tarefas.add(tarefa);
            }
        } else {
            tarefas.add(tarefa);
        }
    }
}
