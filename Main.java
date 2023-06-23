import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lêr config file
        String nome = GetNome(); // Nome Padrão

        // Criar Restaurante
        Restaurante restaurante;

        File arquivo = new File(nome + ".Ser");
        if(arquivo.isFile()) { 
            System.out.println("Arquivo do Restaurante Encotrado, Tentando Carregar...");

            try {
                restaurante = Restaurante.Abrir(nome);

            } catch (IOException e) {
                System.out.println("Exceção de IO ao tentar carregar o restaurante, Tentando Criar Novo Restaurante...");

                restaurante = new Restaurante(nome);
                PreencherRestaurante(restaurante);

                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                System.out.println("Exceção de Classe desconhecida ao tentar carregar o restaurante, Tentando Criar Novo Restaurante...");

                restaurante = new Restaurante(nome);
                PreencherRestaurante(restaurante);

                e.printStackTrace();
            }
        } else {
            System.out.println("Arquivo do Restaurante Não Encotrado, Tentando Criar...");
            restaurante = new Restaurante(nome);
            PreencherRestaurante(restaurante);
        }

        // Imprimir Restaurante
        restaurante.Imprimir();

        // Realizar Ações
        restaurante.PagarComandas();
        restaurante.PagarFuncionarios();

        // Salvar o Restaurante
        try {
            restaurante.Salvar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lê o arquivo config.txt para procurar a configuração do nome
    static String GetNome() {
        try {
            File arquivoConfig = new File("config.txt");
            Scanner leitor = new Scanner(arquivoConfig);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split("=", 2);

                if (dados[0].equals("nome")) {
                    leitor.close();
                    return dados[1];
                }
            }

            leitor.close();

        } catch (FileNotFoundException e) {
            System.out.println("Exceção de Arquivo não encontrado durante carregamento de configurações");
            e.printStackTrace();
        }

        return "Olivia"; // Nome Padrão
    }

    // Função Utilizada para preencher o restaurante com dados padrões
    static void PreencherRestaurante(Restaurante restaurante) {
        // Criar Funcionarios
        Gerente gerente = new Gerente("Rojerio", 51, 3200, 3000);
        restaurante.AppendFuncionario(gerente);

        Garcom garcom1 = new Garcom("Paulo", 21, 100, 1500, 0.15);
        restaurante.AppendFuncionario(garcom1);

        Garcom garcom2 = new Garcom("Renato", 35, 350, 2000, 0.3);
        restaurante.AppendFuncionario(garcom2);

        // Criar Clientes
        Cliente cliente1 = new Cliente("Lukas", 17, 120);
        restaurante.AppendCliente(cliente1);

        Cliente cliente2 = new Cliente("Felipe", 19, 1000);
        restaurante.AppendCliente(cliente2);

        Cliente cliente3 = new Cliente("Gustavo", 48, 580);
        restaurante.AppendCliente(cliente3);

        // Criar Produtos
        Bebida bebida1 = new Bebida("Coca-cola", 9.49, 2.5f);
        Bebida bebida2 = new Bebida("Café", 4.9, 0.250f);

        Alimento alimento1 = new Alimento("Bife à Cavalo", 9.9, 0.45f);
        Alimento alimento2 = new Alimento("Spaghetti", 14.49, 0.5f);
        Alimento alimento3 = new Alimento("Hamburger", 14.49, 0.3f);

        // Criar Comandas
        Comanda comanda1 = new Comanda();
        comanda1.AddProduto(bebida1);
        comanda1.AddProduto(alimento1);
        cliente1.AssignComanda(comanda1);
        garcom1.AppendComanda(comanda1);

        Comanda comanda2 = new Comanda();
        comanda2.AddProduto(bebida1);
        comanda2.AddProduto(bebida2);
        comanda2.AddProduto(alimento2);
        comanda2.AddProduto(alimento3);
        cliente2.AssignComanda(comanda2);
        garcom2.AppendComanda(comanda2);

        Comanda comanda3 = new Comanda();
        comanda3.AddProduto(bebida2);
        comanda3.AddProduto(alimento1);
        comanda3.AddProduto(alimento3);
        cliente3.AssignComanda(comanda3);
        garcom1.AppendComanda(comanda3);
    }
}