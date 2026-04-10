import java.util.ArrayList;

public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas;

    // Construtor
    public Playlist(String nome) {
        setNome(nome);
        this.musicas = new ArrayList<>();
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome da playlist inválido!");
        } else {
            this.nome = nome;
        }
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    // Métodos
    public void adicionarMusica(Musica musica) {
        if (musica != null) {
            musicas.add(musica);
        }
    }

    public void listarMusicas() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia!");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {
            System.out.print(i + " - ");
            musicas.get(i).exibir();
        }
    }

    public void buscarPorTitulo(String titulo) {
        boolean encontrou = false;

        for (Musica m : musicas) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                m.exibir();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Música não encontrada!");
        }
    }
}
