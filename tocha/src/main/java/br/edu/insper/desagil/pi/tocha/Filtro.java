package br.edu.insper.desagil.pi.tocha;

public class Filtro {
    public static final double MEDIA = 1.0/9.0;
    private final double[][] KERNEL = new double[3][3];
    private String tipo;

    public Filtro(String tipo) {
        this.tipo = tipo;
    }

    public Imagem processa(Imagem imagem) {
        // inicializa entrada
        int[][] entrada = imagem.getPixels();

        // inicializa saída
        int[][] saida = initSaida(imagem);

        // inicializa kernel
        initKernel();

        // calcula saída
        calculaSaida(entrada, saida);

        // retorna imagem com pixels filtrados
        return new Imagem(saida);
    }

    private void calculaSaida(int[][] entrada, int[][] saida) {
        int altura = entrada.length;
        int largura = entrada[0].length;

        for (int y = 1; y < altura - 1; y++) {
            for (int x = 1; x < largura - 1; x++) {

                double s = 0;

                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        s += entrada[y + dy][x + dx] * KERNEL[dy + 1][dx + 1];
                    }
                }

                saida[y - 1][x - 1] = (int) s;
            }
        }
    }

    private void initKernel() {
        switch (tipo) {
            case "media" -> {

                KERNEL[0][0] = MEDIA;
                KERNEL[0][1] = MEDIA;
                KERNEL[0][2] = MEDIA;
                KERNEL[1][0] = MEDIA;
                KERNEL[1][1] = MEDIA;
                KERNEL[1][2] = MEDIA;
                KERNEL[2][0] = MEDIA;
                KERNEL[2][1] = MEDIA;
                KERNEL[2][2] = MEDIA;
            }
            case "sobel_x" -> {

                KERNEL[0][0] = -1;
                KERNEL[0][1] = 0;
                KERNEL[0][2] = 1;
                KERNEL[1][0] = -2;
                KERNEL[1][1] = 0;
                KERNEL[1][2] = 2;
                KERNEL[2][0] = -1;
                KERNEL[2][1] = 0;
                KERNEL[2][2] = 1;
            }
            case "sobel_y" -> {

                KERNEL[0][0] = -1;
                KERNEL[0][1] = -2;
                KERNEL[0][2] = -1;
                KERNEL[1][0] = 0;
                KERNEL[1][1] = 0;
                KERNEL[1][2] = 0;
                KERNEL[2][0] = 1;
                KERNEL[2][1] = 2;
                KERNEL[2][2] = 1;
            }
            case "laplace" -> {

                KERNEL[0][0] = 0;
                KERNEL[0][1] = -1;
                KERNEL[0][2] = 0;
                KERNEL[1][0] = -1;
                KERNEL[1][1] = 4;
                KERNEL[1][2] = -1;
                KERNEL[2][0] = 0;
                KERNEL[2][1] = -1;
                KERNEL[2][2] = 0;
            }
            default -> throw new IllegalStateException("tipo inválido");
        }
    }

    private int[][] initSaida(Imagem imagem) {
        int[][] entrada = imagem.getPixels();

        int altura = entrada.length;
        if (altura < 3) {
            throw new IllegalStateException("altura pequena");
        }

        int largura = entrada[0].length;
        if (largura < 3) {
            throw new IllegalStateException("largura pequena");
        }

        return new int[altura - 2][largura - 2];
    }

}
