package Game;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Sprite {

    ImageIcon cenas[];
    int x, y, largura_j = 70, largura_z = 65, altura_j = 93, altura_z = 102, cena = 0, velocidade = 0;
    int controlaVelocidade = 0;
    List<Bala> Balas;

    public Sprite(int numeroDeCenas, int x, int y) {
        cenas = new ImageIcon[numeroDeCenas];
        this.x = x;
        this.y = y;
        Balas = new ArrayList<Bala>();

    }

    public void animar_direita(int velocidade) {
        controlaVelocidade += 1;
        if (controlaVelocidade > velocidade) {
            if (cena > 9) {
                cena = 0;
            } else {
                cena += 1;
            }
            controlaVelocidade = 0;
        }
    }

    public void animar_esquerda(int velocidade) {
        controlaVelocidade += 1;
        if (controlaVelocidade > velocidade) {
            if (cena == 17) {
                cena = 9;
            } else {
                cena += 1;
            }
            controlaVelocidade = 0;
        }
    }

    public void animar() {
        cena = cena + 1;
        if (cena == cenas.length) {
            cena = 0;
        }
    }

    public void animar_m() {
        cena = cena + 1;
        if (cena == cenas.length) {
            cena = cenas.length - 1;
        }
    }

    public List<Bala> getBalas() {
        return Balas;
    }

    public void dispara() {

        this.Balas.add(new Bala(x + largura_j - 10, y + altura_j / 2 - 10));
    }

}
