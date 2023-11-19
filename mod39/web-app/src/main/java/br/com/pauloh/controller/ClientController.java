package br.com.pauloh.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pauloh.model.Client;
import br.com.pauloh.service.ClientService;
import java.io.IOException;

@WebServlet("/ClientController")
public class ClientController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setPhone(phone);

        ClientService clientService = new ClientService();

        Client createdClient = clientService.create(client);

        response.getWriter().println("Created client with ID: " + createdClient.getId());
    }
}