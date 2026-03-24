package br.edu.insper.desagil.pi.freela;

import java.util.HashMap;
import java.util.Map;

public class Data extends Momento {
    private int ano = 1970;
    private int mes = 1;
    private int dia = 1;
    private Map<Integer, Integer> limite;

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public Data() {
        Map<Integer, Integer> limite = new HashMap<>();
        limite.put(1, 31);
        limite.put(2, 28);
        limite.put(3, 31);
        limite.put(4, 30);
        limite.put(5, 31);
        limite.put(6, 30);
        limite.put(7, 31);
        limite.put(8, 31);
        limite.put(9, 30);
        limite.put(10, 31);
        limite.put(11, 30);
        limite.put(12, 31);
        this.limite = limite;

    }


    public void atualiza(int ano, int mes, int dia){
        this.ano = ajusta(ano, 1970, 2070);
        this.mes = ajusta(mes, 1, 12);
        this.dia = ajusta(dia, 1, limite.get(this.mes));
    }
    @Override
    public int minutos(){
        int anosParaMin = (this.ano - 1970) * 365 * 24 * 60;
        int somadias = 0;
        for (int mes : this.limite.keySet()){
            if (mes < this.mes){
                somadias += limite.get(mes);
            }
        }
        return anosParaMin + (somadias * 24 * 60) + ((this.dia - 1) * 24 * 60);
    }
}
