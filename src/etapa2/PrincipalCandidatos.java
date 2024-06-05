package etapa2;

import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    private static final String[] nomes = {"João", "Eduardo", "Gabriela", "Paula", "Maria", "Pedro", "Ana", "José", "Carla", "Jeronimo", "Fernanda", "Ismael"};
    private static final String[] partidos = {"PSDB", "PSL", "PT", "PP", "PSB", "PDT", "PCB", "PRTB", "PSTU"};

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int inf = 0;
        int sup = candidatos.length - 1;

        while (inf <= sup) {
            int med = (inf + sup) / 2;
            int comparacao = candidatos[med].getNome().compareToIgnoreCase(nome);

            if (comparacao == 0) {
                return med; // Encontrou o candidato com o nome desejado
            } else if (comparacao < 0) {
                inf = med + 1; // Procura na metade superior
            } else {
                sup = med - 1; // Procura na metade inferior
            }
        }

        return -1; // Candidato não encontrado
    }

    // Método de ordenação por inserção direta
    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            int j = i;
            Candidato atual = candidatos[i];
            while (j > 0 && candidatos[j - 1].getNome().compareTo(atual.getNome()) > 0) {
                candidatos[j] = candidatos[j - 1];
                j--;
            }
            candidatos[j] = atual;
        }
    }

    // Método de ordenação por inserção direta
    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            int j = i;
            Candidato atual = candidatos[i];
            while (j > 0 && candidatos[j - 1].getIntencoesVotos() < atual.getIntencoesVotos()) {
                candidatos[j] = candidatos[j - 1];
                j--;
            }
            candidatos[j] = atual;
        }
    }

    // Método de ordenação por seleção direta
    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        int min = 0;
        for (int i = 0; i < candidatos.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < candidatos.length; j++) {
                if (candidatos[j].getPartido().compareTo(candidatos[min].getPartido()) < 0) {
                    min = j;
                }
            }
            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[min];
            candidatos[min] = temp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner ler = new Scanner(System.in);
        int tamanho = random.nextInt(100) + 1;
        Candidato[] candidatos = new Candidato[tamanho];

        for (int i = 0; i < candidatos.length; i++) {
            for (int j = 0; i < tamanho; i++) {
                String nome = nomes[random.nextInt(nomes.length)];
                String partido = partidos[random.nextInt(partidos.length)];
                int votos = random.nextInt(5);
                candidatos[i] = new Candidato(nome, partido, votos);
            }
        }

        ordenaCandidatosPorPartido(candidatos);
        ordenaCandidatosPorVotos(candidatos);
        ordenaCandidatosPorNome(candidatos);
        
        System.out.println("Quantidade candidatos: " + tamanho);

        for (Candidato c : candidatos) {
            System.out.println(c);
        }
   
        System.out.print("\nPara pesquisar, digite o nome do candidato: ");
        String nome = ler.nextLine();
        int respostaPesquisa = pesquisaBinariaCandidatos(candidatos, nome);
        
        if (respostaPesquisa < 0)
            System.out.println("\nCandidato não encontrado.");
        else { 
            System.out.println("\nInformações do candidato:");
            System.out.println("Posição do candidato no array: " + respostaPesquisa);
            System.out.println("Nome: " + candidatos[respostaPesquisa].getNome());
            System.out.println("Partido: " + candidatos[respostaPesquisa].getPartido());
            System.out.println("Intenções de votos: " + candidatos[respostaPesquisa].getIntencoesVotos());
        }
    }
}
