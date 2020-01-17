package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDAO;
import entity.Utilisateur;

public class AuthentificationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if ("true".equals(request.getParameter("destroy"))) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession(true);//true : creer si existe pas
		
		if (session.getAttribute("isLogged") != null) {
			request.getRequestDispatcher("/accueil.jsp").forward(request, response);
		}
		
		
		String login = request.getParameter("pIdentifiant");
		String pwd = request.getParameter("pMdp");
		List<String> errors = new ArrayList<>();
		
		if (login == null || pwd == null)
		{
			errors.add("erreur");
			//request.getRequestDispatcher("/erreurs.jsp").forward(request, response);
		}
		else if ("".equals(login)) 
		{
			errors.add("login obligatoire");
			//request.getRequestDispatcher("/erreurs.jsp").forward(request, response);
		}
		else if ("".equals(pwd)) 
		{
			errors.add("password obligatoire");
			//request.getRequestDispatcher("/erreurs.jsp").forward(request, response);
		}
		
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/erreurs.jsp").forward(request, response);
		}
		
		UtilisateurDAO ud = new UtilisateurDAO();
		
		if (ud.existe(login, pwd) == 0)
		{
			errors.add("identifiants inconnus");
			request.getRequestDispatcher("/erreurs.jsp").forward(request, response);
		}
		else
		{
			session.setAttribute("isLogged", "true");
			session.setAttribute("userLogin", login);
			List<Utilisateur> utilisateurs = ud.tout();
			request.setAttribute("users", utilisateurs);
			request.getRequestDispatcher("/accueil.jsp").forward(request, response);
		}
	}
	
	

}
