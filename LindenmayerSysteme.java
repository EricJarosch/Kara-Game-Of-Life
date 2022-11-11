import javakara.JavaKaraProgram;
public class LindenmayerSysteme extends JavaKaraProgram {

  public void myProgram() {
   
    String word = "AAAAAXAAAAXAAAARTO";
    word = word.replace("O", "RFRFRRAAAAAXAAAAXAAAART");
    word = word.replace("T", "AAAAXAAAAXAAAAL");
    word = word.replace("X", "RAFPLFPLFPLFRDR");
    word = word.replace("A", "DP");
    word = word.replace("D", "FLFR");
    tools.println(word);
      for (char letter : word.toCharArray()) {
        if (letter == 'R') {
            kara.turnRight();
        }
        else if (letter == 'L') {
            kara.turnLeft();
        }
        else if (letter == 'F') {
            kara.move();
        }
        else if (letter == 'P') {
          if (!kara.onLeaf()) {
            kara.putLeaf();
        }
        }
       }
     
   }
 }

        
