package controller;

import model.Employe;
import service.EmployeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeController", urlPatterns = "/employeController")
public class EmployeController extends HttpServlet {
    private static int isInteger(String param) {
        try {
            return Integer.parseInt(param);
        } catch (Exception e) {
            return 0;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("ISO-8859-9");
        resp.setCharacterEncoding("ISO-8859-9");
        List<Employe> allEmployes = null;
        try {
            String employeName = (req.getParameter("name") == "") ? null : req.getParameter("name");
            String employeSurname = (req.getParameter("surname") == "") ? null : req.getParameter("surname");
            int employeSalary = isInteger(req.getParameter("salary"));
            EmployeServiceImpl employeService = new EmployeServiceImpl();
            Employe employe = new Employe(employeName, employeSurname, employeSalary);
            if (employeName != null && employeSurname != null)
                employeService.insertEmploye(employe);
            allEmployes = employeService.findAllEmployes();
            req.setAttribute("allEmployes", allEmployes);
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-Exception POST-");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("ISO-8859-9");
        resp.setCharacterEncoding("ISO-8859-9");
        List<Employe> allEmployes = null;
        try {
            EmployeServiceImpl employeService = new EmployeServiceImpl();
            if (req.getParameter("employeId") != null){
                int employeId = isInteger(req.getParameter("employeId"));
                employeService.removeEmploye(employeId);
            }
            allEmployes = employeService.findAllEmployes();
            req.setAttribute("allEmployes", allEmployes);
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-Exception GET-");
        }

    }
}
