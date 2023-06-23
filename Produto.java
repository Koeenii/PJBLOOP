import java.io.Serializable;

abstract class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void Imprimir() {
        System.out.println("\nProduto:");
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
    }

    public double GetValor() {
        return this.preco;
    }
}
