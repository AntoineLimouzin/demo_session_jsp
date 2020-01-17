package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Utilisateur;

public class UtilisateurDAO {
	
	String PU = "01_demo_gestion_session";
	
	public void ajouter(Utilisateur user)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		manager.close();
		emf.close();
	}
	
	public void modifier(Utilisateur user)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(user);
		transaction.commit();
		manager.close();
		emf.close();
	}
	
	public void supprimer(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(manager.find(Utilisateur.class, id));
		transaction.commit();
		manager.close();
		emf.close();
	}
	
	public Utilisateur trouverParId(int id)
	{
		return Persistence.createEntityManagerFactory(PU).createEntityManager().find(Utilisateur.class, id);
	}
	
	public List<Utilisateur> tout()
	{
		return Persistence.createEntityManagerFactory(PU).createEntityManager()
				.createNamedQuery("Utilisateur.findAll").getResultList();
	}
	
	public Long existe(String mail, String mdp)
	{
		Query query = Persistence.createEntityManagerFactory(PU).createEntityManager().createNamedQuery("Utilisateur.exists");
		query.setParameter("email", mail);
		query.setParameter("password", mdp);
		return (Long) query.getSingleResult();
	}

}
