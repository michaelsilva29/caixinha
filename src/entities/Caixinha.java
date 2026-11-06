package entities;

public class Caixinha {

    private Membro membro;
    private Movimentacao[] movimentacoes;
    private int contador;

    public Caixinha(Membro membro, int capacidade) {
        this.membro = membro;
        this.movimentacoes = new Movimentacao[capacidade];
        this.contador = 0;
    }

    public double getSaldo() {
        return membro.getSaldo();
    }

    public boolean valorMaiorQueZero(double valor) {
        return valor > 0;
    }

    public boolean capacidadeSuficiente() {
        return contador < movimentacoes.length;
    }

    public boolean ePossivelEmprestar(double valor) {
        return valor <= membro.getSaldo();
    }

    public boolean contribuicao(double valor) {
        if (!capacidadeSuficiente()) {
            return false;
        }
        if (!valorMaiorQueZero(valor)) {
            return false;
        }
        if (!membro.contribuicao(valor)) {
            return false;
        }

        movimentacoes[contador] = new Movimentacao("Contribuição", valor, "registro automático");
        contador++;
        return true;
    }


    public boolean emprestimo(double valor) {
        if (!capacidadeSuficiente()) {
            return false;
        }
        if (!ePossivelEmprestar(valor)) {
            return false;
        }
        if (!valorMaiorQueZero(valor)) {
            return false;
        }
        if (!membro.emprestimo(valor)) {
            return false;
        }

        movimentacoes[contador] = new Movimentacao("Empréstimo", valor, "registro automático");
        contador++;
        return true;
    }

    public void listarHistorico() {
        if (contador == 0) {
            System.out.println("Nenhuma movimentação registrada");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(movimentacoes[i]);
            }
        }
    }


}
