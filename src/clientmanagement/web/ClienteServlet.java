package clientmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import clientmanagement.dao.ClienteDAO;
import clientmanagement.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClienteServlet
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */
@WebServlet("/")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;

	
    public ClienteServlet() {
    	this.clienteDAO = new ClienteDAO();
 
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			try {
				showNewForm(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
			break;
		case "/insert":
			try {
				insertCliente(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteCliente(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateCliente(request, response);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		default:
			try {
				listClientes(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void listClientes (HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws SQLException, IOException {
		List<Cliente> listClientes = clienteDAO.selectAllClientes();
		request.setAttribute("listClientes", listClientes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-list.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String dtNasc = request.getParameter("dt_nasc");
		String sexo = request.getParameter("sexo");
		String estadoCivil = request.getParameter("estado_civil");
		Cliente cliente = new Cliente(cpf, nome, email, dtNasc, sexo, estadoCivil, true);
		clienteDAO.updateCliente(cliente);
		response.sendRedirect("list");
	
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String cpf = request.getParameter("cpf");
		Cliente existingCliente = clienteDAO.selectCliente(cpf);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		request.setAttribute("cliente", existingCliente);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String cpf = request.getParameter("cpf");
		ClienteDAO.deleteCliente(cpf);
		response.sendRedirect("list");
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String dtNasc = request.getParameter("dt_nasc");
		String sexo = request.getParameter("sexo");
		String estadoCivil = request.getParameter("estado_civil");
		clienteDAO.insertCliente(new Cliente(cpf, nome, email, dtNasc, sexo, estadoCivil, true));
		response.sendRedirect("list");
	}
}
