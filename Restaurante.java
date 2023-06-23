import java.io.*;
import java.util.ArrayList;

public class Restaurante implements Serializable {
    String nome;
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Funcionario> funcioarios = new ArrayList<Funcionario>();

    public Restaurante(String nome) {
        this.nome = nome;
    }

    public void AppendCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void AppendFuncionario(Funcionario funcionario) {
        funcioarios.add(funcionario);
    }

    public void PagarFuncionarios() {
        for (Funcionario funcionario : funcioarios) {
            funcionario.PagarSalario();
        }
    }

    public void PagarComandas() {
        for (Cliente cliente : clientes) {
            cliente.PagarComanda();
        } 
    }

    public void Imprimir() {
        System.out.println("\n-=-=-=- Restaurante " + this.nome + ": -=-=-=-");

        System.out.println("\n-=-=-=- Clientes: -=-=-=-");
        for (Cliente cliente : clientes) {
            cliente.Imprimir();
        }

        System.out.println("\n-=-=-=- Funcionarios: -=-=-=-");
        for (Funcionario funcionario : funcioarios) {
            funcionario.Imprimir();
        }
    }

    public void Salvar() throws IOException {
        FileOutputStream arquivo = new FileOutputStream(this.nome + ".Ser");
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    public static Restaurante Abrir(String nome) throws IOException, ClassNotFoundException {
        Restaurante restaurante = null;

        FileInputStream arquivo = new FileInputStream(nome + ".Ser");
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        restaurante = (Restaurante) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return restaurante;
    }
}
