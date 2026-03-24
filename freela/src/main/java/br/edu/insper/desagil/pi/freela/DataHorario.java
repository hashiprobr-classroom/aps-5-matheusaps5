package br.edu.insper.desagil.pi.freela;

public class DataHorario extends Momento {
    private int hora = 0;
    private int minuto = 0;
    private Data data;

    public DataHorario(Data data) {
        this.data = data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public Data getData() {
        return data;
    }

    public void atualiza(int hora, int minuto){
        this.hora = ajusta(hora, 0, 23);
        this.minuto = ajusta(minuto, 0, 59);
    }

    @Override
    public int minutos() {
        int minutosData = this.data.minutos();
        return minutosData + this.hora * 60 + this.minuto;
    }
}
