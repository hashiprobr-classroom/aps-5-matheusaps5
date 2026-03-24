package br.edu.insper.desagil.pi.freela;

public abstract class Momento {
    public int ajusta(int valor, int min, int max){
        if (valor < min){
            return min;
        } else return Math.min(valor, max);
    }

    public abstract int minutos();

}
