
public class Cell {
    private final int x, y;
    private int coX, coY;
    private Figura figura;
    
    public Cell(int x, int y, Figura figura){
        this.x = x;
        this.y = y;
        this.figura = figura;
    }
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        figura = null;
    }
    public boolean estaPos(int xs, int ys){
        if(xs == this.coX && ys == this.coY) return true;
        else return false;
    }
    public Figura getFigura(){
        return figura;
    }
    public void setFigure(Figura figura){
        this.figura = figura;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getCOX() {
        return coX;
    }
    public int getCOY() {
        return coY;
    }
    public void setCOX(int cox){
        this.coX = cox;
    }
    public void setCOY(int coy){
        this.coY = coy;
    }
    public void setCoxCoy(int cox, int coy){
        this.coX = cox;
        this.coY = coy;
    }
}