
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Editar pessoa");
            System.out.println("5 - Remover pessoa");
            System.out.println("6 - Exportar para arquivo");
            System.out.println("7 - Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Altura: ");
                    double altura = scanner.nextDouble();
                    scanner.nextLine();

                    gerenciador.adicionarPessoa(new Pessoa(nome, idade, altura));
                    break;

                case 2:
                    gerenciador.listarPessoas();
                    break;

                case 3:
                    System.out.print("Nome para buscar: ");
                    String busca = scanner.nextLine();
                    Pessoa encontrada = gerenciador.buscarPorNome(busca);
                    if (encontrada != null) {
                        System.out.printf("Encontrado: %s - %d anos - %.2f m%n",
                                encontrada.getNome(), encontrada.getIdade(), encontrada.getAltura());
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Nome da pessoa a editar: ");
                    String antigo = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova idade: ");
                    int novaIdade = scanner.nextInt();
                    System.out.print("Nova altura: ");
                    double novaAltura = scanner.nextDouble();
                    scanner.nextLine();

                    boolean editado = gerenciador.editarPessoa(antigo, novoNome, novaIdade, novaAltura);
                    if (editado) {
                        System.out.println("Pessoa atualizada com sucesso!");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Nome da pessoa a remover: ");
                    String remover = scanner.nextLine();
                    boolean removida = gerenciador.removerPorNome(remover);
                    if (removida) {
                        System.out.println("Removida com sucesso.");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Caminho do arquivo (ex: dados.txt): ");
                    String caminho = scanner.nextLine();
                    gerenciador.exportarParaArquivo(caminho);
                    break;

                case 7:
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
        System.out.println("Encerrado. Valeu!");
    }
}