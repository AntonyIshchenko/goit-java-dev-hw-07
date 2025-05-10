import model.*;

import java.util.List;

public class DatabaseQueryTest {
    public static void main(String[] args) {
        String delimiter = "----------------------";
        List<ProjectDuration> longestProjects = DatabaseQueryService.findLongestProject();
        System.out.println("longestProjects = " + longestProjects);

        System.out.println(delimiter);

        List<ClientProjectCount> maxProjectCountClient = DatabaseQueryService.findMaxProjectsClient();
        System.out.println("maxProjectCountClient = " + maxProjectCountClient);

        System.out.println(delimiter);

        List<WorkerSalary> maxSalaryWorkers = DatabaseQueryService.findMaxSalaryWorker();
        System.out.println("maxSalaryWorkers = " + maxSalaryWorkers);

        System.out.println(delimiter);

        List<WorkerAgeTypesDetail> youngestEldestWorkers = DatabaseQueryService.findYoungestEldestWorkers();
        System.out.println("youngestEldestWorkers = " + youngestEldestWorkers);

        System.out.println(delimiter);

        List<ProjectPrice> projectPrices = DatabaseQueryService.getProjectPrices();
        System.out.println("projectPrices = " + projectPrices);

        DatabaseQueryService.closeStatements();
    }
}
