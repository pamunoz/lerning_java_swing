package Test;

import com.pfariasmunoz.swing.model.Database;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDatabase {
    
    public static void main(String[] args) {
        System.out.println("Running database test");
        
        Database db = new Database();
    
        try {
            db.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
        db.disconnect();
    }
    
    
    
}
