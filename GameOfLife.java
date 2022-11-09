import javakara.JavaKaraProgram;
public class GameOfLife extends JavaKaraProgram {

  public void myProgram() {
      
    int width = world.getSizeX();
    int height = world.getSizeY();
    while (true) {
    // Zuerst wird die Größe der Welt rausgelesen.
        boolean newWorld[][] = new boolean[width][height];
        for (int x=0; x < width; x++) {
            for (int y=0; y < height; y++) {
    // Dann werden alle Nachbarn der Felder erkannt.
                int leafCount = 0;
                if (isInWorld(x,y+1)&&world.isLeaf(x,y+1)) {
                 leafCount++;   
                }
                if (isInWorld(x+1,y+1)&&world.isLeaf(x+1,y+1)) {
                 leafCount++;   
                }
                if (isInWorld(x+1,y)&&world.isLeaf(x+1,y)) {
                 leafCount++;   
                }
                if (isInWorld(x,y-1)&&world.isLeaf(x,y-1)) {
                 leafCount++;   
                }
                if (isInWorld(x-1,y)&&world.isLeaf(x-1,y)) {
                 leafCount++;   
                }
                if (isInWorld(x-1,y-1)&&world.isLeaf(x-1,y-1)) {
                 leafCount++;   
                }
                if (isInWorld(x-1,y+1)&&world.isLeaf(x-1,y+1)) {
                 leafCount++;   
                }
                if (isInWorld(x+1,y-1)&&world.isLeaf(x+1,y-1)) {
                 leafCount++;   
                }
                if (leafCount < 2||leafCount > 3) {
                    newWorld[x][y] = false;
                }
                else if (leafCount == 2) {
                    newWorld[x][y] = world.isLeaf(x,y);
                }
                else if (leafCount == 3) {
                    newWorld[x][y] = true;
                }
            }
        }
        for (int x=0; x < width; x++) {
            for (int y=0; y < height; y++) {
                world.setLeaf(x, y, newWorld[x][y]);
            }
            
        }
    // Dieser Befehl lässt das Spiel flüssiger laufen.
        tools.checkState();
    }
  }
    // Hier wird darüber entschieden, was mit einer Zelle passiert.
  boolean isInWorld (int x, int y) {
    if (y < 0) {
        return false;
    }
    if (x < 0) {
        return false;
    }
    if (world.getSizeX() <= x) {
        return false;
    }
    if (world.getSizeY() <= y) {
        return false;   
    }
    return true;
    
  }
}

        
