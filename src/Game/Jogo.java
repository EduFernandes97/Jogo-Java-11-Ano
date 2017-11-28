package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Jogo extends JFrame implements KeyListener {

    BufferedImage backBuffer;
    Random gerador = new Random();
    int zx = gerador.nextInt(800) + 1250;
    int z1x = gerador.nextInt(800) + 1250;
    int z2x = gerador.nextInt(800) + 1250;
    int z3x = gerador.nextInt(800) + 1250;
    int z4x = gerador.nextInt(800) + 1250;
    int z5x = gerador.nextInt(800) + 1250;

    int v1 = 0, v2 = 0, v3 = 0, v4 = 0, v5 = 0, v6 = 0, v7 = 0,
            v8 = 0, v9 = 0, v10 = 0, v11 = 0, v12 = 0, v13 = 0,
            v14 = 0, v15 = 0, v16 = 0, v17 = 0, v18 = 0, v19 = 0,
            v20 = 0, v21 = 0, v22 = 0, v23 = 0, v24 = 0;

    boolean sz = true, sz1 = true, sz2 = true, sz3 = true, sz4 = true, sz5 = true, sz6 = true,
            sz7 = true, sz8 = true, sz9 = true, sz10 = true, sz11 = true, sz12 = true, sz13 = true,
            sz14 = true, sz15 = true, sz16 = true, sz17 = true, sz18 = true, sz19 = true, sz20 = true,
            sz21 = true, sz22 = true, sz23 = true, sz24 = true, sz25 = true, sz26 = true;

    boolean som_zo = true, som_zo2 = true, som_zo3 = true, som_zo4 = true, som_zo5 = true, som_zo6 = true, som_zo7 = true, som_zo8 = true;

    int FPS = 20;
    boolean end = true;
    int janelaW = 355;
    int janelaH = 1250;
    int vida_z = 3;
    int vida_z1 = 3;
    int vida_z2 = 3;
    int vida_z3 = 3;
    int vida_z4 = 3;
    int vida_z5 = 3;
    int tiro = 0;
    int barra_vida1 = 0;
    int fundox = -150;
    int direc = 0;
    int pz, pz1, pz2, pz3, pz4, pz5;
    int nivel = 0;
    int z_ap = 0, z_ap1 = 0, z_ap2 = 0;
    int z_ap3 = 0, z_ap4 = 0, z_ap5 = 0, z_ap6 = 0;
    int z_ap7 = 0, z_ap8 = 0, z_ap9 = 0;
    int z_ap10 = 0, z_ap11 = 0, z_ap12 = 0;
    int z_ap13 = 0, z_ap14 = 0, z_ap15 = 0;
    int z_ap16 = 0, z_ap17 = 0, z_ap18 = 0;
    int z_ap19 = 0, z_ap20 = 0, z_ap21 = 0;
    int z_ap22 = 0, z_ap23 = 0;

    public static InputStream musica_jogo;
    public static InputStream som_zombie;

    public Sprite jogador = new Sprite(20, 0, 235);
    public Sprite jogador_disp = new Sprite(1, 0, 235);
    public Sprite jogador_para = new Sprite(1, 0, 235);

    public Sprite zombie = new Sprite(8, 1000, 220);
    public Sprite zombie1 = new Sprite(8, 1000, 220);
    public Sprite zombie2 = new Sprite(8, 1500, 220);

    public Sprite zombie_m = new Sprite(1, 1500, 220);

    int som_zom = 0;

    ImageIcon fundo;
    ImageIcon vida = new ImageIcon("src/Imagens/vida.png");
    ImageIcon barra_vida = new ImageIcon("src/Imagens/barra_vida100.png");
    ImageIcon barra_tiro = new ImageIcon("src/Imagens/barra_tiro100.png");
    ImageIcon gameover = new ImageIcon("src/Imagens/gameover.png");

    Rectangle zombies_z;
    Rectangle zombies_z1;
    Rectangle zombies_z2;

    public void niveis_fundo() throws IOException {
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();

        if (nivel == 0) {
            fundo = new ImageIcon("src/Imagens/nivel1_fundo1.png");
            Menu.nivel = 0;
            if (som_zo) {
                try {
                    som_zombie = new FileInputStream(new File("src/Audio/zombies.wav"));
                    AudioStream som_jogo = new AudioStream(som_zombie);
                    AudioPlayer.player.start(som_jogo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                som_zo = false;
            }

            if (som_zom == 3) {
                som_zombie.close();
            }
        }
        if (nivel == 1) {
            fundo = new ImageIcon("src/Imagens/nivel1_fundo2.png");
            Menu.nivel = 1;

            if (som_zo2) {

                try {
                    som_zombie = new FileInputStream(new File("src/Audio/zombies.wav"));
                    AudioStream som_jogo = new AudioStream(som_zombie);
                    AudioPlayer.player.start(som_jogo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                som_zo2 = false;
            }

            if (som_zom == 6) {
                som_zombie.close();
            }

        }
        if (nivel == 2) {
            fundo = new ImageIcon("src/Imagens/nivel2_fundo1.png");
            Menu.nivel = 2;

            if (som_zo3) {

                try {
                    som_zombie = new FileInputStream(new File("src/Audio/zombies.wav"));
                    AudioStream som_jogo = new AudioStream(som_zombie);
                    AudioPlayer.player.start(som_jogo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                som_zo3 = false;
            }

            if (som_zom == 9) {
                som_zombie.close();
            }
        }
        if (nivel == 3) {
            fundo = new ImageIcon("src/Imagens/nivel2_fundo2.png");
            Menu.nivel = 3;

            if (som_zo4) {

                try {
                    som_zombie = new FileInputStream(new File("src/Audio/zombies.wav"));
                    AudioStream som_jogo = new AudioStream(som_zombie);
                    AudioPlayer.player.start(som_jogo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                som_zo4 = false;
            }

            if (som_zom == 12) {
                som_zombie.close();
            }
        }
        if (nivel == 4) {
            fundo = new ImageIcon("src/Imagens/nivel3_fundo1.png");
            Menu.nivel = 4;

            if (som_zo5) {

                try {
                    som_zombie = new FileInputStream(new File("src/Audio/zombies.wav"));
                    AudioStream som_jogo = new AudioStream(som_zombie);
                    AudioPlayer.player.start(som_jogo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                som_zo5 = false;
            }

            if (som_zom == 15) {
                som_zombie.close();
            }
        }
        if (nivel == 5) {
            fundo = new ImageIcon("src/Imagens/nivel3_fundo2.png");
            Menu.nivel = 5;

            if (som_zo6) {

                try {
                    som_zombie = new FileInputStream(new File("src/Audio/zombies.wav"));
                    AudioStream som_jogo = new AudioStream(som_zombie);
                    AudioPlayer.player.start(som_jogo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                som_zo6 = false;
            }

            if (som_zom == 18) {
                som_zombie.close();
            }
        }
        if (nivel == 6) {
            fundo = new ImageIcon("src/Imagens/nivel4_fundo1.png");
            Menu.nivel = 6;

            if (som_zo7) {

                try {
                    som_zombie = new FileInputStream(new File("src/Audio/zombies.wav"));
                    AudioStream som_jogo = new AudioStream(som_zombie);
                    AudioPlayer.player.start(som_jogo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                som_zo7 = false;
            }

            if (som_zom == 21) {
                som_zombie.close();
            }
        }
        if (nivel == 7) {
            fundo = new ImageIcon("src/Imagens/nivel4_fundo2.png");
            Menu.nivel = 7;

            if (som_zo8) {

                try {
                    som_zombie = new FileInputStream(new File("src/Audio/zombies.wav"));
                    AudioStream som_jogo = new AudioStream(som_zombie);
                    AudioPlayer.player.start(som_jogo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                som_zo8 = false;
            }

            if (som_zom == 24) {
                som_zombie.close();
            }
        }
        if (nivel == 8) {
            fundo = new ImageIcon("src/Imagens/End.png");
            Menu.nivel = 8;
            pz = 9999;
            pz1 = 9999;
            pz2 = 9999;
            fundox = 0;
            jogador.x = 999999;
            jogador.y = 999999;
            end = false;

        }
        bbg.drawImage(fundo.getImage(), fundox, 0, this);

    }

    public void som() {
        try {
            musica_jogo = new FileInputStream(new File("src/Audio/som_jogo.wav"));
            AudioStream som_jogo = new AudioStream(musica_jogo);
            AudioPlayer.player.start(som_jogo);
        } catch (IOException erro) {
            System.out.println("Thread Interrompida!");
        }
    }

    public void desenharGraficos() throws IOException {

        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        if (end) {
            bbg.drawImage(vida.getImage(), 5, 35, 153, 78, this);
            bbg.drawImage(barra_vida.getImage(), 5, 35, 153, 78, this);
            bbg.drawImage(barra_tiro.getImage(), 5, 35, 153, 78, this);

        }

        if (barra_vida1 < 3) {
            if (direc == 0) {
                bbg.drawImage(jogador_para.cenas[jogador_para.cena].getImage(), jogador.x, jogador.y, this);
            }
            if (direc == 1) {
                bbg.drawImage(jogador.cenas[jogador.cena].getImage(), jogador.x, jogador.y, this);
            }
            if (direc == 3) {
                bbg.drawImage(jogador_disp.cenas[jogador_disp.cena].getImage(), jogador.x, jogador.y, this);
            }
        }

        Rectangle jogador_c;
        jogador_c = new Rectangle(jogador.x, jogador.y, jogador.largura_j, jogador.altura_j);

        if (barra_vida1 == 1) {
            barra_vida = new ImageIcon("src/Imagens/barra_vida50.png");
        }
        if (barra_vida1 == 2) {
            barra_vida = new ImageIcon("src/Imagens/barra_vida10.png");
        }
        if (barra_vida1 >= 3) {
            barra_vida = new ImageIcon("src/Imagens/....png");
            bbg.setColor(Color.RED);
            bbg.setFont(new Font("Arial", Font.PLAIN, 15));
            bbg.drawString("Clique no ENTER para avançar", 480, 270);
            bbg.drawImage(gameover.getImage(), 372, 70, 461, 167, this);
            musica_jogo.close();
            som_zombie.close();
        }

        if (tiro == 0) {
            barra_tiro = new ImageIcon("src/Imagens/barra_tiro100.png");
        }
        if (tiro == 1) {
            barra_tiro = new ImageIcon("src/Imagens/barra_tiro60.png");
        }
        if (tiro == 2) {
            barra_tiro = new ImageIcon("src/Imagens/barra_tiro10.png");
        }
        if (tiro == 3) {
            barra_tiro = new ImageIcon(".......png");
            bbg.setColor(Color.RED);
            bbg.setFont(new Font("Arial", Font.PLAIN, 15));
            bbg.drawString("Reload", jogador.x + 1, jogador.y - 10);
        }

//------------------NIVEL O----------------------
        if (nivel == 0) {
            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie.largura_z, zombie.altura_z);
            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie.largura_z, zombie.altura_z);
            if (zombies_z.intersects(jogador_c) || zombies_z1.intersects(jogador_c) || zombies_z2.intersects(jogador_c)) {

                if (v1 == 0 && zombies_z.intersects(jogador_c) && z_ap == 0) {
                    barra_vida1++;
                    v1 = 1;
                }
                if (v2 == 0 && zombies_z1.intersects(jogador_c) && z_ap1 == 0) {
                    barra_vida1++;
                    v2 = 1;
                }
                if (v3 == 0 && zombies_z2.intersects(jogador_c) && z_ap2 == 0) {
                    barra_vida1++;
                    v3 = 1;
                }
            }

            if (vida_z > 0 && jogador.x < 1150) {
                if (z_ap == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), zx, zombie.y, this);
                }
                zombie.animar();
                zx = zx - 10;
                pz = zx;
                if (zx < -20) {
                    vida_z = 0;
                }
            } else {
                vida_z = 0;
                zx = gerador.nextInt(800) + 1250;
                z_ap = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz, 275, this);
                zombie_m.animar_m();
                if (sz) {
                    som_zom++;
                    sz = false;
                }

            }

            if (vida_z1 > 0 && jogador.x < 1150) {
                if (z_ap1 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z1x, zombie1.y, this);
                }
                zombie.animar();
                z1x = z1x - 10;
                pz1 = z1x;
                if (z1x < -20) {
                    vida_z1 = 0;
                }
            } else {
                vida_z1 = 0;

                z1x = gerador.nextInt(800) + 1250;
                z_ap1 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz1, 275, this);
                zombie_m.animar_m();
                if (sz1) {
                    som_zom++;
                    sz1 = false;
                }
            }

            if (vida_z2 > 0 && jogador.x < 1150) {
                if (z_ap2 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z2x, zombie2.y, this);
                }
                zombie.animar();
                z2x = z2x - 10;
                pz2 = z2x;
                if (z2x < -20) {
                    vida_z2 = 0;
                }
            } else {
                vida_z2 = 0;
                z2x = gerador.nextInt(800) + 1250;
                z_ap2 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz2, 275, this);
                zombie_m.animar_m();
                if (sz2) {
                    som_zom++;
                    sz2 = false;
                }
            }
        }
//        -----------------------------NIVEL 1---------------------                

        if (nivel == 1) {
            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie.largura_z, zombie.altura_z);
            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie.largura_z, zombie.altura_z);
            if (zombies_z.intersects(jogador_c) || zombies_z1.intersects(jogador_c) || zombies_z2.intersects(jogador_c)) {

                if (v4 == 0 && zombies_z.intersects(jogador_c) && z_ap3 == 0) {
                    barra_vida1++;
                    v4 = 1;
                }
                if (v5 == 0 && zombies_z1.intersects(jogador_c) && z_ap4 == 0) {
                    barra_vida1++;
                    v5 = 1;
                }
                if (v6 == 0 && zombies_z2.intersects(jogador_c) && z_ap5 == 0) {
                    barra_vida1++;
                    v6 = 1;
                }

            }
            if (vida_z > -4 && jogador.x < 1150) {
                if (z_ap3 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), zx, zombie.y, this);
                }
                zombie.animar();
                zx = zx - 11;
                pz = zx;
                if (zx < -20) {
                    vida_z = -4;
                }
            } else {
                vida_z = -4;
                zx = gerador.nextInt(800) + 1250;
                z_ap3 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz, 275, this);
                zombie_m.animar_m();
                if (sz3) {
                    som_zom++;
                    sz3 = false;
                }
            }

            if (vida_z1 > -4 && jogador.x < 1150) {
                if (z_ap4 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z1x, zombie1.y, this);
                }
                zombie.animar();
                z1x = z1x - 10;
                pz1 = z1x;
                if (z1x < -20) {
                    vida_z1 = -4;
                }
            } else {
                vida_z1 = -4;
                z1x = gerador.nextInt(800) + 1250;
                z_ap4 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz1, 275, this);
                zombie_m.animar_m();
                if (sz4) {
                    som_zom++;
                    sz4 = false;
                }
            }

            if (vida_z2 > -4 && jogador.x < 1150) {
                if (z_ap5 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z2x, zombie2.y, this);
                }
                zombie.animar();
                z2x = z2x - 11;
                pz2 = z2x;
                if (z2x < -20) {
                    vida_z2 = -4;
                }
            } else {
                vida_z2 = -4;
                z2x = gerador.nextInt(800) + 1250;
                z_ap5 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz2, 275, this);
                zombie_m.animar_m();
                if (sz5) {
                    som_zom++;
                    sz5 = false;
                }
            }

        }

