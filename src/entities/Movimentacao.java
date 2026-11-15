package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimentacao {

    private String tipo;
    private double valor;
    private String descricao;
    private LocalDateTime dataHora;
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Movimentacao(String tipo, double valor, String descricao){
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.now();
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString(){
        return "[" + dataHora.format(fmt)
                + "]"
                + " | "
                + tipo
                + " | R$ "
                + String.format("%.2f", valor)
                + " | "
                + descricao;
    }
}
