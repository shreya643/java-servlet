package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseExample {

     public void insert() {
         DatabaseConnection connection= new DatabaseConnection();
         String query = "Insert into user(name,password,role)" + "values(?,?,?)";
         try {
                PreparedStatement pstm = connection.getPrepareStatement(query);
                pstm.setString(1, "Shreya");
                pstm.setString(2, "Shreya");
                pstm.setString(3, "Shreya");


                pstm.execute();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public void delete() {
        DatabaseConnection connection= new DatabaseConnection();
        String query = "Delete from user where id=?";
        try {
            PreparedStatement pstm = connection.getPrepareStatement(query);
            pstm.setInt(1,1);
            pstm.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        DatabaseConnection connection= new DatabaseConnection();
        String query = "Update user set role=? where id=?";
        try {
            PreparedStatement pstm = connection.getPrepareStatement(query);

            pstm.setString(1,"Admin");
            pstm.setInt(2,1);
            pstm.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void select() {
        DatabaseConnection connection= new DatabaseConnection();
        String query = "Select * from user where id=?";
        try {
            PreparedStatement pstm = connection.getPrepareStatement(query);

            pstm.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) {
         DatabaseExample db=new DatabaseExample();
        // db.insert();
         //db.delete();
//            db.update();
//         db.select();

        }
    }
