import java.io.Serializable;

abstract class Pessoa implements Serializable  {
    private static int contador = 0;
    private int idPessoa;
    private String nome;
    private int idade;
    private double saldo;

    public Pessoa (String nome, int idade, double saldo) {
        this.nome = nome;
        this.idade = idade;
        this.saldo = saldo;
        this.idPessoa = ++contador;
    }

    public void Imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Id Pessoa: " + idPessoa);
        System.out.println("Idade: " + idade);
        System.out.println("Saldo: " + saldo);
    }

    public void AddSaldo(double valor) {
        if (saldo + valor >= 0) {
            saldo += valor;
        }
    }

    public void SubSaldo(double valor) {
        if (saldo - valor >= 0) {
            saldo -= valor;
        }
    }

    public double GetSaldo() {
        return this.saldo;
    }

    public String GetNome() {
        return this.nome;
    }
}
