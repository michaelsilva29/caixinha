package entities;

public class Movimentacao {

    private String tipo;
    private double valor;
    private String descricao;

    public Movimentacao(String tipo, double valor, String descricao){
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString(){
        return tipo +
                " | R$ "
                + String.format("%.2f", valor)
                + " | "
                + descricao;
    }
}
