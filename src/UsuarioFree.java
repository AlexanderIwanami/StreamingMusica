public class UsuarioFree extends Usuario {

    public UsuarioFree(String nome) {
        super(nome);
    }

    @Override
    public void criarPlaylist(String nome) {
        if (playlists.size() >= 3) {
            System.out.println("Limite de playlists atingido!");
            return;
        }
        playlists.add(new Playlist(nome));
        System.out.println("Playlist criada!");
    }

    @Override
    public void reproduzirMusica(Musica m) {
        System.out.println("🎵 Free (com anúncios): " + m);
    }
}