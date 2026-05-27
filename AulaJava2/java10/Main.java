import java.util.ArrayList;
import java.util.Scanner;

interface PagamentoGame {
    double processarPagamento(double valor);

}

class PixGame implements PagamentoGame {
    @Override
    public double processarPagamento(double valor) {
        return valor;
    }
}

class CartaoGame implements PagamentoGame {
    @Override
    public double processarPagamento(double valor) {
        return valor + 10;
    }
}

class PaypalGame implements PagamentoGame {
    @Override
    public double processarPagamento(double valor) {
        return valor + 5;
    }
}

class Compra {
    private String nomeJogador;
    private double valorCompra;
    private PagamentoGame pagamento; // vindo da classe pai referenciando

    public Compra(String nomeJogador, double valorCompra, PagamentoGame pagamento) {
        this.nomeJogador = nomeJogador;
        this.valorCompra = valorCompra;
        this.pagamento = pagamento;

    }

    public void mostrarResumo() {
        System.out.println("\n===================Resumo====================");
        System.out.println("Jogador: " + nomeJogador);
        System.out.println("Valor final: R$" + pagamento.processarPagamento(valorCompra));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Compra> compras = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n 1 - Pix");
            System.out.println("\n 2 - Cartão");
            System.out.println("\n 3 - Paypal");
            System.out.println("\n 0 - Finalizar");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) {
                continuar = false;
                break;
            }

            System.out.println("Nome do Jogador: ");
            String nome = sc.nextLine();

            System.out.println("Valor da Compra: ");
            double valor = sc.nextDouble();

            PagamentoGame pagamento;

            switch (opcao) {
                case 1:
                    pagamento = new PixGame();
                    break;
                case 2:
                    pagamento = new CartaoGame();
                    break;
                case 3:
                    pagamento = new PaypalGame();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }
            Compra compra = new Compra(nome, valor, pagamento);
            compras.add(compra);

            System.out.println("Compra registrada com sucesso!");
        }

        System.out.println("\n=========== TODAS AS COMPRAS ===========");

        for (Compra c : compras) {
            c.mostrarResumo();
        }

        sc.close();
    }

}
