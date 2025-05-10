import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;

    private Database() {

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("./config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.username"),
                    props.getProperty("db.password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
