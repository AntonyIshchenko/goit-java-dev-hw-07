import utils.FileReader;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {
        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            String sql = FileReader.read("sql/init_db.sql");
            int result = st.executeUpdate(sql);
            System.out.println("Initialization " + (result == 0 ? "successful" : "error"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
