
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class Board extends JPanel{
    public static Cell[][] board;
    private ArrayList<Cell> completeBoard = new ArrayList<Cell>();
    private int dimension;
    private int x, y;   
    private int figuraWidth, figuraHeight;
    private JLabel empty;
    private int cont;
    public Board(BufferedImage imagen){
        this.setPreferredSize(new Dimension(640, 640));
        this.dimension = 16;
        board = new Cell[dimension][dimension];
        x = 0;
        y = 0;
        cont = 0;
        this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        recortar(imagen);
        desordenar();
        remover();
        llenar();
        this.setVisible(true);
    }
    
    private void recortar(BufferedImage imagen){
        figuraWidth = imagen.getWidth()/ dimension;
        figuraHeight = imagen.getHeight()/ dimension;
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j< dimension; j++){
                completeBoard.add(new Cell(i, j, new Figura(i, j, new ImageIcon(imagen.getSubimage(x, y, figuraWidth, figuraHeight)), dimension)));
                x += figuraWidth;
            }
            x = 0;
            y += figuraHeight;
        }
    }
    
    private void desordenar(){
        ArrayList<Cell> copia = new ArrayList<Cell>(completeBoard);
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j< dimension; j++){
                board[i][j] = new Cell(i, j, completeBoard.get(cont).getFigura());
                completeBoard.remove(cont);
            }
        }
        completeBoard = copia;
        remover();
    }
    
    private void actualizar(){
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j< dimension; j++){
                if(board[i][j].getFigura() == null){
                    empty = new JLabel();
                    empty.setPreferredSize(new Dimension(figuraWidth, figuraHeight));
                    this.add(empty);
                    continue;
                }
                this.add(board[i][j].getFigura());
            }
        }
        Main.contenedor.validate();
    }
    
    public void remover(){
        this.removeAll();
        actualizar();
    }
    
    public void llenar(){
        int xs = -8;
        int ys = 8;
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j< dimension; j++){
                if(dimension/2 > i){
                    if(dimension/2 > j){
                        board[i][j].setCOX(xs + j);
                    }else{  
                        board[i][j].setCOX(xs + j + 1);
                    }
                    board[i][j].setCOY(ys - i);
                }else{
                    if(dimension/2 > j){
                        board[i][j].setCOX(xs + j);
                    }else{
                        board[i][j].setCOX(xs + j + 1);
                    }
                    board[i][j].setCOY(ys - i - 1);
                }
            }
        }
    }
}