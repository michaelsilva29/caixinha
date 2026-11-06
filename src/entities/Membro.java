package entities;

public class Membro {

    private String nome;
    private double saldo;

    public Membro(String nome) {
        this.nome = nome;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }


    public boolean contribuicao(double valor) {
        if (valor <= 0) {
            return false;
        } else {
            this.saldo += valor;
            return true;
        }

    }

    public boolean emprestimo(double valor) {
        if (valor <= 0) {
            return false;
        } else if (valor > saldo) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }

    }
}
