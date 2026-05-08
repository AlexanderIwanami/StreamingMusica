import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Usuario usuarioLogado;

    public static void main(String[] args) {

        seedUsuarios();
        login();

        int opcao;

        do {
            menu();
            opcao = lerInt();

            switch (opcao) {
                case 1 -> criarPlaylist();
                case 2 -> adicionarMusica();
                case 3 -> listarPlaylists();
                case 4 -> reproduzirMusica();
                case 5 -> estatisticas();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // 🔹 evita erro de número inválido
    public static int lerInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void seedUsuarios() {
        usuarios.add(new UsuarioFree("Ana"));
        usuarios.add(new UsuarioPremium("Carlos"));
    }

    public static void login() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                usuarioLogado = u;
                return;
            }
        }

        System.out.println("Novo usuário!");
        System.out.println("1 - Free | 2 - Premium");
        int tipo = lerInt();

        if (tipo == 2) {
            usuarioLogado = new UsuarioPremium(nome);
        } else {
            usuarioLogado = new UsuarioFree(nome);
        }

        usuarios.add(usuarioLogado);
    }

    public static void menu() {
        System.out.println("\n1. Criar playlist");
        System.out.println("2. Adicionar música");
        System.out.println("3. Listar playlists");
        System.out.println("4. Reproduzir música");
        System.out.println("5. Estatísticas");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    public static void criarPlaylist() {
        System.out.print("Nome da playlist: ");
        String nome = scanner.nextLine();
        usuarioLogado.criarPlaylist(nome);
    }

    public static void listarPlaylists() {
        if (usuarioLogado.getPlaylists().isEmpty()) {
            System.out.println("Nenhuma playlist.");
            return;
        }

        for (int i = 0; i < usuarioLogado.getPlaylists().size(); i++) {
            System.out.println(i + " - " + usuarioLogado.getPlaylists().get(i).getNome());
        }
    }

    public static void adicionarMusica() {

        if (usuarioLogado.getPlaylists().isEmpty()) {
            System.out.println("Crie uma playlist primeiro!");
            return;
        }

        listarPlaylists();

        System.out.print("Escolha a playlist: ");
        int index = lerInt();

        if (index < 0 || index >= usuarioLogado.getPlaylists().size()) {
            System.out.println("Playlist inválida!");
            return;
        }

        Playlist p = usuarioLogado.getPlaylists().get(index);

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        System.out.print("Duração: ");
        int duracao = lerInt();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        p.adicionarMusica(new Musica(titulo, artista, duracao, genero));

        System.out.println("Música adicionada!");
    }

    public static void reproduzirMusica() {

        if (usuarioLogado.getPlaylists().isEmpty()) {
            System.out.println("Nenhuma playlist!");
            return;
        }

        listarPlaylists();

        System.out.print("Escolha a playlist: ");
        int p = lerInt();

        if (p < 0 || p >= usuarioLogado.getPlaylists().size()) {
            System.out.println("Playlist inválida!");
            return;
        }

        Playlist playlist = usuarioLogado.getPlaylists().get(p);

        if (playlist.getMusicas().isEmpty()) {
            System.out.println("Playlist sem músicas!");
            return;
        }

        playlist.listarMusicas();

        System.out.print("Escolha a música: ");
        int m = lerInt();

        if (m < 0 || m >= playlist.getMusicas().size()) {
            System.out.println("Música inválida!");
            return;
        }

        usuarioLogado.reproduzirMusica(playlist.getMusicas().get(m));
    }

    public static void estatisticas() {

        int free = 0;
        int premium = 0;

        for (Usuario u : usuarios) {
            if (u instanceof UsuarioFree) free++;
            if (u instanceof UsuarioPremium) premium++;
        }

        System.out.println("Free: " + free);
        System.out.println("Premium: " + premium);
    }
}