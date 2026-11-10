package entities;

import java.util.ArrayList;
import java.util.List;

public class Caixinha {

    private Membro membro;
    private List<Movimentacao> movimentacoes;


    public Caixinha(Membro membro) {
        this.membro = membro;
        this.movimentacoes = new ArrayList<>();
    }

    public double getSaldo() {
        return membro.getSaldo();
    }

    public boolean valorMaiorQueZero(double valor) {
        return valor > 0;
    }

    public boolean ePossivelEmprestar(double valor) {
        return valor <= membro.getSaldo();
    }

    public boolean contribuicao(double valor) {
        if (!valorMaiorQueZero(valor)) {
            return false;
        }
        if (!membro.contribuicao(valor)) {
            return false;
        }

        movimentacoes.add(new Movimentacao("Contribuição", valor, "registro automático"));
        return true;
    }


    public boolean emprestimo(double valor) {
        if (!ePossivelEmprestar(valor)) {
            return false;
        }
        if (!valorMaiorQueZero(valor)) {
            return false;
        }
        if (!membro.emprestimo(valor)) {
            return false;
        }

        movimentacoes.add(new Movimentacao("Empréstimo", valor, "registro automático"));
        return true;
    }

    public void listarHistorico() {
        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma movimentação registrada");
        } else {
            for (Movimentacao m : movimentacoes) {
                System.out.println(m);
            }
        }
    }


}
