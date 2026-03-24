package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListaTest {
    private Lista list;
    private Tarefa tarefa;
    private Tarefa tarefa2;
    @BeforeEach
    void setUp(){
        list = new Lista();
        tarefa = new Tarefa(1);
        tarefa2 = new Tarefa(2);
    }

    @Test
    void constroi(){
        assertTrue(list.getTarefas().isEmpty());
    }

    @Test
    void adicionaIguais(){
        list.adiciona(tarefa);
        list.adiciona(tarefa);
        assertEquals(1, list.getTarefas().size());
    }

    @Test
    void adicionaDiferentes(){
        list.adiciona(tarefa);
        list.adiciona(tarefa2);
        assertEquals(2, list.getTarefas().size());

    }

}
