package Game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Bala {

    private Image imagem;
    public int x, y;
    public int largura, altura;
    private boolean isVisivel;
    private static final int VELOCIDADE = 15;

    public Bala(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon referencia = new ImageIcon("src/Imagens/Movimento/bala.png");
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        isVisivel = true;
    }

    public void mexer() {
        this.x += VELOCIDADE;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y - 35;
    }

    public Rectangle getLimiteMissil() {
        return new Rectangle(x, y, largura, altura);
    }

}
