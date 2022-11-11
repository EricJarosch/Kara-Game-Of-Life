import javakara.JavaKaraProgram;
public class Sortieren extends JavaKaraProgram {

  public void myProgram() {
  
    int data[] = new int[world.getSizeY()];
    for (int y = 0; y < world.getSizeY(); y++) {
        int count = 0;
        for (int x = 0; x < world.getSizeX(); x++) {
            if (world.isLeaf(x,y)) {
                count++;
            }
      }
      data[y] = count;
    }
    for (int length = data.length-1; length >= 0; length--) {
        for (int pos = 0; pos < length; pos++) {
            if (data[pos] > data[pos+1]) {
                int save = data[pos];
	            data[pos] = data[pos+1];
	            data[pos+1] = save;
            }
        }
    }
	   for (int y = 0; y < world.getSizeY(); y++) {
	       tools.println("Zeile"+y+":"+data[y]);
           for (int x = 0; x < world.getSizeX(); x++) {
               boolean leaf = x < data[y];
               world.setLeaf(x,y,leaf);
           }
	   }
  }
}

        
