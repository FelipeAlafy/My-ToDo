package mytodo.disc;

/**
 *
 * @author falaf
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Disc {
    String dir = System.getProperty("user.dir");
    public boolean createFolder(String folder) { 
        Path path = Paths.get(folder);
        try {
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Disc.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean writer(String folder, String fileToRead, ArrayList<String> toWrite){
        File file = new File(folder + "/" + fileToRead + ".know");
        Path path = file.toPath();
        try {
            // Deleting file exists
            if(Files.exists(path)) {
                Files.delete(path);
            }
            
            // Writing
            BufferedWriter  writer = new BufferedWriter(new FileWriter(file));
            for (int row = 0; row < toWrite.size(); row++) {
                writer.write(toWrite.get(row));
                writer.newLine();
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Disc.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
