public class Gerente extends Funcionario {
    public Gerente(String nome, int idade, double saldo, double salario) {
        super(nome, idade, saldo, salario);
    }

    public void PagarSalario() {
        double ValorTotal = GetSalaraio();
        this.AddSaldo(ValorTotal);
        System.out.println("\nO Funcionario " + this.GetNome() + " teve seu salarario pago no valor de: $" + ValorTotal + "\nSaldo Atual: $" + this.GetSaldo());
    }

    public void Imprimir() {
        System.out.println("\nGerente:");
        super.Imprimir();
    }
}
