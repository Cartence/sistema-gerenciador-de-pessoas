
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gerenciador {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public void listarPessoas() {
        System.out.printf("%-12s %5s %7s%n", "NOME", "IDADE", "ALTURA");
        System.out.println("-----------------------------");
        for (Pessoa p : pessoas) {
            System.out.printf("%-12s %5d %7.2f%n", p.getNome(), p.getIdade(), p.getAltura());
        }
    }

    public Pessoa buscarPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean removerPorNome(String nome) {
        Pessoa p = buscarPorNome(nome);
        if (p != null) {
            pessoas.remove(p);
            return true;
        }
        return false;
    }

    public boolean editarPessoa(String nome, String novoNome, int novaIdade, double novaAltura) {
        Pessoa p = buscarPorNome(nome);
        if (p != null) {
            p.setNome(novoNome);
            p.setIdade(novaIdade);
            p.setAltura(novaAltura);
            return true;
        }
        return false;
    }

    public void exportarParaArquivo(String caminho) {
        try (FileWriter fw = new FileWriter(caminho)) {
            for (Pessoa p : pessoas) {
                fw.write(p.getNome() + ";" + p.getIdade() + ";" + p.getAltura() + "\n");
            }
            System.out.println("Arquivo exportado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao exportar arquivo: " + e.getMessage());
        }
    }
}