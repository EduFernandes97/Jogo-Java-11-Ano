package Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Menu extends JFrame implements KeyListener, MouseListener, MouseMotionListener {

    public Sprite z = new Sprite(6, 0, 235);
    public Sprite z_i = new Sprite(6, 0, 235);
    BufferedImage backBuffer;
    ImageIcon fundo = new ImageIcon("src/Imagens/menu.png");
    ImageIcon help = new ImageIcon("src/Imagens/menu_help.png");
    ImageIcon highscore = new ImageIcon("src/Imagens/menu_highscore.png");
    int FPS = 10;
    int janelaW = 1250;
    int janelaH = 355;
    int cenario = -1;
    int itemSelecionado = 0;
    public static String nome;
    public static int nivel;

    public static InputStream musica_menu;
    public static boolean menu_start = true;
    public static boolean menu = true;

    boolean a = true, b = true, c = true, d = true;

    Font font = new Font("Arial", Font.PLAIN, 50);

    public void opcoes() throws IOException {
        Graphics bbg = backBuffer.getGraphics();
        if (cenario == 1) {
            try {
                musica_menu.close();
            } catch (IOException ex) {
                Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            Jogo jog = new Jogo();
            jog.run();
            cenario = -1;
        }

        if (cenario == 2) {
            bbg.drawImage(help.getImage(), 0, 0, this);
        }

        if (cenario == 3) {
            bbg.drawImage(highscore.getImage(), 0, 0, this);
            try {
                FileReader fxLeitura;
                BufferedReader fluxoLeitura;
                fxLeitura = new FileReader("Highscore.txt");
                fluxoLeitura = new BufferedReader(fxLeitura);
                int sy = 120;
                int cont_niv = 0, cont_nom = 0;
                while (fluxoLeitura.ready()) {
                    String linha = fluxoLeitura.readLine();
                    if (Character.isDigit(linha.charAt(0)) && cont_niv < 10) {
                        //print nivel
                        bbg.setColor(Color.RED);
                        bbg.setFont(new Font("Arial", Font.BOLD, 16));
                        bbg.drawString(linha, 1125, sy);
                        cont_niv++;
                    } else if (cont_niv < 10) {
                        //print nome
                        sy += 20;
                        bbg.setColor(Color.RED);
                        bbg.setFont(new Font("Arial", Font.BOLD, 16));
                        bbg.drawString(linha, 555, sy);
                        cont_nom++;
                    }
                    if (cont_niv >= 10 || cont_nom >= 10) {
                        bbg.setColor(Color.RED);
                        bbg.setFont(new Font("Arial", Font.BOLD, 16));
                        bbg.drawString("Highscore cheio, apague o ficheiro!", 700, 340);

                    }
                }
                fluxoLeitura.close();
                fxLeitura.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                System.out.print("Erro: " + ex.getMessage());
            } catch (IOException io) {
            }
        }

        if (cenario == 4) {
            System.exit(0);
        }
    }

    public void som() {
        if (menu) {
            if (menu_start) {
                try {
                    musica_menu = new FileInputStream(new File("src/Audio/menu.wav"));
                    AudioStream som__menu = new AudioStream(musica_menu);
                    AudioPlayer.player.start(som__menu);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
            }
            menu = false;
        }

    }

    public void desenharMenu() throws IOException {
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, janelaW, janelaH);
        bbg.setFont(font);
        bbg.drawImage(fundo.getImage(), 0, 0, this);

        if (itemSelecionado == 1) {
            bbg.drawImage(z.cenas[z.cena].getImage(), 168, 145, this);
            bbg.drawImage(z_i.cenas[z_i.cena].getImage(), 15, 145, this);
            z.animar();
            z_i.animar();
        }

        if (itemSelecionado == 2) {
            bbg.drawImage(z.cenas[z.cena].getImage(), 140, 195, this);
            bbg.drawImage(z_i.cenas[z_i.cena].getImage(), 15, 195, this);
            z.animar();
            z_i.animar();
        }

        if (itemSelecionado == 3) {
            bbg.drawImage(z.cenas[z.cena].getImage(), 250, 235, this);
            bbg.drawImage(z_i.cenas[z_i.cena].getImage(), 15, 235, this);
            z.animar();
            z_i.animar();
        }

        if (itemSelecionado == 4) {
            bbg.drawImage(z.cenas[z.cena].getImage(), 155, 280, this);
            bbg.drawImage(z_i.cenas[z_i.cena].getImage(), 15, 280, this);
            z.animar();
            z_i.animar();
        }

        opcoes();
        g.drawImage(backBuffer, 0, 0, this);
    }

    public void inicializar() {

        setTitle("Welcome to Zombie Land");
        setSize(janelaW, janelaH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        backBuffer = new BufferedImage(janelaW, janelaH, BufferedImage.TYPE_INT_RGB);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        while (nome == null) {
            nome = JOptionPane.showInputDialog("Qual o seu nome?");
            while ("".equals(nome)) {
                nome = JOptionPane.showInputDialog("Qual o seu nome?");
            }
        }

        z.cenas[0] = new ImageIcon("src/Imagens/Movimento_menu/z1.png");
        z.cenas[1] = new ImageIcon("src/Imagens/Movimento_menu/z2.png");
        z.cenas[2] = new ImageIcon("src/Imagens/Movimento_menu/z3.png");
        z.cenas[3] = new ImageIcon("src/Imagens/Movimento_menu/z4.png");
        z.cenas[4] = new ImageIcon("src/Imagens/Movimento_menu/z5.png");
        z.cenas[5] = new ImageIcon("src/Imagens/Movimento_menu/z6.png");

        z_i.cenas[0] = new ImageIcon("src/Imagens/Movimento_menu/z1_i.png");
        z_i.cenas[1] = new ImageIcon("src/Imagens/Movimento_menu/z2_i.png");
        z_i.cenas[2] = new ImageIcon("src/Imagens/Movimento_menu/z3_i.png");
        z_i.cenas[3] = new ImageIcon("src/Imagens/Movimento_menu/z4_i.png");
        z_i.cenas[4] = new ImageIcon("src/Imagens/Movimento_menu/z5_i.png");
        z_i.cenas[5] = new ImageIcon("src/Imagens/Movimento_menu/z6_i.png");
    }

    public void run() throws IOException {
        inicializar();

        while (true) {

            desenharMenu();
            som();
            try {
                Thread.sleep(1000 / FPS);
            } catch (Exception e) {
                System.out.println("Thread interronpida!!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            itemSelecionado -= 1;
            InputStream in;
            try {
                in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                AudioStream audio_passo = new AudioStream(in);
                AudioPlayer.player.start(audio_passo);
            } catch (IOException erro) {
                System.out.println("Thread Interrompida!");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            itemSelecionado += 1;
            InputStream in;
            try {
                in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                AudioStream audio_passo = new AudioStream(in);
                AudioPlayer.player.start(audio_passo);
            } catch (IOException erro) {
                System.out.println("Thread Interrompida!");
            }
        }
        if (itemSelecionado == 5) {
            itemSelecionado = 1;
            InputStream in;
            try {
                in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                AudioStream audio_passo = new AudioStream(in);
                AudioPlayer.player.start(audio_passo);
            } catch (IOException erro) {
                System.out.println("Thread Interrompida!");
            }
        }
        if (itemSelecionado < 1) {
            itemSelecionado = 4;
            InputStream in;
            try {
                in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                AudioStream audio_passo = new AudioStream(in);
                AudioPlayer.player.start(audio_passo);
            } catch (IOException erro) {
                System.out.println("Thread Interrompida!");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            cenario = itemSelecionado;
            InputStream in;
            try {
                in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                AudioStream audio_passo = new AudioStream(in);
                AudioPlayer.player.start(audio_passo);
            } catch (IOException erro) {
                System.out.println("Thread Interrompida!");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            cenario = -1;
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cenario = itemSelecionado;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ((e.getX() > 15 && e.getX() < 168) && (e.getY() > 150 && e.getY() < 200)) {
            if (a) {
                InputStream in;
                try {
                    in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                    AudioStream audio_passo = new AudioStream(in);
                    AudioPlayer.player.start(audio_passo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                a = false;
            }
            d = true;
            b = true;
            c = true;

            itemSelecionado = 1;
        }

        if ((e.getX() > 15 && e.getX() < 168) && (e.getY() > 200 && e.getY() < 250)) {
            if (b) {
                InputStream in;
                try {
                    in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                    AudioStream audio_passo = new AudioStream(in);
                    AudioPlayer.player.start(audio_passo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                b = false;
            }
            a = true;
            d = true;
            c = true;

            itemSelecionado = 2;
        }

        if ((e.getX() > 15 && e.getX() < 230) && (e.getY() > 250 && e.getY() < 300)) {
            if (c) {
                InputStream in;
                try {
                    in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                    AudioStream audio_passo = new AudioStream(in);
                    AudioPlayer.player.start(audio_passo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                c = false;
            }
            a = true;
            b = true;
            d = true;

            itemSelecionado = 3;
        }

        if ((e.getX() > 15 && e.getX() < 168) && (e.getY() > 300 && e.getY() < 350)) {
            if (d) {
                InputStream in;
                try {
                    in = new FileInputStream(new File("src/Audio/sel_menu.wav"));
                    AudioStream audio_passo = new AudioStream(in);
                    AudioPlayer.player.start(audio_passo);
                } catch (IOException erro) {
                    System.out.println("Thread Interrompida!");
                }
                d = false;
            }
            a = true;
            b = true;
            c = true;
            itemSelecionado = 4;
        }

    }
}
