abstract class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome, int idade, double saldo, double salario) {
        super(nome, idade, saldo);
        this.salario = salario;
    }

    public double GetSalaraio() {
        return salario;
    }

    abstract void PagarSalario();
}
