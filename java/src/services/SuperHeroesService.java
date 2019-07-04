package services;

import database.DatabaseConnection;
import domain.SuperHeroes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperHeroesService {

    public List<SuperHeroes> getSuperHeroesList()
    {
        SuperHeroes hero =null;
        List<SuperHeroes> SuperHeroesList= new ArrayList<>();
        try {
            String query="Select * from superHeroes" ;
            PreparedStatement pstm =new DatabaseConnection().getPrepareStatement(query);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                 hero=new SuperHeroes();
                hero.setId(rs.getInt("id"));
                hero.setName(rs.getString("name"));
                hero.setUniverse(rs.getString("universe"));
                hero.setPowers(rs.getString("powers"));
                SuperHeroesList.add(hero);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return  SuperHeroesList;
    }

    public void addSuperHeroes(String name, String universe, String powers)
    {
        String query="Insert into superHeroes(name, universe, powers)"+"values(?,?,?)";
        try
        {

            PreparedStatement pstm =new DatabaseConnection().getPrepareStatement(query);
            pstm.setString(1,name);
            pstm.setString(2,universe);
            pstm.setString(3, powers);
            System.out.println(pstm);
            pstm.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void deleteSuperHeroes(Integer id)
    {
        String query="Delete from superHeroes where id= ?";
        System.out.println(id);
        try
        {

            PreparedStatement pstm =new DatabaseConnection().getPrepareStatement(query);
            pstm.setInt(1,id);
            pstm.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public SuperHeroes getSuperHero(Integer id)
    {
        SuperHeroes hero =null;
        String query="Select * from superHeroes where id =?";
        try
        {

            PreparedStatement pstm =new DatabaseConnection().getPrepareStatement(query);
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                 hero=new SuperHeroes();
                hero.setId(rs.getInt("id"));
                hero.setName(rs.getString("name"));
                hero.setUniverse(rs.getString("universe"));
                hero.setPowers(rs.getString("powers"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return hero;
    }

    public void editSuperHeroes(Integer id, String name, String universe, String powers)
    {
        String query="Update superHeroes set name=? ,universe=? , powers=? where id=?";
        try{
            PreparedStatement pstm = new DatabaseConnection().getPrepareStatement(query);
            pstm.setString(1,name );
            pstm.setString(2, universe);
            pstm.setString(3, powers);
            pstm.setInt(4,id);
            pstm.execute();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
