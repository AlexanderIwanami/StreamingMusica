public class UsuarioPremium extends Usuario {

    public UsuarioPremium(String nome) {
        super(nome);
    }

    @Override
    public void criarPlaylist(String nome) {
        playlists.add(new Playlist(nome));
        System.out.println("Playlist criada!");
    }

    @Override
    public void reproduzirMusica(Musica m) {
        System.out.println("🎵 Premium (alta qualidade): " + m);
    }
}