import java.io.FileWriter;
import java.util.Random;

public class map_generate {
    public static void main(String[] args){

        int rows = 14;
        int columns = 18;
        Random random = new Random();

        try(FileWriter writer = new FileWriter("D:\\Zufar's stuff\\My2Dgame\\src\\maps\\map01.txt")){
            for(int i = 0; i < rows; i++){
                for (int k = 0; k < columns; k++){
                    System.out.print(random.nextInt(3) + " ");
                    writer.write(random.nextInt(3) + " ");
                }
                System.out.println();
                writer.write("\n");
            }
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
