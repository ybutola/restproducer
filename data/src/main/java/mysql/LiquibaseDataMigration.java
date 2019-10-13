package mysql;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class LiquibaseDataMigration {
    public static void main(String[] args) {
        runLiquibase();
    }

    public static void runLiquibase() {
        Liquibase liquibase;
        Connection connection = null;
        Properties properties = getProperties();

        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
            liquibase = new Liquibase(properties.getProperty("changeLogFile"), new ClassLoaderResourceAccessor(), database);
            liquibase.update("butola");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new NoSuchElementException(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.rollback();
                    connection.close();
                } catch (SQLException e) {
                    //nothing to do
                }
            }
        }
    }

    private static Properties getProperties() {
        Properties properties = null;
        try (InputStream input = new FileInputStream("data/src/main/resources/liquibase.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
