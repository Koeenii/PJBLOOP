import java.util.ArrayList;

public class Garcom extends Funcionario {
    ArrayList<Comanda> comandas = new ArrayList<Comanda>();
    private double comissao;

    public Garcom(String nome, int idade, double saldo, double salario, double comissao) {
        super(nome, idade, saldo, salario);
        this.comissao = comissao;
    }

    public void AppendComanda(Comanda comanda) {
        comandas.add(comanda);
    }

    public void PagarSalario() {
        double ValorTotal = GetSalaraio();

        for (Comanda comanda : comandas) {
            ValorTotal += comanda.GetValorTotal() * comissao;
            // comandas.remove(comanda); -- REMOVIDO PARA FINS DE NÃO CRIAR NOVAS COMANDAS TODA VEZ
        }

        this.AddSaldo(ValorTotal);
        System.out.println("\nO Funcionario " + this.GetNome() + " teve seu salario pago no valor de: $" + ValorTotal + "\nSaldo Atual: $" + this.GetSaldo());
    }

    public void Imprimir() {
        System.out.println("\nGarçom:");
        super.Imprimir();
        System.out.println("\nComandas " + this.GetNome() + ":");
        for (Comanda comanda : comandas) {
            comanda.Imprimir();
        }
    }
}
