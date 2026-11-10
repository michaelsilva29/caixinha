package application;

import entities.Caixinha;
import entities.Membro;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o nome do membro da caixinha?");
        String nome = sc.nextLine();
        Membro membro = new Membro(nome);
        Caixinha caixinha = new Caixinha(membro);

        int opcao = 0;

        do {

            System.out.println();
            System.out.println("==== BEM VINDO A CAIXINHA DA FAMILIA ====");
            System.out.println("1. Contribuição");
            System.out.println("2. Empréstimo");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Listar histórico");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            System.out.println();

            double valor;

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor da contribuição: ");
                    valor = sc.nextDouble();

                    if (!caixinha.valorMaiorQueZero(valor)) {
                        System.out.println("Erro: O valor de contribuição tem que ser maior que Zero");
                        break;
                    }
                    if (caixinha.contribuicao(valor)) {
                        System.out.println("Contribuição realizada com sucesso");
                        System.out.printf("Saldo atualizado %.2f%n", caixinha.getSaldo());
                    } else {
                        System.out.println("Erro: não foi possível registrar a contribuição");
                    }

                    break;

                case 2:
                    System.out.print("Informe o valor que deseja emprestar: ");
                    valor = sc.nextDouble();

                    if (!caixinha.valorMaiorQueZero(valor)) {
                        System.out.println("Erro: O valor de empréstimo tem que ser maior que Zero");
                        break;
                    }

                    if (!caixinha.ePossivelEmprestar(valor)) {
                        System.out.println("Erro: Valor insuficiente para empréstimo");
                        break;
                    }

                    if(caixinha.emprestimo(valor)){
                        System.out.println("Empréstimo realizado com sucesso");
                        System.out.printf("Saldo atualizado %.2f%n", caixinha.getSaldo());
                    } else {
                        System.out.println("Erro: não foi possível registrar o empréstimo");
                    }

                    break;

                case 3:
                    System.out.printf("Seu saldo atual é: %.2f%n", caixinha.getSaldo());
                    break;
                case 4:
                    System.out.println("==== HISTÓRICO DE MOVIMENTAÇÕES ====");
                    caixinha.listarHistorico();
                    break;
                case 5:
                    System.out.println("Saindo do Sistema....");
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite uma opção válida");
                    break;
            }


        } while (opcao != 5);

        System.out.println("==== OBRIGADO POR ACESSAR A CAIXINHA DA FAMÍLIA ====");

        sc.close();

    }
}
