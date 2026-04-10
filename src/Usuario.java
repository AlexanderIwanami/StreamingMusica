import java.util.ArrayList;

public class Usuario {

    private String nome;
    private ArrayList<Playlist> playlists;

    // Construtor
    public Usuario(String nome) {
        setNome(nome);
        this.playlists = new ArrayList<>();
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido!");
        } else {
            this.nome = nome;
        }
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    // Métodos
    public void criarPlaylist(String nome) {
        Playlist nova = new Playlist(nome);
        playlists.add(nova);
        System.out.println("Playlist criada com sucesso!");
    }

    public void listarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist criada.");
            return;
        }

        for (int i = 0; i < playlists.size(); i++) {
            System.out.println(i + " - " + playlists.get(i).getNome());
        }
    }

    public Playlist getPlaylist(int index) {
        if (index >= 0 && index < playlists.size()) {
            return playlists.get(index);
        }
        return null;
    }
}