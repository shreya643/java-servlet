package controller;

import domain.SuperHeroes;
import services.SuperHeroesService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SuperHeroesServlet")
public class SuperHeroesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check=request.getParameter("pageRequest");

        if(check.equalsIgnoreCase("new"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("superhero/create.jsp");
            rd.forward(request, response);
        }

        if (check.equalsIgnoreCase("list"))
        {
            List <SuperHeroes> heroes= new SuperHeroesService().getSuperHeroesList();
            request.setAttribute("superHeroList", heroes);
            RequestDispatcher rd = request.getRequestDispatcher("superhero/list.jsp");
            rd.forward(request, response);

        }
        if(check.equalsIgnoreCase("delete"))
        {
            Integer id= Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            new SuperHeroesService().deleteSuperHeroes(id);

            response.sendRedirect("displayHero?pageRequest=list");
        }

        if(check.equalsIgnoreCase("edit"))
        {
            Integer id= Integer.parseInt(request.getParameter("id"));
            SuperHeroes heroes=new SuperHeroesService().getSuperHero(id);
            request.setAttribute("hero", heroes);
            RequestDispatcher rd = request.getRequestDispatcher("superhero/edit.jsp");
            rd.forward(request, response);
        }
        if(check.equalsIgnoreCase("create"))
        {
            String name=request.getParameter("name");
            String universe=request.getParameter("universe");
            String powers=request.getParameter("power");
            new SuperHeroesService().addSuperHeroes(name,universe,powers);
            System.out.println("hi");
            response.sendRedirect("displayHero?pageRequest=list");
        }
        if(check.equalsIgnoreCase("editHero"))
        {
            String name=request.getParameter("name");
            String universe=request.getParameter("universe");
            String powers=request.getParameter("power");
            Integer id=Integer.parseInt(request.getParameter("id"));
            new SuperHeroesService().editSuperHeroes(id,name,universe,powers);
            response.sendRedirect("displayHero?pageRequest=list");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
