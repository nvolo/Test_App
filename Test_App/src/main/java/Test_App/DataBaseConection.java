package Test_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

public class DataBaseConection {

    private static DataBaseConection instance;
    private Connection connection;
    String connectionUrl = "jdbc:sqlserver://localhost:1434;databaseName=Test_App;user=zippy;password=zippy";

    public static DataBaseConection getInstance() {
        if (instance == null) {
            instance = new DataBaseConection();
        }
        return instance;
    }

    public DataBaseConection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    StringBuilder query = new StringBuilder();

    public DataBaseConection select(String select) {
        query.append("SELECT ").append(select);
        return this;
    }

    public DataBaseConection from(String from) {
        query.append(" FROM ").append(from);
        return this;
    }

    public DataBaseConection where(String whereCondition) {
        query.append(" WHERE ").append(whereCondition);
        return this;
    }

    public DataBaseConection orderBy(String column, Boolean ascending) {
        query.append(" ORDER BY ")
                .append(column)
                .append(ascending ? " ASC " : " DECS ");
        return this;
    }

    public DataBaseConection sum(String column) {
        query.append(" SUM ")
                .append(column);
        return this;
    }

    public DataBaseConection as(String column) {
        query.append(" AS ").append(column);
        return this;
    }

    public DataBaseConection dropTable(String tableName) {
        query.append(" DROP TABLE ")
                .append(tableName);
        return this;
    }

    public DataBaseConection insert(String tableName, List<String> columns, List arguments) {
        query.append(" INSERT INTO ")
                .append(tableName)
                .append(" ( ")
                .append(join(" , ", columns))
                .append(" ) ")
                .append(" VALUES ")
                .append(" ( ")
                .append(join(" , ", arguments))
                .append(" ) ");
        return this;
    }

    public DataBaseConection createTable(String tableName, List<String> columns) {
        query.append(" CREATE TABLE ")
                .append(tableName)
                .append(" ( ")
                .append(join(" , ", columns))
                .append(" ) ");
        return this;
    }

    public ResultSet executeQuery() throws SQLException {
        return connection.prepareStatement(query.toString()).executeQuery();
    }

    public int executeUpdate() throws SQLException {
        return connection.prepareStatement(query.toString()).executeUpdate();
    }

    public boolean execute() throws SQLException {
        return connection.prepareStatement(query.toString()).execute();
    }

    public String getQuery() {
        return query.toString();
    }

    public static void main(String[] args) throws SQLException {
        DataBaseConection dataBaseConection = getInstance();

        ResultSet result = dataBaseConection
                .select("")
                .sum("([type])")
                .as("sum")
                .from("[Test_App].[dbo].[transaction_categories]")
                .executeQuery();

        while (result.next()) {
            int i = result.getInt("sum");
            System.out.println(i);
        }
    }
}

