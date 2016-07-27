package Test;

import com.pfariasmunoz.swing.model.AgeCategory;
import com.pfariasmunoz.swing.model.Database;
import com.pfariasmunoz.swing.model.EmploymentCategory;
import com.pfariasmunoz.swing.model.GenderCategory;
import com.pfariasmunoz.swing.model.Person;
import java.sql.SQLException;

public class TestDatabase {
    
    public static void main(String[] args) throws SQLException {
        System.out.println("Running database test");
        
        Database db = new Database();
    
        try {
            db.connect();
            db.save();
        } catch (Exception ex) {
            ex.getMessage();
        }
        db.addPerson(new Person("Joe", "lion tamer", AgeCategory.ADULT, EmploymentCategory.EMPLOYED, "777", true, GenderCategory.MALE));
        db.addPerson(new Person("Sue", "artist", AgeCategory.ADULT, EmploymentCategory.SELF_EMPLOYED, null, false, GenderCategory.FEMALE));

        
        
        try {
            db.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    
        db.disconnect();
    }
    
    
    
}
