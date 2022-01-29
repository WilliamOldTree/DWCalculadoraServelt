package com.rd.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rd.model.Calculo;

/**
 * Servlet implementation class Calculadora
 */
@WebServlet("/Calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculadora() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((request.getParameter("valor1") != null) && (request.getParameter("valor2") != null)) {

			int var1 = Integer.parseInt(request.getParameter("valor1"));
			int var2 = Integer.parseInt(request.getParameter("valor2"));

			String operacao = request.getParameter("cmd");
			Calculo calculo = new Calculo(var1, var2);
			int resultado = 0;

			switch (operacao) {

			case "+":
				resultado = calculo.somar();

				break;

			case "-":
				resultado = calculo.subtrair();
				break;

			case "*":
				resultado = calculo.multiplicar();
				break;

			case "/":
				resultado = calculo.dividir();
				break;

			}

			request.setAttribute("res", resultado);

			request.getRequestDispatcher("/").forward(request, response);

		} // end if

	
	}// end doPost

	
}//end servlet
