package CarManage;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DB_Connection db = new DB_Connection();
        db.addCar("123", "toyota", 2022, 150000, "Yellow", 34, "diezen");
        db.addMotorbike("234", "suzuki", 2023, 10000, "red", 38);
        db.addTruck("345", "yamaha", 1994, 20000, "black",36);
        System.out.println(db.queryAll("Car"));
        db.close();
    }
}
