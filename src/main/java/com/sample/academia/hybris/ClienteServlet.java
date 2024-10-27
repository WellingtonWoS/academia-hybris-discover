package com.sample.academia.hybris;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="clienteServlet", urlPatterns = "/clientes")
public class ClienteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<String> clientes = new ArrayList<String>();

    clientes.add("Joao");
    clientes.add("Maria");

    req.setAttribute("clientes", clientes);

    RequestDispatcher view = req.getRequestDispatcher("result.jsp");
    view.forward(req, resp);

  }
}
