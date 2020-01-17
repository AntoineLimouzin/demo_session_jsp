package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	
	@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u"),
	@NamedQuery(name="Utilisateur.exists", query="SELECT COUNT(u) FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :password")
	
})
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUtilisateur;
	
	private String nom;
	private String email;
	private String motDePasse;
	
	public Utilisateur() {
		
	}

	public Utilisateur(int idUtilisateur, String nom, String email, String motDePasse) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Utilisateur(String nom, String email, String motDePasse) {
		super();
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", email=" + email + ", motDePasse="
				+ motDePasse + "]";
	}

}
