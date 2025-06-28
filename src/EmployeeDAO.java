import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    public static void insertEmployee(Employee emp) throws SQLException {
        String query = Query.getInsertQuery();

        try (Connection con = DB.connect();
             PreparedStatement statement = con.prepareStatement(query)) {

            statement.setInt(1, emp.getId());
            statement.setString(2, emp.getName());
            statement.setInt(3, emp.getAge());
            statement.setDouble(4, emp.getSalary());

            int rowCount = statement.executeUpdate();
            System.out.println("Query OK, " + rowCount + " row affected\n");
        }
    }

    public static ArrayList<Employee> readEmployee() throws SQLException {
        String query = Query.getReadQuery();

        try (Connection con = DB.connect();
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query)) {

            ArrayList<Employee> list = new ArrayList<>();

            while (res.next()) {
                Employee employee = new Employee(res.getInt("id"), res.getString("name"), res.getInt("age"), res.getDouble("salary"));
                list.add(employee);
            }
            return list;
        }
    }

    public static void updateEmployee(String name, int id) throws SQLException {
        String query = Query.getUpdateQuery();
        try (Connection con = DB.connect();
             PreparedStatement statement = con.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setInt(2, id);

            int rowCount = statement.executeUpdate();
            System.out.println("Query OK, " + rowCount + " row affected\n");
            if (rowCount == 0) {
                System.out.println("No employee found with ID: " + id);
            }
        }
    }

    public static void deleteEmployee(int id) throws SQLException {
        String query = Query.getDeleteQuery();
        try (Connection con = DB.connect();
             PreparedStatement statement = con.prepareStatement(query)) {

            statement.setInt(1, id);

            int rowCount = statement.executeUpdate();

            System.out.println("Query OK, " + rowCount + " row affected\n");
            if (rowCount == 0) {
                System.out.println("No employee found with ID: " + id);
            }
        }
    }
}
