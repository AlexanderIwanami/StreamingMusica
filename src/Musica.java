public class Musica {

    private String titulo;
    private String artista;
    private int duracao;
    private String genero;

    // Construtor
    public Musica(String titulo, String artista, int duracao, String genero) {
        setTitulo(titulo);
        setArtista(artista);
        setDuracao(duracao);
        setGenero(genero);
    }

    // Getters e Setters com validação
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Título inválido!");
        } else {
            this.titulo = titulo;
        }
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            System.out.println("Artista inválido!");
        } else {
            this.artista = artista;
        }
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        if (duracao > 0) {
            this.duracao = duracao;
        } else {
            System.out.println("Duração deve ser maior que zero!");
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            System.out.println("Gênero inválido!");
        } else {
            this.genero = genero;
        }
    }

    public void exibir() {
        System.out.println(titulo + " - " + artista + " (" + duracao + "s) [" + genero + "]");
    }
}