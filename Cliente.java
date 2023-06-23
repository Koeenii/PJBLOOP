public class Cliente extends Pessoa {
    Comanda comanda;

    public Cliente(String nome, int idade, double saldo) {
        super(nome, idade, saldo);
    }

    public void AssignComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public void Imprimir() {
        System.out.println("\nCliente:");
        super.Imprimir();

        if (comanda != null) {
            comanda.Imprimir();
        }
    }

    public void PagarComanda() {
        if (comanda != null) {
            double ValorTotal = comanda.GetValorTotal();

            if (this.GetSaldo() - ValorTotal >= 0) {
                this.SubSaldo(ValorTotal);
                System.out.println("\nO Cliente " + this.GetNome() + " pagou sua comanda no valor de: $" + ValorTotal + "\nSaldo Atual: $" + this.GetSaldo());
                // comanda = null; -- REMOVIDO PARA FINS DE NÃO CRIAR NOVAS COMANDAS TODA VEZ
            } else {
                System.out.println("\nO Cliente " + this.GetNome() + " não possui saldo o bastante para pagar sua comanda no valor de: $" + ValorTotal + "\nSaldo Atual: $" + this.GetSaldo());
            }
        }
    }
}
