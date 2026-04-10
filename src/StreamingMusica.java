import java.util.Scanner;

public class StreamingMusica {

    static Scanner scanner = new Scanner(System.in);
    static Usuario usuario = new Usuario("Usuário");

    public static void main(String[] args) {

        int opcao;

        do {
            menu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("\n🎵 Até logo! 🎵");
        scanner.close();
    }

    public static void menu() {
        System.out.println("\n=== SISTEMA DE STREAMING ===");
        System.out.println("1. Criar playlist");
        System.out.println("2. Adicionar música");
        System.out.println("3. Listar músicas");
        System.out.println("4. Buscar música");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    public static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                criarPlaylist();
                break;
            case 2:
                adicionarMusica();
                break;
            case 3:
                listarMusicas();
                break;
            case 4:
                buscarMusica();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void criarPlaylist() {
        System.out.print("Nome da playlist: ");
        String nome = scanner.nextLine();
        usuario.criarPlaylist(nome);
    }

    public static void adicionarMusica() {
        usuario.listarPlaylists();

        System.out.print("Escolha a playlist: ");
        int index = lerOpcao();

        Playlist p = usuario.getPlaylist(index);

        if (p == null) {
            System.out.println("Playlist inválida!");
            return;
        }

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        System.out.print("Duração (segundos): ");
        int duracao = lerOpcao();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        Musica m = new Musica(titulo, artista, duracao, genero);
        p.adicionarMusica(m);

        System.out.println("Música adicionada com sucesso!");
    }

    public static void listarMusicas() {
        usuario.listarPlaylists();

        System.out.print("Escolha a playlist: ");
        int index = lerOpcao();

        Playlist p = usuario.getPlaylist(index);

        if (p != null) {
            p.listarMusicas();
        } else {
            System.out.println("Playlist inválida!");
        }
    }

    public static void buscarMusica() {
        usuario.listarPlaylists();

        System.out.print("Escolha a playlist: ");
        int index = lerOpcao();

        Playlist p = usuario.getPlaylist(index);

        if (p == null) {
            System.out.println("Playlist inválida!");
            return;
        }

        System.out.print("Digite o título: ");
        String busca = scanner.nextLine();

        p.buscarPorTitulo(busca);
    }
}