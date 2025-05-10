import utils.FileReader;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {
        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            String sql = FileReader.read("sql/populate_db.sql");
            int result = st.executeUpdate(sql);
            System.out.println("Population " + (result == 0 ? "successful" : "error"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
