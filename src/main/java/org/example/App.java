package org.example;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.log4j.Logger;
import org.example.data_base_entities.FlywayConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("Start of the program");

        FlywayConfig.fwMigration();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OsbbPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Object[]> result = new CriteriaAPI().carEntranceCriteriaSelect(entityManager);
        printResultToConsole(result);
        String filePath = "JPA_example/result.txt";
        printResultToFile(result, filePath);
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void printResultToConsole(List<Object[]> list) {
        for (Object[] result : list) {
            System.out.print(result[0] + ", ");
            System.out.print(result[1] + " ");
            System.out.print(result[2] + ", ");
            System.out.print(result[3] + ", ");
            System.out.print(result[4] + ", ");
            System.out.print(result[5] + ", ");
            System.out.print(result[6] + ", ");
            System.out.print(result[7] + ", ");
            System.out.println(result[8] + ", ");
        }
    }

    public static void printResultToFile(List<Object[]> list, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.newLine();

            for (Object[] row : list) {
                for (int i = 0; i < row.length; i++) {
                    writer.write(String.valueOf(row[i]));
                    if (i < row.length - 1) {
                        if(i==1){
                            writer.write(" ");
                        }
                        else {
                            writer.write(", ");
                    }}
                }
                writer.newLine();
            }

            System.out.println("Results have been written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
