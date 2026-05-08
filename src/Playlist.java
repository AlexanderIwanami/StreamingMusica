import java.util.ArrayList;

public class Playlist {

    protected String nome;
    protected ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public void adicionarMusica(Musica m) {
        musicas.add(m);
    }

    public void listarMusicas() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {
            System.out.println(i + " - " + musicas.get(i));
        }
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public String getNome() {
        return nome;
    }
}