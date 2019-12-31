import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Figura extends JButton implements ActionListener{
    private final int xSolPos, ySolPos;
    private int xPos, yPos;
    private int dimension;
    private boolean ocupado;
    public Figura(int xSolPos, int ySolPos, ImageIcon subimage, int dimension)
    {
        this.xSolPos = xSolPos;
        this.ySolPos = ySolPos;
        this.dimension = 15;
        this.xPos = xSolPos;
        this.yPos = ySolPos;
        this.setIcon(subimage);
        this.setPreferredSize(new Dimension(subimage.getIconWidth(), subimage.getIconHeight()));
        this.addActionListener(this); 
    }

    public int getxPos() { return xPos; }
    public void setxPos(int xPos) { this.xPos = xPos; }
    public int getyPos() { return yPos; }
    public void setyPos(int yPos) { this.yPos = yPos; }
    public int getxSolPos() { return xSolPos; }
    public int getySolPos() { return ySolPos; }
    public void setXYPos(int xPos, int yPos) { 
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        try{
            if(Main.turno > 9 && Main.turno < 20 && ocupado == false){
                setIcon(new ImageIcon(ImageIO.read(new File("red.jpg"))));
                ocupado = true;
                Main.jugador2.aniadirFicha(xSolPos, ySolPos, Main.board.board[xSolPos][ySolPos].getCOX(),Main.board.board[xSolPos][ySolPos].getCOY());
                Main.turno++;
            }else if(Main.turno < 10 && ocupado == false){
                setIcon(new ImageIcon(ImageIO.read(new File("green.jpg"))));
                ocupado = true;
                Main.jugador1.aniadirFicha(xSolPos, ySolPos, Main.board.board[xSolPos][ySolPos].getCOX(),Main.board.board[xSolPos][ySolPos].getCOY());
                Main.turno++;
            }            
        }catch(IOException e){}
    }
    
    public void matar(){
        try{
            setIcon(new ImageIcon(ImageIO.read(new File("dead.jpg"))));
        }catch(IOException e){}
    }
}