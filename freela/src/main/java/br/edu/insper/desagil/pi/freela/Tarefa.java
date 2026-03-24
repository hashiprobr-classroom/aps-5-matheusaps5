package br.edu.insper.desagil.pi.freela;

public class Tarefa {
    private int id;
    private String descricao = "";
    private Momento inicio = null;
    private Momento fim = null;


    public Tarefa(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public Momento getInicio() {
        return inicio;
    }

    public Momento getFim() {
        return fim;
    }


    public int getId() {
        return id;
    }

    public void atualiza(Momento inicio, Momento fim){
        if (inicio.minutos() >= fim.minutos()){
            throw new IllegalArgumentException("O inicio precisa ser antes do fim");
        }
        this.inicio = inicio;
        this.fim = fim;

    }
}
