import java.io.Serializable;
import java.util.ArrayList;

public class Comanda implements Serializable {
    private static int contador = 0;
    private int idComanda;
    ArrayList<Produto> produtos = new ArrayList<Produto>();

    public Comanda() {
        this.idComanda = ++contador;
    }

    public void AddProduto(Produto produto) {
        produtos.add(produto);
    }

    public void Imprimir() {
        System.out.println("\nId Comanda: " + idComanda + "\nProdutos:");
        for (Produto produto : produtos) {
            produto.Imprimir();
        }
    }

    public double GetValorTotal() {
        double ValorTotal = 0;

        for (Produto produto : produtos) {
            ValorTotal += produto.GetValor();
        }

        return ValorTotal;
    }
}