//        -----------------------------NIVEL 2---------------------
        if (nivel == 2) {
            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie.largura_z, zombie.altura_z);
            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie.largura_z, zombie.altura_z);
            if (zombies_z.intersects(jogador_c) || zombies_z1.intersects(jogador_c) || zombies_z2.intersects(jogador_c)) {

                if (v7 == 0 && zombies_z.intersects(jogador_c) && z_ap6 == 0) {
                    barra_vida1++;
                    v7 = 1;
                }
                if (v8 == 0 && zombies_z1.intersects(jogador_c) && z_ap7 == 0) {
                    barra_vida1++;
                    v8 = 1;
                }
                if (v9 == 0 && zombies_z2.intersects(jogador_c) && z_ap8 == 0) {
                    barra_vida1++;
                    v9 = 1;
                }

            }

            if (vida_z > -7 && jogador.x < 1150) {
                if (z_ap6 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), zx, zombie.y, this);
                }
                zombie.animar();
                zx = zx - 11;
                pz = zx;
                if (zx < -20) {
                    vida_z = -7;
                }
            } else {
                vida_z = -7;
                zx = gerador.nextInt(800) + 1250;
                z_ap6 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz, 275, this);
                zombie_m.animar_m();
                if (sz6) {
                    som_zom++;
                    sz6 = false;
                }
            }

            if (vida_z1 > -7 && jogador.x < 1150) {
                if (z_ap7 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z1x, zombie1.y, this);
                }
                zombie.animar();
                z1x = z1x - 11;
                pz1 = z1x;
                if (z1x < -20) {
                    vida_z1 = -7;
                }
            } else {
                vida_z1 = -7;
                z1x = gerador.nextInt(800) + 1250;
                z_ap7 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz1, 275, this);
                zombie_m.animar_m();
                if (sz7) {
                    som_zom++;
                    sz7 = false;
                }
            }

            if (vida_z2 > -7 && jogador.x < 1150) {
                if (z_ap8 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z2x, zombie2.y, this);
                }
                zombie.animar();
                z2x = z2x - 11;
                pz2 = z2x;
                if (z2x < -20) {
                    vida_z2 = -7;
                }
            } else {
                vida_z2 = -7;
                z2x = gerador.nextInt(800) + 1250;
                z_ap8 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz2, 275, this);
                zombie_m.animar_m();
                if (sz8) {
                    som_zom++;
                    sz8 = false;
                }
            }

        }

        //        -----------------------------NIVEL 3---------------------
        if (nivel == 3) {
            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie.largura_z, zombie.altura_z);
            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie.largura_z, zombie.altura_z);

            if (zombies_z.intersects(jogador_c) || zombies_z1.intersects(jogador_c) || zombies_z2.intersects(jogador_c)) {

                if (v10 == 0 && zombies_z.intersects(jogador_c) && z_ap9 == 0) {
                    barra_vida1++;
                    v10 = 1;
                }
                if (v11 == 0 && zombies_z1.intersects(jogador_c) && z_ap10 == 0) {
                    barra_vida1++;
                    v11 = 1;
                }
                if (v12 == 0 && zombies_z2.intersects(jogador_c) && z_ap11 == 0) {
                    barra_vida1++;
                    v12 = 1;
                }

            }

            if (vida_z > -11 && jogador.x < 1150) {
                if (z_ap9 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), zx, zombie.y, this);
                }
                zombie.animar();
                zx = zx - 12;
                pz = zx;
                if (zx < -20) {
                    vida_z = -11;
                }
            } else {
                vida_z = -11;
                zx = gerador.nextInt(800) + 1250;
                z_ap9 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz, 275, this);
                zombie_m.animar_m();
                if (sz9) {
                    som_zom++;
                    sz9 = false;
                }
            }

            if (vida_z1 > -11 && jogador.x < 1150) {
                if (z_ap10 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z1x, zombie1.y, this);
                }
                zombie.animar();
                z1x = z1x - 12;
                pz1 = z1x;
                if (z1x < -20) {
                    vida_z1 = -11;
                }
            } else {
                vida_z1 = -11;
                z1x = gerador.nextInt(800) + 1250;
                z_ap10 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz1, 275, this);
                zombie_m.animar_m();
                if (sz10) {
                    som_zom++;
                    sz10 = false;
                }
            }

            if (vida_z2 > -11 && jogador.x < 1150) {
                if (z_ap11 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z2x, zombie2.y, this);
                }
                zombie.animar();
                z2x = z2x - 11;
                pz2 = z2x;
                if (z2x < -20) {
                    vida_z2 = -11;
                }
            } else {
                vida_z2 = -11;
                z2x = gerador.nextInt(800) + 1250;
                z_ap11 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz2, 275, this);
                zombie_m.animar_m();
                if (sz11) {
                    som_zom++;
                    sz11 = false;
                }
            }

        }

        //        -----------------------------NIVEL 4---------------------
        if (nivel == 4) {
            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie.largura_z, zombie.altura_z);
            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie.largura_z, zombie.altura_z);

            if (zombies_z.intersects(jogador_c) || zombies_z1.intersects(jogador_c) || zombies_z2.intersects(jogador_c)) {

                if (v13 == 0 && zombies_z.intersects(jogador_c) && z_ap12 == 0) {
                    barra_vida1++;
                    v13 = 1;
                }
                if (v14 == 0 && zombies_z1.intersects(jogador_c) && z_ap13 == 0) {
                    barra_vida1++;
                    v14 = 1;
                }
                if (v15 == 0 && zombies_z2.intersects(jogador_c) && z_ap14 == 0) {
                    barra_vida1++;
                    v15 = 1;
                }

            }

            if (vida_z > -15 && jogador.x < 1150) {
                if (z_ap12 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), zx, zombie.y, this);
                }
                zombie.animar();
                zx = zx - 12;
                pz = zx;
                if (zx < -20) {
                    vida_z = -15;
                }
            } else {
                vida_z = -15;
                zx = gerador.nextInt(800) + 1250;
                z_ap12 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz, 275, this);
                zombie_m.animar_m();
                if (sz15) {
                    som_zom++;
                    sz15 = false;
                }
            }

            if (vida_z1 > -15 && jogador.x < 1150) {
                if (z_ap13 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z1x, zombie1.y, this);
                }
                zombie.animar();
                z1x = z1x - 12;
                pz1 = z1x;
                if (z1x < -20) {
                    vida_z1 = -15;
                }
            } else {
                vida_z1 = -15;
                z1x = gerador.nextInt(800) + 1250;
                z_ap13 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz1, 275, this);
                zombie_m.animar_m();
                if (sz16) {
                    som_zom++;
                    sz16 = false;
                }
            }

            if (vida_z2 > -15 && jogador.x < 1150) {
                if (z_ap14 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z2x, zombie2.y, this);
                }
                zombie.animar();
                z2x = z2x - 12;
                pz2 = z2x;
                if (z2x < -20) {
                    vida_z2 = -15;
                }
            } else {
                vida_z2 = -15;
                z2x = gerador.nextInt(800) + 1250;
                z_ap14 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz2, 275, this);
                zombie_m.animar_m();
                if (sz17) {
                    som_zom++;
                    sz17 = false;
                }
            }

        }

        //        -----------------------------NIVEL 5---------------------
        if (nivel == 5) {
            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie.largura_z, zombie.altura_z);
            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie.largura_z, zombie.altura_z);

            if (zombies_z.intersects(jogador_c) || zombies_z1.intersects(jogador_c) || zombies_z2.intersects(jogador_c)) {

                if (v16 == 0 && zombies_z.intersects(jogador_c) && z_ap15 == 0) {
                    barra_vida1++;
                    v16 = 1;
                }
                if (v17 == 0 && zombies_z1.intersects(jogador_c) && z_ap16 == 0) {
                    barra_vida1++;
                    v17 = 1;
                }
                if (v18 == 0 && zombies_z2.intersects(jogador_c) && z_ap17 == 0) {
                    barra_vida1++;
                    v18 = 1;
                }

            }

            if (vida_z > -19 && jogador.x < 1150) {
                if (z_ap15 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), zx, zombie.y, this);
                }
                zombie.animar();
                zx = zx - 13;
                pz = zx;
                if (zx < -20) {
                    vida_z = -19;
                }
            } else {
                vida_z = -19;
                zx = gerador.nextInt(800) + 1250;
                z_ap15 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz, 275, this);
                zombie_m.animar_m();
                if (sz18) {
                    som_zom++;
                    sz18 = false;
                }
            }

            if (vida_z1 > -19 && jogador.x < 1150) {
                if (z_ap16 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z1x, zombie1.y, this);
                }
                zombie.animar();
                z1x = z1x - 13;
                pz1 = z1x;
                if (z1x < -20) {
                    vida_z1 = -19;
                }
            } else {
                vida_z1 = -19;
                z1x = gerador.nextInt(800) + 1250;
                z_ap16 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz1, 275, this);
                zombie_m.animar_m();
                if (sz19) {
                    som_zom++;
                    sz19 = false;
                }
            }

            if (vida_z2 > -19 && jogador.x < 1150) {
                if (z_ap17 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z2x, zombie2.y, this);
                }
                zombie.animar();
                z2x = z2x - 12;
                pz2 = z2x;
                if (z2x < -20) {
                    vida_z2 = -19;
                }
            } else {
                vida_z2 = -19;
                z2x = gerador.nextInt(800) + 1250;
                z_ap17 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz2, 275, this);
                zombie_m.animar_m();
                if (sz20) {
                    som_zom++;
                    sz20 = false;
                }
            }

        }

        //        -----------------------------NIVEL 6---------------------
        if (nivel == 6) {
            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie.largura_z, zombie.altura_z);
            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie.largura_z, zombie.altura_z);

            if (zombies_z.intersects(jogador_c) || zombies_z1.intersects(jogador_c) || zombies_z2.intersects(jogador_c)) {

                if (v19 == 0 && zombies_z.intersects(jogador_c) && z_ap18 == 0) {
                    barra_vida1++;
                    v19 = 1;
                }
                if (v20 == 0 && zombies_z1.intersects(jogador_c) && z_ap19 == 0) {
                    barra_vida1++;
                    v20 = 1;
                }
                if (v21 == 0 && zombies_z2.intersects(jogador_c) && z_ap20 == 0) {
                    barra_vida1++;
                    v21 = 1;
                }

            }

            if (vida_z > -24 && jogador.x < 1150) {
                if (z_ap18 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), zx, zombie.y, this);
                }
                zombie.animar();
                zx = zx - 13;
                pz = zx;
                if (zx < -20) {
                    vida_z = -24;
                }
            } else {
                vida_z = -24;
                zx = gerador.nextInt(800) + 1250;
                z_ap18 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz, 275, this);
                zombie_m.animar_m();
                if (sz21) {
                    som_zom++;
                    sz21 = false;
                }
            }

            if (vida_z1 > -24 && jogador.x < 1150) {
                if (z_ap19 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z1x, zombie1.y, this);
                }
                zombie.animar();
                z1x = z1x - 13;
                pz1 = z1x;
                if (z1x < -20) {
                    vida_z1 = -24;
                }
            } else {
                vida_z1 = -24;
                z1x = gerador.nextInt(800) + 1250;
                z_ap19 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz1, 275, this);
                zombie_m.animar_m();
                if (sz22) {
                    som_zom++;
                    sz22 = false;
                }
            }

            if (vida_z2 > -24 && jogador.x < 1150) {
                if (z_ap20 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z2x, zombie2.y, this);
                }
                zombie.animar();
                z2x = z2x - 13;
                pz2 = z2x;
                if (z2x < -20) {
                    vida_z2 = -24;
                }
            } else {
                vida_z2 = -24;
                z2x = gerador.nextInt(800) + 1250;
                z_ap20 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz2, 275, this);
                zombie_m.animar_m();
                if (sz23) {
                    som_zom++;
                    sz23 = false;
                }
            }

        }

        //        -----------------------------NIVEL 7---------------------
        if (nivel == 7) {
            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie.largura_z, zombie.altura_z);
            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie.largura_z, zombie.altura_z);

            if (zombies_z.intersects(jogador_c) || zombies_z1.intersects(jogador_c) || zombies_z2.intersects(jogador_c)) {

                if (v22 == 0 && zombies_z.intersects(jogador_c) && z_ap21 == 0) {
                    barra_vida1++;
                    v22 = 1;
                }
                if (v23 == 0 && zombies_z1.intersects(jogador_c) && z_ap22 == 0) {
                    barra_vida1++;
                    v23 = 1;
                }
                if (v24 == 0 && zombies_z2.intersects(jogador_c) && z_ap23 == 0) {
                    barra_vida1++;
                    v24 = 1;
                }

            }

            if (vida_z > -29 && jogador.x < 1150) {
                if (z_ap21 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), zx, zombie.y, this);
                }
                zombie.animar();
                zx = zx - 14;
                pz = zx;
                if (zx < -20) {
                    vida_z = -29;
                }
            } else {
                vida_z = -29;
                zx = gerador.nextInt(800) + 1250;
                z_ap21 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz, 275, this);
                zombie_m.animar_m();
                if (sz24) {
                    som_zom++;
                    sz24 = false;
                }
            }

            if (vida_z1 > -29 && jogador.x < 1150) {
                if (z_ap22 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z1x, zombie1.y, this);
                }
                zombie.animar();
                z1x = z1x - 14;
                pz1 = z1x;
                if (z1x < -20) {
                    vida_z1 = -29;
                }
            } else {
                vida_z1 = -29;
                z1x = gerador.nextInt(800) + 1250;
                z_ap22 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz1, 275, this);
                zombie_m.animar_m();
                if (sz25) {
                    som_zom++;
                    sz25 = false;
                }
            }

            if (vida_z2 > -29 && jogador.x < 1150) {
                if (z_ap23 == 0) {
                    bbg.drawImage(zombie.cenas[zombie.cena].getImage(), z2x, zombie2.y, this);
                }
                zombie.animar();
                z2x = z2x - 13;
                pz2 = z2x;
                if (z2x < -20) {
                    vida_z2 = -29;
                }
            } else {
                vida_z2 = -29;
                z2x = gerador.nextInt(800) + 1250;
                z_ap23 = 1;
                bbg.drawImage(zombie_m.cenas[zombie_m.cena].getImage(), pz2, 275, this);
                zombie_m.animar_m();
                if (sz26) {
                    som_zom++;
                    sz26 = false;
                }
            }

        }

        List<Bala> bala1 = jogador.getBalas();
        for (int i = 0; i < bala1.size(); i++) {

            Bala m = (Bala) bala1.get(i);

            if (m.isVisivel()) {
                m.mexer();
                if (m.x >= 1240) {
                    m.x = 99999;
                }
            } else {
                bala1.remove(i);
            }

            zombies_z = new Rectangle(zx, zombie.y, zombie.largura_z, zombie.altura_z);

            Rectangle bala_c;
            bala_c = new Rectangle(m.x, m.y, m.largura, m.altura);
            if (zombies_z.intersects(bala_c)) {
                m.x = 9999999;
                vida_z--;
            }
            zombies_z1 = new Rectangle(z1x, zombie1.y, zombie1.largura_z, zombie1.altura_z);

            bala_c = new Rectangle(m.x, m.y, m.largura, m.altura);
            if (zombies_z1.intersects(bala_c)) {
                m.x = 9999999;
                vida_z1--;
            }

            zombies_z2 = new Rectangle(z2x, zombie2.y, zombie2.largura_z, zombie2.altura_z);
            bala_c = new Rectangle(m.x, m.y, m.largura, m.altura);
            if (zombies_z2.intersects(bala_c)) {
                m.x = 9999999;
                vida_z2--;
            }

            bbg.drawImage(m.getImagem(), m.getX(), m.getY(), this);
        }

        g.drawImage(backBuffer, 0, 0, this);

    }

    public void highscore() {
        try {
            FileWriter fxEscrita;
            BufferedWriter fluxoEscrita;
            PrintWriter escrever;
            fxEscrita = new FileWriter("Highscore.txt", true);
            fluxoEscrita = new BufferedWriter(fxEscrita);
            escrever = new PrintWriter(fluxoEscrita);

            escrever.println(Menu.nome);
            escrever.println(Menu.nivel + 1);

            escrever.close();
            fluxoEscrita.close();
            fxEscrita.close();
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inicializar() {
        setTitle("Welcome to Zombie Land");
        setSize(janelaH, janelaW);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        addKeyListener(this);

        backBuffer = new BufferedImage(janelaH, janelaW, BufferedImage.TYPE_INT_RGB);

//--------------------------    Jogador  ----------------------
        jogador_para.cenas[0] = new ImageIcon("src/Imagens/Movimento/parado.png");

        jogador_disp.cenas[0] = new ImageIcon("src/Imagens/Movimento/disparar.png");

        jogador.cenas[0] = new ImageIcon("src/Imagens/Movimento/c1.png");
        jogador.cenas[1] = new ImageIcon("src/Imagens/Movimento/c2.png");
        jogador.cenas[2] = new ImageIcon("src/Imagens/Movimento/c3.png");
        jogador.cenas[3] = new ImageIcon("src/Imagens/Movimento/c4.png");
        jogador.cenas[4] = new ImageIcon("src/Imagens/Movimento/c5.png");
        jogador.cenas[5] = new ImageIcon("src/Imagens/Movimento/c6.png");
        jogador.cenas[6] = new ImageIcon("src/Imagens/Movimento/c7.png");
        jogador.cenas[7] = new ImageIcon("src/Imagens/Movimento/c8.png");
        jogador.cenas[8] = new ImageIcon("src/Imagens/Movimento/c9.png");

        jogador.cenas[9] = new ImageIcon("src/Imagens/Movimento/c1_esq.png");
        jogador.cenas[10] = new ImageIcon("src/Imagens/Movimento/c2_esq.png");
        jogador.cenas[11] = new ImageIcon("src/Imagens/Movimento/c3_esq.png");
        jogador.cenas[12] = new ImageIcon("src/Imagens/Movimento/c4_esq.png");
        jogador.cenas[13] = new ImageIcon("src/Imagens/Movimento/c5_esq.png");
        jogador.cenas[14] = new ImageIcon("src/Imagens/Movimento/c6_esq.png");
        jogador.cenas[15] = new ImageIcon("src/Imagens/Movimento/c7_esq.png");
        jogador.cenas[16] = new ImageIcon("src/Imagens/Movimento/c8_esq.png");
        jogador.cenas[17] = new ImageIcon("src/Imagens/Movimento/c9_esq.png");

//--------------------------    Zombie  ----------------------
        zombie.cenas[0] = new ImageIcon("src/Imagens/Movimento/z1.png");
        zombie.cenas[1] = new ImageIcon("src/Imagens/Movimento/z2.png");
        zombie.cenas[2] = new ImageIcon("src/Imagens/Movimento/z3.png");
        zombie.cenas[3] = new ImageIcon("src/Imagens/Movimento/z4.png");
        zombie.cenas[4] = new ImageIcon("src/Imagens/Movimento/z5.png");
        zombie.cenas[5] = new ImageIcon("src/Imagens/Movimento/z6.png");
        zombie.cenas[6] = new ImageIcon("src/Imagens/Movimento/z7.png");
        zombie.cenas[7] = new ImageIcon("src/Imagens/Movimento/z8.png");

        zombie_m.cenas[0] = new ImageIcon("src/Imagens/Movimento/m8.png");

    }

    public void run() throws IOException {

        inicializar();
        som();

        while (end) {

            niveis_fundo();
            desenharGraficos();
            try {
                Thread.sleep(1000 / FPS);
            } catch (Exception erro) {
                System.out.println("Thread Interrompida!");
            }
        }
        if (end == false) {
            highscore();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            direc = 1;

            if (jogador.x < 1210 && barra_vida1 < 3) {
                jogador.x += 10;
                fundox -= 1;
                pz -= 1;
                pz1 -= 1;
                pz2 -= 1;
                pz3 -= 1;
                pz4 -= 1;
                pz5 -= 1;
                if (jogador.cena >= 8) {
                    jogador.cena = 0;
                }
                jogador.animar_direita(1);
            }
            if (jogador.x == 1200) {
                nivel++;
                jogador.x = 0;
                fundox = -150;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            direc = 1;
            if (jogador.x > 0 && barra_vida1 < 3) {
                jogador.x -= 10;
                fundox += 1;
                pz += 1;
                pz1 += 1;
                pz2 += 1;
                pz3 -= 1;
                pz4 -= 1;
                pz5 -= 1;
                if (jogador.cena < 9) {
                    jogador.cena = 9;
                }
                jogador.animar_esquerda(1);
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            try {
                musica_jogo.close();
            } catch (IOException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Menu.menu = true;
            Menu.menu_start = true;
            try {
                musica_jogo.close();
                som_zombie.close();
            } catch (IOException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }

            end = false;
            dispose();
        }

        if (e.getKeyCode() == KeyEvent.VK_R) {

            if (barra_vida1 < 3) {
                tiro = 0;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (barra_vida1 >= 3) {
                Menu.menu = true;
                Menu.menu_start = true;
                end = false;
                dispose();
            }
            if (nivel == 8) {
                Menu.menu = true;
                Menu.menu_start = true;
                dispose();
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            if (tiro < 3 && barra_vida1 < 3) {
                direc = 3;
                jogador.dispara();
                tiro++;
                InputStream in;
                try {
                    in = new FileInputStream(new File("src/Audio/gun.wav"));
                    AudioStream audio_bala = new AudioStream(in);
                    AudioPlayer.player.start(audio_bala);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            direc = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            direc = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            direc = 0;

        }
    }
}
