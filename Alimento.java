public class Alimento extends Produto {
    private float Peso;

    public Alimento(String nome, double preco, float Peso) {
        super(nome, preco);
        this.Peso = Peso;
    }

    public void Imprimir() {
        super.Imprimir();
        System.out.println("Peso: " + Peso + "Kg");
    }
}
