public class Bebida extends Produto {
    private float Litros;

    public Bebida(String nome, double preco, float Litros) {
        super(nome, preco);
        this.Litros = Litros;
    }

    public void Imprimir() {
        super.Imprimir();
        System.out.println("Litros: " + Litros + "L");
    }
}
