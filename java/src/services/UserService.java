package services;

import database.DatabaseConnection;
import domain.User;
import sun.rmi.server.UnicastServerRef;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public User getUser(String username, String password)
    {
        User user=null;

        String query="Select * from student where name=? and password=?";
        try {
            PreparedStatement pstm =new DatabaseConnection().getPrepareStatement(query);
            pstm.setString(1,username);
            pstm.setString(2,password);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return  user;
    }

    public List<User> getUserList()
    {
        User user=null;
        List<User> userList= new ArrayList<>();
        try {
            String query="Select * from student" ;
            PreparedStatement pstm =new DatabaseConnection().getPrepareStatement(query);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return  userList;
    }

    public void setUser(String username, String password, String role)
    {
        String query = "Insert into student(name,password,role)" + "values(?,?,?)";
        try {
            PreparedStatement pstm = new DatabaseConnection().getPrepareStatement(query);
            pstm.setString(1,username );
            pstm.setString(2, password);
            pstm.setString(3, role);

            pstm.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser( Integer id)
    {
        String query = "Delete from student where id = ? ";


        try {
            PreparedStatement pstm = new DatabaseConnection().getPrepareStatement(query);
            pstm.setInt(1,id);
            System.out.println(query);
            System.out.println(id);
            pstm.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateUser(String name,String role, String password, Integer id)
    {
        String query="Update student set name=? ,role=? , password=? where id=?";
        try{
            PreparedStatement pstm = new DatabaseConnection().getPrepareStatement(query);
            pstm.setString(1,name );
            pstm.setString(2, role);
            pstm.setString(3, password);
            pstm.setInt(4,id);
            pstm.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
