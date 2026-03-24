package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataHorarioTest {
    private DataHorario datahorario;

    @BeforeEach
    void setUp(){
        Data datamock = mock(Data.class);
        datahorario = new DataHorario(datamock);
        when(datamock.minutos()).thenReturn(0);
    }

    @Test
    void constroi(){
        assertEquals(0, datahorario.getHora());
        assertEquals(0, datahorario.getMinuto());
        assertEquals(0, datahorario.minutos());
    }

    @Test
    void horarioBaixo(){
        datahorario.atualiza(-1,-1);
        assertEquals(0, datahorario.getHora());
        assertEquals(0, datahorario.getMinuto());
        assertEquals(0, datahorario.minutos());
    }

    @Test
    void horarioAlto(){
        datahorario.atualiza(24,60);
        assertEquals(23, datahorario.getHora());
        assertEquals(59, datahorario.getMinuto());
        assertEquals(1439, datahorario.minutos());

    }
}
