import java.awt.Container;
import java.awt.image.BufferedImage;
import java.awt.GridLayout;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.util.*;

public class Main extends JFrame{
    public static Container contenedor;
    public static Board board;
    public static WinWar winWar;
    private BufferedImage img;
    public static int turno;
    public static Jugador jugador1;
    public static Jugador jugador2;
    public Main(){
        this.jugador1 = new Jugador();
        this.jugador2 = new Jugador();
        this.setTitle("Rompecabezas");
        this.setSize(780, 680);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);       
        contenedor = this.getContentPane();
        contenedor.setLayout(new FlowLayout(FlowLayout.LEFT));
        leerImagen();
        board = new Board(img);
        contenedor.add(board);
        winWar = new WinWar();
        contenedor.add(winWar);
        this.setVisible(true);
        
        this.turno = 0;
    }
    public void leerImagen(){
        try {img = ImageIO.read(new File("cam.jpg"));
        } catch (IOException e) {e.printStackTrace();}
    }
}