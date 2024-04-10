package CarManage;

import java.sql.*;

public class DB_Connection {
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user = "root";
    private final String pass = "2905";
    private final String database = "CarManage";
    public Connection conn;
    public Statement stmt;

    public DB_Connection() throws SQLException {
        this.conn = DriverManager.getConnection(url + database, user, pass);
        this.stmt = conn.createStatement();
        if (conn != null) System.out.println("DB_Connection - Connected");
        else System.out.println("DB_Connection - Failed to connect");
    }

    public String queryAll(String table) throws SQLException {
        String query = "SELECT * FROM " + table;
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        StringBuilder result = new StringBuilder();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                result.append(rs.getString(i)).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public void addCar(String id, String brand, int year, int price, String color, int slots, String engineType) {
        try {
            String query = "INSERT INTO Car (id, brand, releaseYear, price, color, slots, engineType) VALUES ('" + id + "', '" + brand + "', " + year + ", " + price + ", '" + color + "', " + slots + ", '" + engineType + "')";
            if (checkExistVehicle(id, "Car")) {
                System.out.println("Car already exists");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
        }
    }

    public void deleteCar(String id) {
        try {
            String query = "DELETE FROM Car WHERE id = '" + id + "'";
            if (!checkExistVehicle(id, "Car")) {
                System.out.println("Car not found");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Car not found");
        }
    }

    public void addMotorbike(String id, String brand, int year, int price, String color, int capacity) {
        try {
            String query = "INSERT INTO Motorbike (id, brand, releaseYear, price, color, capacity) VALUES ('" + id + "', '" + brand + "', " + year + ", " + price + ", '" + color + "', " + capacity + ")";
            if (checkExistVehicle(id, "Motorbike")) {
                System.out.println("Motorbike already exists");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Motorbike already exists");
        }
    }

    public void deleteMotorbike(String id) {
        try {
            String query = "DELETE FROM Motorbike WHERE id = '" + id + "'";
            if (!checkExistVehicle(id, "Motorbike")) {
                System.out.println("Motorbike not found");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Motorbike not found");
        }
    }

    public void addTruck(String id, String brand, int year, int price, String color, int loadWeight) {
        try {
            String query = "INSERT INTO Truck (id, brand, releaseYear, price, color, loadWeight) VALUES ('" + id + "', '" + brand + "', " + year + ", " + price + ", '" + color + "', " + loadWeight + ")";
            if (checkExistVehicle(id, "Truck")) {
                System.out.println("Truck already exists");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Truck already exists");
        }
    }

    public void deleteTruck(String id) {
        try {
            String query = "DELETE FROM Truck WHERE id = '" + id + "'";
            if (!checkExistVehicle(id, "Truck")) {
                System.out.println("Truck not found");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Truck not found");
        }
    }

    public void modifyCar(String id, String brand, int year, int price, String color, int slots, String engineType) {
        try {
            String query = "UPDATE Car SET brand = '" + brand + "', year = " + year + ", price = " + price + ", color = '" + color + "', slots = " + slots + ", engineType = '" + engineType + "' WHERE id = '" + id + "'";
            if (!checkExistVehicle(id, "Car")) {
                System.out.println("Car not found");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Car not found");
        }
    }

    public void modifyMotorbike(String id, String brand, int year, int price, String color, int capacity) {
        try {
            String query = "UPDATE Motorbike SET brand = '" + brand + "', year = " + year + ", price = " + price + ", color = '" + color + "', capacity = " + capacity + " WHERE id = '" + id + "'";
            if (!checkExistVehicle(id, "Motorbike")) {
                System.out.println("Motorbike not found");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Motorbike not found");
        }
    }

    public void modifyTruck(String id, String brand, int year, int price, String color, int loadWeight) {
        try {
            String query = "UPDATE Truck SET brand = '" + brand + "', year = " + year + ", price = " + price + ", color = '" + color + "', loadWeight = " + loadWeight + " WHERE id = '" + id + "'";
            if (!checkExistVehicle(id, "Truck")) {
                System.out.println("Truck not found");
                return;
            }
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Truck not found");
        }
    }

    private boolean checkExistVehicle(String idVehicle, String table) {
        String query = "SELECT * FROM " + table + " WHERE id = '" + idVehicle + "'";
        try {
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + ' ' + e.getMessage());
            return false;
        }
    }

    void close() {
        try {
            conn.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + ' ' + e.getMessage());
        }
    }
}
