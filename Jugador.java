import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class Jugador
{
    private ArrayList<Cell> fichas;
    public Jugador(){
        fichas = new ArrayList<Cell>();
    }
    
    public void aniadirFicha(int x,int y, int xS, int yS){
        Cell ficha = new Cell(x, y);
        ficha.setCoxCoy(xS, yS);
        fichas.add(ficha);
    }
    
    public boolean estaSinFichas(){
        if(fichas.isEmpty())  return true;
        else return false;
    }
    
    public void eliminarFicha(int x,int y){
        boolean encontrado = false;
        int pos = 0;
        while(encontrado == false && pos < fichas.size()){
            if(fichas.get(pos).estaPos(x, y)){
                encontrado = true;
                x = fichas.get(pos).getX();
                y = fichas.get(pos).getY();
                fichas.remove(pos);
            }
            pos++;
        }
        if(encontrado == true){
            Main.board.board[x][y].getFigura().matar();
        }
    }
}
