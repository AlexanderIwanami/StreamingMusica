import java.util.List;

public class PlaylistAutomatica extends Playlist {

    public PlaylistAutomatica(String nome) {
        super(nome);
    }

    public void gerarPlaylistAutomatica(List<Musica> base) {
        for (Musica m : base) {
            if (m.getGenero().equalsIgnoreCase("Pop")) {
                adicionarMusica(m);
            }
        }
    }
}