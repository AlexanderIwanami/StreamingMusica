import java.util.ArrayList;

public abstract class Usuario {

    protected String nome;
    protected ArrayList<Playlist> playlists = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public abstract void criarPlaylist(String nome);
    public abstract void reproduzirMusica(Musica m);
}