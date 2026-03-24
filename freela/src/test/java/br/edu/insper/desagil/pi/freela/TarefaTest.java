package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TarefaTest {
    private Tarefa tarefa;
    private Momento inicio;
    private Momento fim;
    @BeforeEach
    void setUp(){
        tarefa = new Tarefa(1);
        inicio = mock(Momento.class);
        fim = mock(Momento.class);
    }


    @Test
    void constroi(){
        assertEquals(1, tarefa.getId());
        assertEquals("", tarefa.getDescricao());
        assertNull(tarefa.getInicio());
        assertNull(tarefa.getFim());
    }

    @Test
    void mudaDescricao(){
        tarefa.setDescricao("daniel");
        assertEquals("daniel", tarefa.getDescricao());
    }

    @Test
    void momentosValidos(){
        when(inicio.minutos()).thenReturn(10);
        when(fim.minutos()).thenReturn(100);
        tarefa.atualiza(inicio, fim);
        assertEquals(inicio, tarefa.getInicio());
        assertEquals(fim, tarefa.getFim());
    }

    @Test
    void momentosInvalidos(){
        when(inicio.minutos()).thenReturn(100);
        when(fim.minutos()).thenReturn(10);
        assertThrows(IllegalArgumentException.class, () -> {
            tarefa.atualiza(inicio, fim);
        });
    }


}
