package test;

import dao.UtilisateurDAO;
import entity.Utilisateur;

public class Apptest {

	public static void main(String[] args) {
		UtilisateurDAO ud = new UtilisateurDAO();
		
		/*String[] tab = {"toto", "titi","tata","tutu","tete","tyty"};
		for (String string : tab) {
			ud.ajouter(new Utilisateur(string, string+"@"+string+".fr", string+string));
		}*/
		
		System.out.println(ud.tout());
	}
	
}
