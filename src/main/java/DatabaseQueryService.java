import model.*;
import utils.FileReader;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DatabaseQueryService {
    private static final Connection connection = Database.getInstance().getConnection();
    private static final ConcurrentMap<String, PreparedStatement> statements = new ConcurrentHashMap<>();

    private DatabaseQueryService() {
    }

    private static PreparedStatement getPreparedStatement(String name, String sqlFileName) throws SQLException {
        return statements.computeIfAbsent(name, key -> {
            try {
                String sql = FileReader.read(sqlFileName);
                return connection.prepareStatement(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException("Error in preparing statements for " + name, ex);
            }
        });
    }

    public static void closeStatements() {
        statements.forEach((name, statement) -> {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static List<ClientProjectCount> findMaxProjectsClient() {
        String cachedName = "findMaxProjectsClient";
        String sqlFileName = "sql/find_max_projects_client.sql";
        List<ClientProjectCount> result = new ArrayList<>();

        try {
            PreparedStatement ps = getPreparedStatement(cachedName, sqlFileName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int projectCount = rs.getInt("project_count");

                result.add(new ClientProjectCount(name, projectCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<ProjectDuration> findLongestProject() {
        String cachedName = "findLongestProject";
        String sqlFileName = "sql/find_longest_project.sql";
        List<ProjectDuration> result = new ArrayList<>();

        try {
            PreparedStatement ps = getPreparedStatement(cachedName, sqlFileName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int duration = rs.getInt("month_count");

                result.add(new ProjectDuration(name, duration));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<WorkerSalary> findMaxSalaryWorker() {
        String cachedName = "findMaxSalaryWorker";
        String sqlFileName = "sql/find_max_salary_worker.sql";
        List<WorkerSalary> result = new ArrayList<>();

        try {
            PreparedStatement ps = getPreparedStatement(cachedName, sqlFileName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");

                result.add(new WorkerSalary(name, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<WorkerAgeTypesDetail> findYoungestEldestWorkers() {
        String cachedName = "findYoungestEldestWorkers";
        String sqlFileName = "sql/find_youngest_eldest_workers.sql";
        List<WorkerAgeTypesDetail> result = new ArrayList<>();

        try {
            PreparedStatement ps = getPreparedStatement(cachedName, sqlFileName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                Date birthday = rs.getDate("birthday");

                result.add(new WorkerAgeTypesDetail(type, name, birthday));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<ProjectPrice> getProjectPrices() {
        String cachedName = "getProjectPrices";
        String sqlFileName = "sql/print_project_prices.sql";
        List<ProjectPrice> result = new ArrayList<>();

        try {
            PreparedStatement ps = getPreparedStatement(cachedName, sqlFileName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");

                result.add(new ProjectPrice(name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
